package cc.zhanyun.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import cc.zhanyun.model.client.Clientmanager;
import cc.zhanyun.model.vo.ClientVO;
import cc.zhanyun.model.vo.ClientimageVO;
import cc.zhanyun.repository.ClientRepository;

import com.mongodb.BasicDBObject;

@Repository
public class ClientRepoImpl {

	@Autowired
	private ClientRepository clientrepo;

	@Autowired
	private MongoOperations mongoOpera;
	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * 新增客户
	 * 
	 * @param client
	 */
	public void addClient(Clientmanager client) {

		clientrepo.save(client);

	}

	/**
	 * 新增客户
	 * 
	 * @param client
	 */
	public void addddClient(Clientmanager client) {

		clientrepo.save(client);

	}

	/**
	 * 查询客户列表(全部信息)
	 * 
	 * @return Client List
	 */
	public List<ClientVO> selClients(String uid) {
		/*
		 * BasicDBObject keys = new BasicDBObject(); keys.put("_id", 1);
		 * keys.put("name", 1);
		 */

		return clientrepo.findByUid(uid);
	}

	/**
	 * 查询客户列表(手机端V1.1)
	 * 
	 * @return Client List
	 */

	public List<ClientVO> selClientsOfIDAndName(String uid) {
		return clientrepo.findByUid(uid);
	}

	/**
	 * 用ID 查询单条客户详情
	 * 
	 * @param oid
	 * @return Client detail
	 */
	public Clientmanager selClientById(String oid) {
		Clientmanager client = clientrepo.findByOid(oid);
		// System.out.println(client.getName() + client.getCompany()
		// + "-------------------------");
		return client;
	}

	public Clientmanager selClientByName(String name) {

		return clientrepo.findByName(name);
	}

	/**
	 * 删除单条客户
	 * 
	 * @param oid
	 */
	public void delClient(String oid) {
		clientrepo.delete(oid);
	}

	/**
	 * 修改单条客户
	 * 
	 * @param client
	 */
	public void updateClient(Clientmanager client) {
		// 创建查询对象
		BasicDBObject basicDBObject = new BasicDBObject();
		// 追加条件
		basicDBObject.put(
				"$set",
				new BasicDBObject("name", client.getName())
						.append("sex", client.getSex())
						.append("company", client.getCompany())
						.append("dept", client.getDept())
						.append("tel", client.getTel())
						.append("email", client.getEmail())
						.append("industry", client.getIndustry())
						.append("website", client.getWebsite())
						.append("address", client.getAddress())
						.append("_abstract", client.getAbstract()));
		// 更新操作
		Update update = new BasicUpdate(basicDBObject);
		// 执行操作
		mongoTemplate.upsert(new Query(Criteria.where("_id")
				.is(client.getOid())), update, "clientmanager");
	}

	/**
	 * 保存图片
	 */
	public Integer saveClientImage(ClientimageVO civo) {

		try {
			// 创建查询对象
			BasicDBObject basicDBObject = new BasicDBObject();
			// 追加条件
			basicDBObject.put("$set",
					new BasicDBObject("image", civo.getImage()));
			// 更新操作
			Update update = new BasicUpdate(basicDBObject);
			// 执行操作
			mongoTemplate.upsert(
					new Query(Criteria.where("_id").is(
							"57a1b1ffbc9e2a54e5523d0b")), update,
					"clientmanager");

		} catch (Exception e) {
			return 0;
		}
		return 1;
	}
}
