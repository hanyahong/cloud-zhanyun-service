package cc.zhanyun.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cc.zhanyun.model.resources.ResourcesTypes;

public interface ResourcesTypesRepo extends
		MongoRepository<ResourcesTypes, String> {
	/**
	 * 通过uid 查询
	 */
	public List<ResourcesTypes> findByUid(String uid);
}
