package cc.zhanyun.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cc.zhanyun.model.Info;

@Service
public interface LocationService {

	/**
	 * 上传场地效果图
	 */
	public Info uploadLocationImage(MultipartFile file);

//	/**
//	 * 删除场地效果图
//	 */
//	public Info delLocationImage(String oid, String imageoid);

	/**
	 * 上传会议室图片
	 */
	public Info uploadlocationHouseImage(MultipartFile file);

//	/**
//	 * 删除会议室照片
//	 */
//	public Info delLocationHouseImage(String oid, String imageoid);
}
