package cc.zhanyun.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cc.zhanyun.model.file.FileManager;
import cc.zhanyun.repository.impl.FileRepoImpl;
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

	/**
	 * 单个文件上传
	 */
	@Override
	public String uploadFile(MultipartFile file) {

		if (FileUtil.verifyFileType(file) == 1) {
			// 保存文件位置
			String url = "src\\main\\resources\\public\\";
			// 保存文件位置
			// String oid = tokenutil.tokenToOid();
			String oid = "57a5ab46bc9e0026bee7b255";
			String folder = "files";
			String othername = FileUtil.getOtherName(file);
			Integer status = FileUtil.uploadFile(file, oid, url, folder,
					othername);
			// 判断状态
			if (status == 1) {
				// 储存信息
				FileManager fileManager = new FileManager();
				fileManager.setName(file.getOriginalFilename());
				fileManager.setOthername(othername);
				fileManager.setUid("testOid46ery4765u68ru");
				// tokenutil.tokenToOid()
				fileManager.setUrl(folder + "\\");
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
	public InputStreamResource downloadFile(String oid) {
		// 获取文件路径
		String filePath = "src\\main\\resources\\META-INF\\images";
		// 文件
		FileSystemResource file = new FileSystemResource(filePath);

		try {
			return new InputStreamResource(file.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}

	@Override
	public void uploadFiles(List<MultipartFile> flist) {
		// TODO Auto-generated method stub

	}

}
