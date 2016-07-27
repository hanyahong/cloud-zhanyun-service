package cc.zhanyun.service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import cc.zhanyun.service.model.offer.Offer;
import cc.zhanyun.service.model.vo.OfferVO;

public interface OfferRepository extends MongoRepository<Offer, String> {

	/**
	 * 查询需要的报价（列表）
	 * 
	 * @return List Of Clients
	 */
	@Query(value = "{'_id':{'$ne':null}}", fields = "{'oid':1,'name':1,'address':1,'status':1}")
	public List<OfferVO> findByIdNotNull();

	/**
	 * 查询不同状态的报价
	 */
	@Query(value = "{'status':{'$ne':null}}", fields = "{'oid':1,'name':1,'address':1,'status':1}")
	public List<OfferVO> findByStatus(Integer status);
	
}
