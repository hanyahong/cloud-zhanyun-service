package cc.zhanyun.service.repository.resource;

import org.springframework.data.mongodb.repository.MongoRepository;

import cc.zhanyun.service.model.resources.ResourcesTypes;

public interface ResourcesTypesRepo extends
		MongoRepository<ResourcesTypes, String> {

}
