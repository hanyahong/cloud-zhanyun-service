package cc.zhanyun.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import cc.zhanyun.model.client.Clientmanager;
import cc.zhanyun.model.vo.ClientVO;

/**
 * 客户服务层接口
 * 
 * @author Administrator
 * 
 */
public interface ClientRepository extends
		MongoRepository<Clientmanager, String> {
	/**
	 * 查询需要的字段（列表）
	 * 
	 * @return List Of Clients
	 */
	@Query(value = "{'_id':{'$ne':null}}", fields = "{'oid':1,'name':1}")
	public List<ClientVO> findByIdNotNull();

	/**
	 * 单条查询客户
	 * 
	 * @param oid
	 * @return Client detail
	 */

	public Clientmanager findByOid(String oid);

}
