package cc.zhanyun.service;

import org.springframework.web.multipart.MultipartFile;

public interface ClientService  {
	/**
	 * 上传布局图
	 */
	public String uploadImage(MultipartFile  file);

	
}
