package cc.zhanyun.service;

import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	/**
	 * 文件上传
	 */
	public String uploadFile(MultipartFile file);

	/**
	 * 文件下载
	 */
	public FileSystemResource downloadFile(String oid);

	/**
	 * 多文件上传
	 */
	public void uploadFiles(List<MultipartFile> flist);
	/**
	 * app下载
	 */
}
