package cc.zhanyun.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import cc.zhanyun.model.ProjectOffer;
import cc.zhanyun.model.location.Images;
import cc.zhanyun.model.vo.OfferVO;
import cc.zhanyun.repository.ProjectOfferRepo;

import com.mongodb.BasicDBObject;

public class ProjectOfferRepoImpl {

	@Autowired
	ProjectOfferRepo por;

	@Autowired
	MongoTemplate mongoTemlate;

	@Autowired
	MongoTemplate mongoTemplate;

	/**
	 * 增加项目报价单（修改）
	 */
	public void saveProOfferOne(ProjectOffer projectOffer) {
		por.save(projectOffer);
	}

	/**
	 * 删除项目报价单
	 */
	public void delProOfferOne(String oid) {
		por.delete(oid);
	}

	/**
	 * 查询项目报价单
	 */
	public ProjectOffer selProOfferOne(String oid) {
		return por.findOne(oid);
	}

	/**
	 * 查询项目报价单列表
	 */
	public List<ProjectOffer> selProOfferList() {

		// 创建对象
		// DBObject dbObject = new BasicDBObject();
		// dbObject.put("_id", 1);
		/*
		 * // 创建对象 BasicDBObject fieldObject = new BasicDBObject();
		 * fieldObject.put("name", 1); fieldObject.put("_id", 1);
		 * fieldObject.put("project.location.address", 1);
		 * 
		 * // 创建查询 执行 DBCursor cursor =
		 * mongoTemlate.getCollection("projectOffer") .find(new BasicDBObject(),
		 * fieldObject) .addOption(Bytes.QUERYOPTION_NOTIMEOUT);
		 * 
		 * // 创建集合 List<ProjectOffer> plist = new ArrayList<ProjectOffer>();
		 * 
		 * // 遍历查询结果 while (cursor.hasNext()) { // 查询本条结果 DBObject dbObject1 =
		 * cursor.next(); System.out.println(dbObject1); // 创建接受实体类 ProjectOffer
		 * projectOffer = new ProjectOffer(); // 转换DBObject to Bean try {
		 * DBObjectToBean.dbObject2Bean(dbObject1, projectOffer); } catch
		 * (Exception e) { e.printStackTrace(); } // 添加集合属性
		 * plist.add(projectOffer); } return plist;
		 */

		List<ProjectOffer> polist = por.findByIdNotNull();
		// System.out.println(polist.size());
		return polist;
	}

	/**
	 * 按照 status 查询报价单列表
	 */
	public List<ProjectOffer> selProOfferOfStatusList(Integer status) {

		List<ProjectOffer> plist = por.findByofferStatus(status);

		return plist;
	}

	/**
	 * 修改报价状态
	 */
	public void updateProjectOfferStatus(OfferVO ov) {
		// 创建查询对象
		BasicDBObject basicDBObject = new BasicDBObject();
		// 追加条件
		basicDBObject.put("$set",
				new BasicDBObject("offer.status", ov.getStatus()));

		// 更新操作
		Update update = new BasicUpdate(basicDBObject);
		// 执行操作
		mongoTemplate.upsert(new Query(Criteria.where("_id").is(ov.getOid())),
				update, "projectOffer");
	}

	/**
	 * 增加照片
	 * 
	 * @param images
	 * @param oid
	 * @return
	 */
	public Integer addProjectImage(Images images, String oid) {
		try {
			Query query = Query.query(Criteria.where("_id").is(oid));
			Update update = new Update();
			update.addToSet("project.image", images);
			mongoTemplate.upsert(query, update, ProjectOffer.class);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	/**
	 * 删除 照片
	 * 
	 * @param oid
	 * @param imageoid
	 * @return
	 */
	public Integer removeProjectImage(String oid, String imageoid) {

		try {
			Query query = Query.query(Criteria.where("_id").is(oid)
					.and("project.images._id").is(imageoid));
			Update update = new Update();
			update.unset("projectoffer" + ".$");
			mongoTemplate.updateFirst(query, update, ProjectOffer.class);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}
}
