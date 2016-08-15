package cc.zhanyun.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cc.zhanyun.model.Info;
import cc.zhanyun.model.image.Image;
import cc.zhanyun.model.location.Houses;
import cc.zhanyun.model.location.Location;
import cc.zhanyun.model.vo.LocationImageHouseOidVO;
import cc.zhanyun.model.vo.LocationImageOidVO;
import cc.zhanyun.model.vo.LocationVO;
import cc.zhanyun.repository.impl.LocationRepoImpl;
import cc.zhanyun.service.LocationService;
import cc.zhanyun.util.RandomUtil;
import cc.zhanyun.util.TokenUtil;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepoImpl locationRepo;
	@Autowired
	private TokenUtil tokenutil;
	@Autowired
	private ImageServiceImpl imageServiceImpl;

	/**
	 * 添加场地
	 */
	@Override
	public LocationImageOidVO addLocation(Location location) {
		LocationImageOidVO livo = new LocationImageOidVO();

		String oid = RandomUtil.getRandomFileName();
		String uid = tokenutil.tokenToOid();
		String locationImage = RandomUtil.getRandomFileName();

		// 设置会议室类图片
		List<Houses> house = location.getHouses();
		// 返回信息承载
		LocationImageOidVO li = new LocationImageOidVO();
		List<LocationImageHouseOidVO> hilist = new ArrayList<LocationImageHouseOidVO>();
		try {

			// 创建场地图库
			Image image = new Image();
			image.setOid(locationImage);
			image.setUid(uid);
			// 新建一个图片库
			imageServiceImpl.saveImageService(image);
			// 遍历赋值
			// 如果有新增了房间 ，开始给每个房间创建一个独立的images库
			if (house.size() != 0) {

				for (Houses h : house) {
					// 获取房间id/房间图片id/房间案例id
					String houseImages = RandomUtil.getRandomFileName();
					String houseCaseImages = RandomUtil.getRandomFileName();
					h.setImages(houseImages);
					h.setCaseimages(houseCaseImages);
					// 创建会议室图片库
					Image image2 = new Image();
					image2.setOid(houseImages);
					image2.setUid(uid);
					// 创建会议室案例图片库
					Image image3 = new Image();
					image3.setOid(houseCaseImages);
					image3.setUid(uid);
					imageServiceImpl.saveImageService(image2);
					imageServiceImpl.saveImageService(image3);
					// 返回信息
					LocationImageHouseOidVO lihovo = new LocationImageHouseOidVO();
					lihovo.setImages(houseImages);
					lihovo.setCaseImages(houseCaseImages);
					// 加入集合
					hilist.add(lihovo);
				}
				li.setLhlist(hilist);

			}
			// 设置房间
			location.setHouses(house);
			// 赋值
			location.setOid(oid);
			location.setUid(uid);
			location.setImages(locationImage);

			// 持久化资源
			locationRepo.addLocation(location);
			// 返回给客户端信息
			livo.setOid(oid);
			livo.setLocationimages(locationImage);
			livo.setLhlist(hilist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return livo;
	}

	@Override
	public Location selLocationInfo(String oid) {
		// TODO Auto-generated method stub
		return locationRepo.selLocationById(oid);
	}

	@Override
	public Info delLocationInfo(String oid) {
		Info info = new Info();
		// TODO Auto-generated method stub
		try {
			locationRepo.delLocationById(oid);
			info.setStatus("成功");
		} catch (Exception e) {
			info.setStatus("失败");
		}
		return info;
	}

	@Override
	public List<LocationVO> selLocationList() {
		String uid = tokenutil.tokenToOid();

		return locationRepo.selLocation(uid);
	}

	@Override
	public Info addLocationImage(String oid, MultipartFile file) {
		Info info = new Info();
		try {
			Location location = selLocationInfo(oid);
			String imageOid = location.getImages();
			// 上传图片
			// 作用域
			String imagelocation = "场地效果图";
			imageServiceImpl.saveImageOneService(file, imageOid, imagelocation);
			info.setStatus("成功");
		} catch (Exception e) {
			info.setStatus("失败");
		}

		return info;
	}

	/**
	 * 增加场地房间照片
	 */
	@Override
	public Info addLocationRoomImage(String oid, String houseOid,
			MultipartFile file) {
		Info info = new Info();
		try {
			Location location = locationRepo.selLocationById(oid);
			List<Houses> hlist = location.getHouses();
			String imageOid = null;
			for (Houses h : hlist) {
				if (h.getOid().equals(houseOid)) {
					imageOid = h.getImages();
				}
			}

			// 上传图片
			// 作用域
			String imagelocation = "会议室图片";
			imageServiceImpl.saveImageOneService(file, imageOid, imagelocation);
			info.setStatus("成功");
		} catch (Exception e) {
			info.setStatus("失败");
		}

		return info;
	}

	@Override
	public LocationImageOidVO updateLocation(Location location) {

		String uid = tokenutil.tokenToOid();

		// 设置会议室类图片
		List<Houses> house = location.getHouses();

		// 返回信息承载
		LocationImageOidVO li = new LocationImageOidVO();
		List<LocationImageHouseOidVO> llist = new ArrayList<LocationImageHouseOidVO>();

		// 遍历赋值
		// 如果房间不为空，进入
		if (house.size() != 0) {
			for (Houses h : house) {
				System.out.println("====================请求中带的房间信息:房间图片："+h.getImages()+"房间案例ID："+h.getCaseimages());
				// 获取房间中的每个 案例图片id 房间id,如果不为空，不用添加，如果为空就添加
				// 获取房间id/房间图片id/房间案例id
				String houseImages = null;
				LocationImageHouseOidVO lihovo = new LocationImageHouseOidVO();
				// 如果id为空，说明是新建的房间，要创建图片库
				if (h.getImages() == null) {

					houseImages = RandomUtil.getRandomFileName();
					h.setImages(houseImages);
					// 创建会议室图片库
					Image image2 = new Image();
					image2.setOid(houseImages);
					image2.setUid(uid);
					imageServiceImpl.saveImageService(image2);

					// 返回值 设置
					lihovo.setImages(houseImages);

				}
				// 如股票id为空，说明是新建的房间
				String houseCaseImages = null;
				if (h.getCaseimages() == null) {
					houseCaseImages = RandomUtil.getRandomFileName();
					h.setCaseimages(houseCaseImages);
					// 创建会议室案例图片库
					Image image3 = new Image();
					image3.setOid(houseCaseImages);
					image3.setUid(uid);
					imageServiceImpl.saveImageService(image3);

					// 返回值设置
					lihovo.setCaseImages(houseCaseImages);
				}
				// 加入集合
				llist.add(lihovo);
				System.out.println("+++++++++++该房间是新创建的：房间图片为" + h.getImages()
						+ "案例图片为：" + h.getCaseimages());
			}
			// 设置房间
			location.setHouses(house);
			location.setUid(uid);

		}

		try {
			// 如果修改成功
			locationRepo.addLocation(location);
			// 返回值设置
			li.setLocationimages(location.getImages());
			li.setLhlist(llist);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Info addLocationRoomCaseImage(String oid, String houseOid,
			MultipartFile file) {
		Info info = new Info();
		try {
			Location location = locationRepo.selLocationById(oid);
			List<Houses> hlist = location.getHouses();
			String imageOid = null;
			for (Houses h : hlist) {
				if (h.getOid().equals(houseOid)) {
					imageOid = h.getCaseimages();
				}
			}
			// 上传图片
			// 作用域
			String imagelocation = "会议室案例图片";
			imageServiceImpl.saveImageOneService(file, imageOid, imagelocation);
			info.setStatus("成功");
		} catch (Exception e) {
			info.setStatus("失败");
		}

		return info;
	}
}
