package cc.zhanyun.service.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;

import cc.zhanyun.service.model.offer.Offer;
import cc.zhanyun.service.model.vo.OfferStatusVO;
import cc.zhanyun.service.model.vo.OfferVO;
import cc.zhanyun.service.repository.OfferRepository;

@Repository
@Service
public class OfferService {

	@Autowired
	private OfferRepository offerRepo;

	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * 查询所有报价(列表)
	 */
	public List<OfferVO> selOffer() {
		return offerRepo.findByIdNotNull();
	}

	/**
	 * 查询报价详情
	 */
	public Offer selOfferById(String oid) {
		return offerRepo.findOne(oid);
	}

	/**
	 * 增加报价
	 */
	public void addOffer(Offer offer) {
		offerRepo.save(offer);
	}

	/**
	 * 删除报价
	 */
	public void delOffer(String oid) {
		offerRepo.delete(oid);
	}

	/**
	 * 查询不同状态下的报价单列表
	 */
	public List<OfferVO> selOfferByStatus(Integer status) {
		List<OfferVO> olist = offerRepo.findByStatus(status);
		System.out.println(olist.size());
		return olist;

	}

	/**
	 * 修改报价单状态
	 */
	public void updateOfferStatus(OfferStatusVO osvo) {
		// 创建查询对象
		BasicDBObject basicDBObject = new BasicDBObject();
		// 追加条件
		basicDBObject
				.put("$set", new BasicDBObject("status", osvo.getStatus()));

		// 更新操作
		Update update = new BasicUpdate(basicDBObject);
		// 执行操作
		mongoTemplate.upsert(
				new Query(Criteria.where("_id").is(osvo.getOid())), update,
				"offer");

	}
}
