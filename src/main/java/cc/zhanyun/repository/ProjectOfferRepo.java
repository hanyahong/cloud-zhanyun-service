package cc.zhanyun.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import cc.zhanyun.model.ProjectOffer;

public interface ProjectOfferRepo extends MongoRepository<ProjectOffer, String> {
	/**
	 * 查询项目报价单列表 部分字段（列表）
	 * 
	 * @return List Of Clients
	 */
	@Query(value = "{'_id':{'$ne':null}}", fields = "{'oid':1,'name':1,'project.location.address':1,'offer.client.name':1,'offer.status':1}")
	public List<ProjectOffer> findByIdNotNull();

	/**
	 * 查询不同状态的项目报价单
	 */
	@Query(fields = "{'oid':1,'name':1,'project.location.address':1,'offer.client.name':1,'offer.status':1}")
	public List<ProjectOffer> findByofferStatus(Integer status);
}
