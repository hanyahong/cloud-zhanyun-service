package cc.zhanyun.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import cc.zhanyun.model.resources.Resources;
import cc.zhanyun.model.resources.ResourcesTypes;
import cc.zhanyun.repository.ResourcesReponsitory;

import com.mongodb.BasicDBObject;

/**
 * 资源管理服务层
 * 
 * @author Administrator
 * 
 */

@Repository
public class ResourcesRepoImpl {

	@Autowired
	private ResourcesReponsitory resourcesReponsitory;

	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * 新增 单条资源
	 * 
	 * @param Resources
	 */
	public void addResources(Resources resources) {
		resourcesReponsitory.save(resources);
	}

	/**
	 * 查询 全部资源列表
	 * 
	 * @return List of Resources
	 */
	public List<Resources> selResources(String uid) {

		List<Resources> rlist = resourcesReponsitory.findByUid(uid);

		return rlist;
	}

	/**
	 * 查询 全部资源列表
	 * 
	 * @return List of Resources
	 */
	public List<Resources> selResourcesAll() {

		return resourcesReponsitory.findAll();
	}

	/**
	 * 查询 全部资源 列表 部分 键
	 * 
	 * @return List<Resources>
	 */
	public List<Resources> selResourcesSome(String uid) {
		return resourcesReponsitory.findByUid(uid);
	}

	/**
	 * 按照分类查询资源列表 返回部分键
	 * 
	 * @param classification
	 * @return List<Resources>
	 */
	public List<Resources> selResourcesByType(String classification, String uid) {
		return resourcesReponsitory.findByClassificationAndUid(classification,
				uid);
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

}
