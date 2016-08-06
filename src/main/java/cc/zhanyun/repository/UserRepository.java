package cc.zhanyun.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cc.zhanyun.model.user.User;

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
}
