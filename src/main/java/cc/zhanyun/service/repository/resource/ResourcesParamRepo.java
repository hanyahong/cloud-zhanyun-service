package cc.zhanyun.service.repository.resource;

import org.springframework.data.mongodb.repository.MongoRepository;

import cc.zhanyun.service.model.resources.ResourcesParameter;

/**
 * 资源属性管理接口
 * 
 * @author Administrator
 * 
 */
public interface ResourcesParamRepo extends
		MongoRepository<ResourcesParameter, String> {

}
