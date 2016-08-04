package cc.zhanyun.service;

import org.springframework.web.multipart.MultipartFile;

public interface LocationService {
	
	/**
	 * 上传客户头像
	 */
	public String uploadImage(MultipartFile  file);
	
}
