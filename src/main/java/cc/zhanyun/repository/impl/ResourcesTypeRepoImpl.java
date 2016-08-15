package cc.zhanyun.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cc.zhanyun.model.resources.ResourcesTypes;
import cc.zhanyun.repository.ResourcesTypesRepo;

@Repository
public class ResourcesTypeRepoImpl {
	@Autowired
	private ResourcesTypesRepo typesRepo;

	/**
	 * 保存分类
	 * 
	 * @param type
	 */
	public void saveResourceType(ResourcesTypes type) {
		typesRepo.save(type);
	}

	/**
	 * 查询分类
	 */
	public List<ResourcesTypes> selResourceTypes(String uid) {
		return typesRepo.findByUid(uid);
	}

	/**
	 * 查询分类详情
	 */
	public ResourcesTypes selResourceTypeOne(String oid) {
		return typesRepo.findOne(oid);
	}

	/**
	 * 删除分类
	 */
	public void delResourceType(String oid) {
		typesRepo.delete(oid);
	}
	/**
	 * 添加
	 */
}
