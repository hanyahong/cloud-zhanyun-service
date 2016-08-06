package cc.zhanyun.service;

import java.util.List;

import cc.zhanyun.model.resources.ResourcesTypes;

public interface ResourceTypeService {
	/**
	 * 保存
	 * 
	 * @param type
	 */
	public void saveTypeOne(ResourcesTypes type);

	/**
	 * 查询列表
	 * 
	 * @return
	 */
	public List<ResourcesTypes> selTypeAll();

	/**
	 * 单条查询
	 * 
	 * @param oid
	 * @return
	 */
	public ResourcesTypes selTypeOne(String oid);

	/**
	 * 单条 删除
	 * 
	 * @param oid
	 */
	public void delTypeOne(String oid);
}
