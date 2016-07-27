package cc.zhanyun.service.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cc.zhanyun.service.model.location.Location;
import cc.zhanyun.service.model.vo.LocationVO;
import cc.zhanyun.service.repository.Location.LocationRepository;

@Service
@Repository
public class LocationService {

	@Autowired
	private LocationRepository locationRepo;

	@Autowired
	private MongoTemplate mongoTemplate;

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
		System.out.println(location.getAddress()+location.getName());
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
