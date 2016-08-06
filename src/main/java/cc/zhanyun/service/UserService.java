package cc.zhanyun.service;

import org.springframework.stereotype.Service;

import cc.zhanyun.model.user.Msg;
import cc.zhanyun.model.user.PhoneVerify;
import cc.zhanyun.model.user.User;
import cc.zhanyun.model.user.UserVO;
import cc.zhanyun.model.user.Verification;

@Service
public interface UserService {
	/**
	 * 用户注册
	 */
	public void userrRegister(User user);

	/**
	 * 验证用户名唯一性
	 */
	public Verification verifyUserByUsername(String username);

	/**
	 * 验证电话唯一性
	 * 
	 * @return
	 */
	public Verification verifyUserByPhone(String phone);

	/**
	 * 验证邮箱唯一性
	 * 
	 * @return
	 */
	public Verification verifyUserByEmail(String email);

	public Msg userLogin(UserVO user);

	/**
	 * 注册 发送短信
	 */
	public void requestSmsCode(PhoneVerify phone);

	/**
	 * 注册 验证短信
	 */
	public void verifySmsCode(String code, String phone);
}
