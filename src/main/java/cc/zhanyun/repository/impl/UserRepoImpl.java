package cc.zhanyun.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import cc.zhanyun.model.user.UpdateUserPassword;
import cc.zhanyun.model.user.User;
import cc.zhanyun.model.user.UserImageVO;
import cc.zhanyun.model.vo.UserInfoVO;
import cc.zhanyun.repository.UserRepository;

import com.mongodb.BasicDBObject;

@Repository
public class UserRepoImpl {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * 新增用户
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		userRepo.save(user);
		// System.out.println(user.getPhone() + user.getToken());
	}

	/**
	 * 查询用户基本信息
	 */
	public UserInfoVO selUserInfoOne(String oid) {
		return userRepo.findByOid(oid);
	}

	/**
	 * 修改客户资料
	 */
	public void updateUser(UserInfoVO uivo) {
		// 创建查询对象
		BasicDBObject basicDBObject = new BasicDBObject();
		// 追加条件
		basicDBObject.put(
				"$set",
				new BasicDBObject("name", uivo.getName())
						.append("sex", uivo.getSex())
						.append("company", uivo.getCompany())
						.append("dept", uivo.getDept())
						.append("phone", uivo.getPhone())
						.append("email", uivo.getEmail())
						.append("URL", uivo.getURL())
						.append("job", uivo.getJob())
						.append("image", uivo.getImage()));
		// 更新操作
		Update update = new BasicUpdate(basicDBObject);
		// 执行操作
		mongoTemplate.upsert(
				new Query(Criteria.where("_id").is(uivo.getOid())), update,
				"user");
	}

	/**
	 * 修改用户密码
	 */
	public void updateUserPwd(UpdateUserPassword up) {
		// 创建查询对象
		BasicDBObject basicDBObject = new BasicDBObject();
		// 追加条件
		basicDBObject.put("$set",
				new BasicDBObject("password", up.getPassword()));
		// 更新操作
		Update update = new BasicUpdate(basicDBObject);
		// 执行操作
		mongoTemplate.upsert(new Query(Criteria.where("_id").is(up.getOid())),
				update, "user");
	}

	/**
	 * 以 username 查询
	 */
	public User selUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	/**
	 * 以 phone 查询
	 */
	public User selUserByPhone(String phone) {
		return userRepo.findByPhone(phone);
	}

	/**
	 * 以 email 查询
	 */
	public User selUserByEmail(String email) {
		User user = userRepo.findByEmail(email);

		return user;
	}

	/**
	 * 删除用户
	 */
	public void delUser(String oid) {
		userRepo.delete(oid);
	}

	/**
	 * 查询用户
	 */
	public User selUserByToken(String token) {
		return userRepo.findByToken(token);
	}

	/**
	 * 用户id查询用户信息
	 */
	public User selUserById(String oid) {
		return userRepo.findOne(oid);
	}

	/**
	 * 保存图片
	 */
	public Integer saveUserImage(UserImageVO uivo) {

		try {
			// 创建查询对象
			BasicDBObject basicDBObject = new BasicDBObject();
			// 追加条件
			basicDBObject.put("$set",
					new BasicDBObject("image", uivo.getImage()));
			// 更新操作
			Update update = new BasicUpdate(basicDBObject);
			// 执行操作
			mongoTemplate.upsert(
					new Query(Criteria.where("_id").is(uivo.getOid())), update,
					"user");

		} catch (Exception e) {
			return 0;
		}
		return 1;
	}
}
