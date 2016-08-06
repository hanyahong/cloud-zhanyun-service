package cc.zhanyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cc.zhanyun.model.Info;
import cc.zhanyun.model.location.Images;
import cc.zhanyun.repository.impl.LocationRepoImpl;
import cc.zhanyun.service.LocationService;
import cc.zhanyun.util.RandomUtil;
import cc.zhanyun.util.fileutil.FileUtil;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepoImpl location;

	@Override
	public Info uploadLocationImage(MultipartFile file) {
		Info in = new Info();
		// 保存文件位置
		String url = "src\\main\\resources\\public\\";
		// String oid = tokenutil.tokenToOid();
		String oid = "57a1cc51bc9ee7ffc3ce6322";
		String folder = "locationimages";
		String othername = FileUtil.getOtherName(file);
		// 文件（IO）
		Integer status = FileUtil.uploadFile(file, oid, url, folder, othername);
		// 判断状态
		if (status == 1) {
			// 对客户数据库进行持久化
			Images images = new Images();
			// 随机产生id
			images.setImageoid(RandomUtil.getRandomFileName());
			images.setName(othername);
			images.setUrl(oid + "/" + folder + "/");
			// 持久化
			Integer info = location.addLocationImage(images, oid);

			if (info == 1) {
				in.setStatus("上传成功");
			} else {
				in.setStatus("上传失败");
			}
		} else if (status == 0) {
			in.setStatus("上传失败，服务器错误");
		} else if (status == 2) {
			in.setStatus("上传失败，文件不能为空");
		}
		return in;
	}

	@Override
	public Info uploadlocationHouseImage(MultipartFile file) {
		Info in = new Info();
		// 保存文件位置
		String url = "src\\main\\resources\\public\\";
		// String oid = tokenutil.tokenToOid();
		String oid = "57a1cc51bc9ee7ffc3ce6322";
		String folder = "houseimages";
		String othername = FileUtil.getOtherName(file);
		// 文件（IO）
		Integer status = FileUtil.uploadFile(file, oid, url, folder, othername);
		// 判断状态
		if (status == 1) {
			// 对客户数据库进行持久化
			Images images = new Images();
			// 随机产生id
			images.setImageoid(RandomUtil.getRandomFileName());
			images.setName(othername);
			images.setUrl(oid + "/" + folder + "/");
			// 持久化
			Integer info = location.addLocationHouseImage(images, oid);

			if (info == 1) {
				in.setStatus("上传成功");
			} else {
				in.setStatus("上传失败");
			}
		} else if (status == 0) {
			in.setStatus("上传失败，服务器错误");
		} else if (status == 2) {
			in.setStatus("上传失败，文件不能为空");
		}
		return in;
	}
}
