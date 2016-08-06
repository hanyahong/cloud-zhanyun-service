package cc.zhanyun.service;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	/**
	 * 文件上传
	 */
	public String uploadFile(MultipartFile file);

	/**
	 * 文件下载
	 */
	public InputStreamResource downloadFile(String oid);

	/**
	 * 多文件上传
	 */
	public void uploadFiles(List<MultipartFile> flist);
}
