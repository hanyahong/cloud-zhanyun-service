package cc.zhanyun.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cc.zhanyun.model.Info;
import cc.zhanyun.model.user.Msg;
import cc.zhanyun.model.user.UpdateUserPassword;
import cc.zhanyun.model.user.User;
import cc.zhanyun.model.user.UserInfo;
import cc.zhanyun.model.user.UserVO;
import cc.zhanyun.model.user.Verification;
import cc.zhanyun.model.vo.UserInfoVO;

@Service
public interface UserService {
	/**
	 * 用户注册
	 */
	public UserInfo userrRegister(UserVO user);

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

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	public Msg userLogin(UserVO user);

	/**
	 * 注册 发送短信
	 */
	public Info requestSmsCode(String phone);

	/**
	 * 注册 验证短信
	 */
	public Info verifySmsCode(String code, String phone);

	/**
	 * 增加用户信息
	 * 
	 * @param user
	 * @return
	 */
	public Info addUserInfo(User user);

	/**
	 * 修改客户信息
	 */
	public Info updateInfo(UserInfoVO uivo);

	/**
	 * 修改用户密码
	 */
	public Info updatePassword(UpdateUserPassword up);

	/**
	 * 用户头像上传
	 */
	public Info uploadImage(String oid ,MultipartFile file);

	/**
	 * 用户查询
	 */
	public UserInfoVO selUserInfo(String oid);

}
