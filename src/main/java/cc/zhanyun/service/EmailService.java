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
import cc.zhanyun.model.Status;
import cc.zhanyun.model.file.FileManager;
import cc.zhanyun.model.offer.Resourcetypes;
import cc.zhanyun.model.offer.Selectedresources;
import cc.zhanyun.model.user.User;
import cc.zhanyun.repository.impl.FileRepoImpl;
import cc.zhanyun.repository.impl.UserRepoImpl;
import cc.zhanyun.util.RandomUtil;
import cc.zhanyun.util.TokenUtil;
import cc.zhanyun.util.fileutil.FileUtil;
import cc.zhanyun.util.myutil.PoiUtil;

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
			// 获取用户信息
			String uid = tokenutil.tokenToOid();
			User u = userImpl.selUserById(uid);
			
			// 邮件发送设置
			helper.setFrom("hyhvpn@126.com");
			helper.setTo(offerSend.getTo());
			helper.setSubject(u.getCompany() + offerSend.getName()
					+ "报价单,请您查收--" + u.getName());
			helper.setText("报价单");
			
			// 报价单附件设置 获取url 报价单 用户信息
			String oid = tokenutil.tokenToOid();
			// String oid = "57a5ab46bc9e0026bee7b255";
			// 获取user信息
			User user = userImpl.selUserById(oid);
			// 获取报价单信息
			ProjectOffer po = pos.selProjectOfferOne(offerSend.getOfferOid());
			// 获取报价单模板地址
			offerSend.setFileTemplateOid("57ad7d3ebc9ece1d055ab243");
			FileManager fileManager = fileImpl.fileDownload(offerSend
					.getFileTemplateOid());

			// 判断如果用户没有模板，使用默认模板
			String url = null;
			String basepath = "src\\main\\resources\\public\\";
			if (fileManager == null) {
				url = basepath + "\\默认报价单模板.xls";
			} else {
				url = basepath + fileManager.getUrl()
						+ fileManager.getOthername();
			}
			// 解析报价单
			Integer info = MongodbToFile(url, po, user);
			if (info == 1) {
				// 查询文件系统中的数据
				FileManager fileMagnger2 = fileImpl.selFileByOfferoid(oid,
						offerSend.getOfferOid());
				String projectOfferFile = fileMagnger2.getBasepath()
						+ fileMagnger2.getUrl() + fileMagnger2.getOthername();
				// 文件

				FileSystemResource file = new FileSystemResource(new File(
						projectOfferFile));
				helper.addAttachment(fileMagnger2.getName(), file);
				// 发送邮件
				mailSender.send(mimeMessage);
				in.setStatus("发送成功");
			} else {
				in.setStatus("发送失败，模板有空格或空行");
			}

		} catch (Exception e) {
			e.printStackTrace();
			in.setStatus("发送失败");
		}
		return in;
	}

	// ========================报价单模板解析===============================
	/**
	 * 解析数据库报价单to 模板文件
	 */
	public Integer MongodbToFile(String url, ProjectOffer po, User user) {
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
			// 获取报价单循环节点
			Integer index = 0;
			for (Status s : slist) {

				if (s.getValue().equals("offerName")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(user.getCompany() + "报价单");
				} else if (s.getValue().equals("clientCompany")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(user.getCompany());
				} else if (s.getValue().equals("clientName")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(user.getName());
				} else if (s.getValue().equals("userPhone")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(user.getPhone());

				} else if (s.getValue().equals("projectAddress")) {
					sheet.getRow(s.getRow())
							.getCell(s.getCell())
							.setCellValue(
									po.getProject().getLocation().getAddress());

				} else if (s.getValue().equals("projectName")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(po.getName());

				} else if (s.getValue().equals("preparePlanTime")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(po.getProject().getPrepareplantime());

				} else if (s.getValue().equals("startPlanTime")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(po.getProject().getStartplantime());

				} else if (s.getValue().equals("leavePlanTime")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(po.getProject().getLeaveplantime());

				} else if (s.getValue().equals("projectOid")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(po.getOid());

				} else if (s.getValue().equals("offerDate")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(po.getProject().getCreatetime());

				} else if (s.getValue().equals("userName")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(user.getUsername());

				} else if (s.getValue().equals("userCompany")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(user.getCompany());

				} else if (s.getValue().equals("userPhone")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(user.getPhone());

				} else if (s.getValue().equals("proportion")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(po.getOffer().getProportion());

				} else if (s.getValue().equals("tax")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(po.getOffer().getTax());

				} else if (s.getValue().equals("discount")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(po.getOffer().getDiscount());

				}

				else if (s.getValue().equals("englishName")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(user.getCompanyengname());

				} else if (s.getValue().equals("url")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(user.getURL());

				} else if (s.getValue().equals("url")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue(user.getURL());

				} else if (s.getValue().equals("序号")) {
					index = s.getRow();
				}
			}
			// 报价单主主体部分

			Integer in1 = index + 1;
			Integer in2 = 3;
			// 获取报价单设备列表
			List<Resourcetypes> resourceList = po.getOffer().getResourcetypes();

			// 获取值
			Integer count = resourceList.size();
			// 如果不为0,立刻循环
			if (count != 0) {
				// 循环插入，有多少行，插入多少数据
				for (Resourcetypes rlist : resourceList) {

					// 1、插入空白行（从标志行开始，插入in2行）
					PoiUtil.insertRow(sheet, in1, in2);
					// 2、循环复制有样式的行，每复制一次，将其赋值处理
					HSSFSheet sheet2 = workbook.getSheetAt(1);
					for (int i = 0; i < in2; i++) {
						// 1、复制一行
						PoiUtil.copyRow(workbook, sheet2.getRow(i),
								sheet.createRow(in1 + i), true);
						// 2、遍历复制的每一行，找到cell
						HSSFRow row2 = sheet.getRow(in1 + i);
						for (int k = 0; k < row2.getLastCellNum(); k++) {
							// 给每个单元格赋值
							String value2 = row2.getCell(k)
									.getStringCellValue().trim();
							// 判断值，进行等值赋值
							if (value2.equals("resourceType")) {
								row2.getCell(k).setCellValue(rlist.getName());
							}
						}
					}
					// 查询子文档数目
					Integer rsize = rlist.getSelectedresources().size();
					// 如果大于1，遍历增加空行，复制样式
					if (rsize > 1) {
						for (int m = 0; m < rsize - 1; m++) {
							// 在in+1 增加 ，每次循环增加1
							PoiUtil.insertRow(sheet, m + in1 + 2, 1);
							PoiUtil.copyRow(workbook, sheet.getRow(in1 + 1),
									sheet.createRow(m + in1 + 2), true);
							// 对子文档取值
							Selectedresources s = rlist.getSelectedresources()
									.get(m);
							// 对每一行进行遍历
							// 2、遍历复制的每一行，找到cell
							HSSFRow row3 = sheet.getRow(m + in1 + 1);
							for (int x = 0; x < row3.getLastCellNum(); x++) {
								// 给每个单元格赋值
								String value3 = row3.getCell(x)
										.getStringCellValue().trim();
								// 判断值，进行等值赋值
								if (value3.equals("simpleName")) {
									row3.getCell(x).setCellValue(
											s.getSimplename());
								} else if (value3.equals("resourceName")) {
									row3.getCell(x).setCellValue(s.getName());

								} else if (value3.equals("resourceID")) {
									row3.getCell(x).setCellValue(
											String.valueOf(m + 1));
								} else if (value3.equals("resourceCount")) {
									row3.getCell(x).setCellValue(
											s.getAmount().toString());
								} else if (value3.equals("resourceUnit")) {
									row3.getCell(x).setCellValue(
											s.getUnit().toString());
								} else if (value3.equals("days")) {
									row3.getCell(x).setCellValue(
											s.getDays().toString());
								}
							}

						}
						
					}
				}
			}

			// 上传报价单到用户文件目录
			// 保存文件位置
			String basePath = "src\\main\\resources\\public\\";
			String oid = tokenutil.tokenToOid();
			// 检测并创建文件路径
			String folder = "offerFiles";
			String fileSaveUrl = FileUtil
					.createUserFiles(oid, basePath, folder);
			String saveurl = oid + "\\" + folder + "\\";
			// 检测报价单是否已经生成过
			FileManager fm = fileImpl.selFileByOfferoid(oid, po.getOid());
			// 如果为空，还没有生成，立刻生成

			if (fm == null) {
				String newFileName = RandomUtil.getRandomFileName() + ".xls";
				FileOutputStream out = new FileOutputStream(fileSaveUrl
						+ newFileName);
				workbook.write(out);
				out.close();
				FileManager filemanager = new FileManager();
				filemanager.setDate((new Date()).toString());
				filemanager.setName(po.getName() + ".xls");
				filemanager.setOthername(newFileName);
				filemanager.setBasepath(basePath);
				filemanager.setUrl(saveurl);
				filemanager.setUid(oid);
				filemanager.setOfferOid(po.getOid());
				// 对文件进行持久化数据库
				fileImpl.fileUpload(filemanager);
			} else {
				String newFileName = fm.getOthername();
				// 跟新已存在文件
				FileOutputStream out = new FileOutputStream(fileSaveUrl
						+ newFileName);
				workbook.write(out);
				out.close();

				FileManager filemanager = new FileManager();

				filemanager.setOid(fm.getOid());
				filemanager.setDate((new Date()).toString());
				filemanager.setName(fm.getName());
				filemanager.setOthername(fm.getOthername());
				filemanager.setUrl(fm.getUrl());
				filemanager.setUid(fm.getUid());
				filemanager.setBasepath(fm.getBasepath());
				filemanager.setOfferOid(fm.getOfferOid());
				// 对文件进行持久化数据库
				fileImpl.fileUpload(filemanager);
			}

			return 1;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
