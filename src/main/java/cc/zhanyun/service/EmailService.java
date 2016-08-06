package cc.zhanyun.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import cc.zhanyun.model.Info;
import cc.zhanyun.model.OfferSend;
import cc.zhanyun.model.ProjectOffer;
import cc.zhanyun.model.file.FileManager;
import cc.zhanyun.model.user.User;
import cc.zhanyun.repository.impl.FileRepoImpl;
import cc.zhanyun.repository.impl.UserRepoImpl;
import cc.zhanyun.util.RandomUtil;
import cc.zhanyun.util.TokenUtil;
import cc.zhanyun.util.fileutil.FileUtil;
import cc.zhanyun.util.myutil.Status;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private TokenUtil tokenutil;
	@Autowired
	private UserRepoImpl userImpl;
	@Autowired
	private ProjectOfferService pos;
	@Autowired
	private FileRepoImpl fileImpl;

	public Info sendAttachmentsMail(OfferSend offerSend) {
		Info in = new Info();
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			// 邮件发送设置
			helper.setFrom("hyhvpn@126.com");
			helper.setTo(offerSend.getTo());
			helper.setSubject("某某公司" + offerSend.getName() + "--报价单");
			helper.setText("某某公司" + offerSend.getName() + "--报价单");
			// 报价单附件设置 获取url 报价单 用户信息
			// String oid = tokenutil.tokenToOid();
			String oid = "57a5ab46bc9e0026bee7b255";
			// 获取user信息
			User user = userImpl.selUserById(oid);
			// 获取报价单信息
			ProjectOffer po = pos.selProjectOfferOne(offerSend.getOfferOid());
			// 获取报价单模板地址
			FileManager fileManager = fileImpl.selFileByOfferoid(offerSend.getOfferOid(), offeroid);

			// 判断如果用户没有模板，使用默认模板
			String url = null;
			if (fileManager.getUrl() == null) {
				url = "src\\main\\resources\\public\\默认报价单模板.xls";
			} else {
				url = fileManager.getUrl() + fileManager.getOthername();
			}
			// 解析报价单
			MongodbToFile(url, po, user);

			// offerSend.getOid()
			FileManager fileMagnger2 = fileImpl.fileDownload(offerSend
					.getOfferOid());
			String projectOfferFile = fileMagnger2.getUrl();
			// 文件
			FileSystemResource file = new FileSystemResource(new File(
					projectOfferFile));
			helper.addAttachment(fileMagnger2.getName(), file);
			// 发送邮件
			mailSender.send(mimeMessage);
		} catch (Exception e) {
			in.setStatus("发送失败");
			e.printStackTrace();
		}
		in.setStatus("发送成功");
		return in;
	}

	// ========================报价单模板解析===============================
	/**
	 * 解析数据库报价单to 模板文件
	 */
	public void MongodbToFile(String url, ProjectOffer po, User user) {
		// excel模板路径
		File file = new File(url);
		try {
			// 转换 
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
			// 读取excel模板
			HSSFWorkbook workbook = new HSSFWorkbook(fs);
			// 读取了模板内所有sheet内容
			HSSFSheet sheet = workbook.getSheetAt(0);
			// 创建list 储存属性值
			List<Status> slist = new ArrayList<Status>();
			// 遍历sheet
			for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {
				// Status status = new Status();
				HSSFRow row = sheet.getRow(j);
				// 储存单元格列数
				for (int k = 0; k < row.getLastCellNum(); k++) {
					// 储存单元格行数
					String value = row.getCell(k).getStringCellValue().trim();
					Status status = new Status();
					status.setCell(k);
					status.setRow(j);
					status.setValue(value);
					// 添加元素
					slist.add(status);
				}

			}
			for (Status s : slist) {
				if (s.getValue().equals("${offerlist.name}")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(user.getCompany() + "报价单");
					
				} 
			}

			// 报价单主主体部分
			/*
			 * PoiUtil.insertRow(sheet, 9, 5); PoiUtil.copyRow(workbook,
			 * sheet.getRow(14), sheet.createRow(11), true);
			 */
			// 上传报价单到用户文件目录
			// 保存文件位置
			String basePath = "src\\main\\resources\\public\\";
			// String oid = tokenutil.tokenToOid();
			// 检测并创建文件路径
			String oid = "57a5ab46bc9e0026bee7b255";
			String folder = "files";
			String fileSaveUrl = FileUtil
					.createUserFiles(oid, basePath, folder);
			String newFileName = RandomUtil.getRandomFileName();

			FileOutputStream out = new FileOutputStream(fileSaveUrl
					+ newFileName + ".xls");
			workbook.write(out);
			out.close();
			FileManager filemanager = new FileManager();
			filemanager.setDate((new Date()).toString());
			filemanager.setName(po.getName());
			filemanager.setOthername(RandomUtil.getRandomFileName());
			filemanager.setUrl(fileSaveUrl);
			filemanager.setUid(oid);
			filemanager.setOfferOid(po.getOid());
			// 对文件进行持久化数据库
			fileImpl.fileUpload(filemanager);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
