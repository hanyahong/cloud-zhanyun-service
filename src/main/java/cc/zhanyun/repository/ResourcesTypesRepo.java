package cc.zhanyun.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cc.zhanyun.model.resources.ResourcesTypes;

public interface ResourcesTypesRepo extends
		MongoRepository<ResourcesTypes, String> {

}
