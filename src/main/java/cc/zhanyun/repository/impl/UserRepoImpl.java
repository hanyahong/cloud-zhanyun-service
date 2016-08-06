package cc.zhanyun.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cc.zhanyun.model.user.User;
import cc.zhanyun.repository.UserRepository;

@Repository
public class UserRepoImpl {

	@Autowired
	private UserRepository userRepo;

	/**
	 * 新增用户
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		userRepo.save(user);
		System.out.println(user.getPhone() + user.getToken());
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
		System.out.println(user.getPassword());
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

}
