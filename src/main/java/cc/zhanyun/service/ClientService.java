package cc.zhanyun.service;

import org.springframework.web.multipart.MultipartFile;

public interface ClientService  {
	/**
	 * 上传客户头像
	 */
	public String uploadImage(MultipartFile  file);

	
}
