package cc.zhanyun.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.zhanyun.model.user.Msg;
import cc.zhanyun.model.user.PhoneVerify;
import cc.zhanyun.model.user.User;
import cc.zhanyun.model.user.UserVO;
import cc.zhanyun.model.user.Verification;
import cc.zhanyun.repository.impl.UserRepoImpl;
import cc.zhanyun.service.UserService;
import cc.zhanyun.util.httpclient.HttpUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepoImpl uri;

	@Override
	public void userrRegister(User user) {
		// TODO Auto-generated method stub
		uri.addUser(user);
	}

	@Override
	public Verification verifyUserByUsername(String username) {
		// TODO Auto-generated method stub
		Verification ver = new Verification();
		User user = uri.selUserByUsername(username);
		if (user.getOid() == null) {
			ver.setStatus("查询成功");
			ver.setInfo("该用户名已被注册！！");
		}
		return ver;
	}

	@Override
	public Verification verifyUserByPhone(String phone) {
		// TODO Auto-generated method stub
		Verification ver = new Verification();
		User user = uri.selUserByPhone(phone);
		if (user.getOid() == null) {
			ver.setStatus("查询成功");
			ver.setInfo("该电话已被注册！！");
		}
		return ver;
	}

	@Override
	public Verification verifyUserByEmail(String email) {
		// TODO Auto-generated method stub
		Verification ver = new Verification();
		User user = uri.selUserByEmail(email);
		if (user.getOid() == null) {
			ver.setStatus("查询成功");
			ver.setInfo("该邮箱已被注册！！");
		}
		return ver;
	}

	@Override
	public Msg userLogin(UserVO user) {
		User u = new User();
		Msg msg = new Msg();
		// 判断唯一键值
		if (user.getUsername() != null) {
			u = uri.selUserByUsername(user.getUsername());
		} else if (user.getPhone() != null) {
			u = uri.selUserByPhone(user.getPhone());
		} else if (user.getEmail() != null) {
			u = uri.selUserByEmail(user.getEmail());
		}

		// 验证密码是否正确
		if (u.getPassword().equals(user.getPassword())) {
			// 正确

			msg.setName(u.getName());
			msg.setOid(u.getOid());
			msg.setToken(u.getToken());
			if (u.getToken() != null) {
				msg.setInfo("登录成功！！");
			} else {
				msg.setInfo("登录失败！！");
			}
			// 返回
			return msg;
		}
		msg.setInfo("登录失败！！");
		return msg;
	}

	/**
	 * 发送短信
	 */
	@Override
	public void requestSmsCode(PhoneVerify phone) {
		String apiUrl = "https://leancloud.cn/1.1/requestSmsCode";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mobilePhoneNumber", phone.getPhone());

		HttpUtil.doPostSSL(apiUrl, params);

	}

	@Override
	public void verifySmsCode(String code, String phone) {
		String apiUrl = "https://leancloud.cn/1.1/requestSmsCode" + code
				+ "mobilePhoneNumber=" + phone;
		

	}
}
