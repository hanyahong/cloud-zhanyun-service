package cc.zhanyun.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import cc.zhanyun.model.user.User;
import cc.zhanyun.model.vo.UserInfoVO;

public interface UserRepository extends MongoRepository<User, String> {

	/**
	 * �� �绰��ѯ�û���Ϣ
	 */

	public User findByPhone(String phone);

	/**
	 * �� �û����ѯ�û���Ϣ
	 */

	public User findByUsername(String username);

	/**
	 * �� �û������ѯ�û���Ϣ
	 */

	public User findByEmail(String email);

	/**
	 * Token 查询 用户
	 */
	public User findByToken(String token);

	/**
	 * 查询基本信息
	 */
	@Query(fields = "{'oid':1,'name':1,'phone':1,'company':1,'companyengname':1,'dept':1,'image':1,'email':1,'sex':1,'url':1}")
	public UserInfoVO findByOid(String oid);
}
