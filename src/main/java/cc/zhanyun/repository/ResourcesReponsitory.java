package cc.zhanyun.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import cc.zhanyun.model.resources.Resources;
import cc.zhanyun.model.vo.ResourcesVO;

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
	@Query(value = "{'_id':{'$ne':null}}", fields = "{'oid':1,'simplename':1,'classification':1}")
	public List<Resources> findByIdNotNull();

	/**
	 * 以 资源类型查询 资源列表（返回部分键）
	 * 
	 * @return
	 */
	@Query(fields = "{'_id':1,'simplename':1,'classification':1}")
	public List<ResourcesVO> findByClassification(String classification);
}
