package cc.zhanyun.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import cc.zhanyun.model.location.Images;
import cc.zhanyun.model.location.Location;
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
	public List<LocationVO> selLocation() {
		// 使用VO限制返回字段
		List<LocationVO> lvlist = new ArrayList<LocationVO>();

		List<Location> rlist = locationRepo.findByIdNotNull();

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

	/**
	 * 增加场地效果图
	 * 
	 * @param images
	 * @param oid
	 * @return
	 */
	public Integer addLocationImage(Images images, String oid) {
		try {
			Query query = Query.query(Criteria.where("_id").is(oid));
			Update update = new Update();
			update.addToSet("images", images);
			mongoTemplate.upsert(query, update, Location.class);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	/**
	 * 删除场地效果图
	 * 
	 * @param oid
	 * @param imageoid
	 * @return
	 */
	public Integer removeLocationImage(String oid, String imageoid) {

		try {
			Query query = Query.query(Criteria.where("_id").is(oid)
					.and("location._id").is(imageoid));
			Update update = new Update();
			update.unset("location" + ".$");
			mongoTemplate.updateFirst(query, update, Location.class);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	

	/**
	 * 增加会议室照片
	 * 
	 * @param images
	 * @param oid
	 * @return
	 */
	public Integer addLocationHouseImage(Images images, String oid) {
		try {
			Query query = Query.query(Criteria.where("_id").is(oid));
			Update update = new Update();
			update.addToSet("house.images", images);
			mongoTemplate.upsert(query, update, Location.class);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	/**
	 * 删除会议室 照片
	 * 
	 * @param oid
	 * @param imageoid
	 * @return
	 */
	public Integer removeLocationHouseImage(String oid, String imageoid) {

		try {
			Query query = Query.query(Criteria.where("_id").is(oid)
					.and("location.house._id").is(imageoid));
			Update update = new Update();
			update.unset("location" + ".$");
			mongoTemplate.updateFirst(query, update, Location.class);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

}
