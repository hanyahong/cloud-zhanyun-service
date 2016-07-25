package cc.zhanyun.service.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cc.zhanyun.service.model.resources.Resources;
import cc.zhanyun.service.model.resources.ResourcesParameter;
import cc.zhanyun.service.model.resources.ResourcesTypes;
import cc.zhanyun.service.model.vo.ResourcesVO;
import cc.zhanyun.service.repository.resource.ResourcesParamRepo;
import cc.zhanyun.service.repository.resource.ResourcesReponsitory;
import cc.zhanyun.service.repository.resource.ResourcesTypesRepo;

import com.mongodb.BasicDBObject;

/**
 * 资源管理服务层
 * 
 * @author Administrator
 * 
 */
@Service
@Repository
public class ResourcesService {

	@Autowired
	private ResourcesReponsitory resourcesReponsitory;

	@Autowired
	private ResourcesParamRepo resourcesParamRepo;

	@Autowired
	private ResourcesTypesRepo resourcesTypesRepo;

	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * 新增 单条资源
	 * 
	 * @param Resources
	 */
	public void addResources(Resources Resources) {
		resourcesReponsitory.save(Resources);
	}

	/**
	 * 查询 全部资源列表
	 * 
	 * @return List of Resources
	 */
	public List<ResourcesVO> selResources() {
		// 使用VO限制返回字段
		List<ResourcesVO> rvlist = new ArrayList<ResourcesVO>();

		List<Resources> rlist = resourcesReponsitory.findByIdNotNull();

		for (Resources r : rlist) {
			ResourcesVO rvo = new ResourcesVO();
			rvo.setOid(r.getOid());
			rvo.setName(r.getName());
			rvo.setClassification(r.getClassification());
			rvlist.add(rvo);
		}

		return rvlist;
	}

	/**
	 * 查询 全部资源 列表 部分 键
	 * 
	 * @return List<Resources>
	 */
	public List<Resources> selResourcesSome() {
		return resourcesReponsitory.findByIdNotNull();
	}

	/**
	 * 按照分类查询资源列表 返回部分键
	 * 
	 * @param classification
	 * @return List<Resources>
	 */
	public List<Resources> selResourcesByType(String classification) {
		return resourcesReponsitory.findByClassification(classification);
	}

	/**
	 * 以ID 单条查询 资源详情
	 * 
	 * @param oid
	 * @return Resources
	 */
	public Resources selResourcesOne(String oid) {
		return resourcesReponsitory.findOne(oid);
	}

	/**
	 * 单条删除 资源
	 * 
	 * @param oid
	 */
	public void delResourcesOne(String oid) {
		resourcesReponsitory.delete(oid);
	}

	/**
	 * 更新 资源
	 * 
	 * @param resources
	 */
	public void updateResourcesOne(Resources resources) {
		// 创建查询对象
		BasicDBObject basicDBObject = new BasicDBObject();
		// 追加条件
		basicDBObject
				.put("$set",
						new BasicDBObject("name", resources.getName())
								.append("classification",
										resources.getClassification())
								.append("simplename", resources.getSimplename())
								.append("amount", resources.getAmount())
								.append("unit", resources.getUnit())
								.append("unitprice", resources.getUnitprice())
								.append("remark", resources.getRemark()));

		// 更新操作
		Update update = new BasicUpdate(basicDBObject);
		// 执行操作
		mongoTemplate.upsert(
				new Query(Criteria.where("_id").is(resources.getOid())),
				update, "resources");

	}

	
	public void delResourcesParam(String oid) {
		resourcesParamRepo.delete(oid);
	}


	// **************************************资源分类
	// 服务层*****************************************
	/**
	 * 新增分类
	 * 
	 * @param type
	 */
	public void addResourcesTypes(ResourcesTypes type) {
		resourcesTypesRepo.save(type);
	}

	/**
	 * 查询分类
	 * 
	 * @return List<ResourcesTypes>
	 */
	public List<ResourcesTypes> selResourcesTypes() {
		return resourcesTypesRepo.findAll();
	}

	/**
	 * 更新 分类
	 * 
	 * @param resourcesTypes
	 */
	public void updateResourcesTypes(ResourcesTypes resourcesTypes) {
		// 创建查询对象
		BasicDBObject basicDBObject = new BasicDBObject();
		// 追加条件
		basicDBObject.put("$set",
				new BasicDBObject("name", resourcesTypes.getName()));
		// 更新操作
		Update update = new BasicUpdate(basicDBObject);
		// 执行操作
		mongoTemplate.upsert(
				new Query(Criteria.where("_id").is(resourcesTypes.getOid())),
				update, "resourcestypes");
	}

	/**
	 * 删除分类
	 * 
	 * @param oid
	 */
	public void delResourcesTypes(String oid) {
		resourcesTypesRepo.delete(oid);
	}

}
