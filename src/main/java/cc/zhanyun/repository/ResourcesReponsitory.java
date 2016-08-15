package cc.zhanyun.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cc.zhanyun.model.resources.Resources;

/**
 * 资源服务接口
 * 
 * @author Administrator
 * 
 */
public interface ResourcesReponsitory extends
		MongoRepository<Resources, String> {
	/**
	 * 查询 全部资源列表接口（返回部分键）
	 * 
	 * @return
	 */
	public List<Resources> findByUid(String uid);

	/**
	 * 以 资源类型查询 资源列表（返回部分键）
	 * 
	 * @return
	 */
	public List<Resources> findByClassificationAndUid(String classification,
			String uid);
}
