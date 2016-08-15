package cc.zhanyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cc.zhanyun.model.OfferSend;
import cc.zhanyun.model.file.FileManager;
import cc.zhanyun.repository.impl.FileRepoImpl;
import cc.zhanyun.service.EmailService;
import cc.zhanyun.service.FileService;
import cc.zhanyun.util.TokenUtil;
import cc.zhanyun.util.fileutil.FileUtil;

@Service
public class FileServiceImpl implements FileService {
	/**
	 * 文件上传
	 */
	@Autowired
	private FileRepoImpl fileRepoImpl;

	@Autowired
	private TokenUtil tokenutil;
	@Autowired
	private EmailService email;

	/**
	 * 单个文件上传
	 */
	@Override
	public String uploadFile(MultipartFile file) {

		if (FileUtil.verifyFileType(file) == 1) {
			// 保存文件位置
			String url = "src\\main\\resources\\public\\";
			// 保存文件位置
			String oid = tokenutil.tokenToOid();

			String folder = "fileModel";
			String othername = FileUtil.getOtherName(file);
			Integer status = FileUtil.uploadFile(file, oid, url, folder,
					othername);
			// 判断状态
			if (status == 1) {
				// 储存信息
				FileManager fileManager = new FileManager();
				fileManager.setName(file.getOriginalFilename());
				fileManager.setOthername(othername);
				fileManager.setUid(oid);
				// tokenutil.tokenToOid()
				fileManager.setUrl(oid + "\\" + folder + "\\");
				fileManager.setBasepath(url);
				// 持久化
				fileRepoImpl.fileUpload(fileManager);
				// 文件IO
				return "上传成功";
			} else if (status == 0) {
				return "上传失败";
			}
			return "上传失败，文件是空的";
		} else {
			return "非法格式，请重新选择正确格式！！";
		}

	}

	/**
	 * 文件下载
	 */
	@Override
	public FileSystemResource downloadFile(String oid) {
		String uid = tokenutil.tokenToOid();
		OfferSend offerSend = new OfferSend();

		offerSend.setOfferOid(oid);
		offerSend.setFileTemplateOid("57ad7d3ebc9ece1d055ab243");
		offerSend.setTo("2783309477@qq.com");
		email.sendAttachmentsMail(offerSend);
		// 获取文件路径
		FileManager filemanager = fileRepoImpl.selFileByOfferoid(uid, oid);
		// 文件
		FileSystemResource file = new FileSystemResource(
				filemanager.getBasepath() + filemanager.getUrl()
						+ filemanager.getOthername());

		return file;

	}

	@Override
	public void uploadFiles(List<MultipartFile> flist) {
		// TODO Auto-generated method stub

	}

}
