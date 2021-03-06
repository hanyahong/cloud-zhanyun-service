package cc.zhanyun.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import cc.zhanyun.model.location.Houses;
import cc.zhanyun.model.location.Location;
import cc.zhanyun.model.vo.HousesVO;
import cc.zhanyun.model.vo.LocationVO;
import cc.zhanyun.repository.LocationRepository;
import cc.zhanyun.util.fileutil.ImagesUtil;

@Repository
public class LocationRepoImpl {

	@Autowired
	private LocationRepository locationRepo;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private ImagesUtil imagesUtil;

	/**
	 * 新增场地
	 */
	public void addLocation(Location location) {
		locationRepo.save(location);
	}

	/**
	 * 查询场地
	 */
	public List<LocationVO> selLocation(String uid) {
		// 使用VO限制返回字段
		List<LocationVO> lvlist = new ArrayList<LocationVO>();

		List<Location> rlist = locationRepo.findByUid(uid);

		for (Location l : rlist) {
			LocationVO lvo = new LocationVO();
			lvo.setOid(l.getOid());
			lvo.setName(l.getName());
			lvo.setAddress(l.getAddress());
			lvlist.add(lvo);
		}

		return lvlist;
	}

	/**
	 * 查询单条场地详情
	 */
	public Location selLocationById(String oid) {

		Location location = locationRepo.findOne(oid);
		System.out.println(location.getAddress() + location.getName());
		System.out.println(location.getOid());
		return location;
	}

	
	/**
	 * 删除单条场地
	 */
	public void delLocationById(String oid) {
		locationRepo.delete(oid);
	}

}
