package cc.zhanyun.service;

import org.springframework.web.multipart.MultipartFile;

import cc.zhanyun.model.Info;

public interface ClientService {
	/**
	 * 上传布局图
	 */
	public Info uploadImage(MultipartFile file);

}
