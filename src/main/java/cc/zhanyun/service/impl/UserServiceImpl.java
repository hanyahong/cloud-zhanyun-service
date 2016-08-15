package cc.zhanyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cc.zhanyun.LeadCloud.HttpUtil;
import cc.zhanyun.LeadCloud.JavaHttpSend;
import cc.zhanyun.model.Info;
import cc.zhanyun.model.image.Image;
import cc.zhanyun.model.resources.ResourcesTypes;
import cc.zhanyun.model.user.Msg;
import cc.zhanyun.model.user.UpdateUserPassword;
import cc.zhanyun.model.user.User;
import cc.zhanyun.model.user.UserInfo;
import cc.zhanyun.model.user.UserVO;
import cc.zhanyun.model.user.Verification;
import cc.zhanyun.model.vo.UserInfoVO;
import cc.zhanyun.repository.impl.UserRepoImpl;
import cc.zhanyun.service.ImageService;
import cc.zhanyun.service.ResourceTypeService;
import cc.zhanyun.service.UserService;
import cc.zhanyun.util.RandomUtil;
import cc.zhanyun.util.TokenUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepoImpl uri;

	@Autowired
	private ResourceTypeService resourceType;
	@Autowired
	private TokenUtil token;

	@Autowired
	private ImageService imageService;

	@Override
	public UserInfo userrRegister(UserVO user) {
		// 状态
		Verification ver = null;
		String oid = RandomUtil.getRandomFileName();
		// 设置唯一ID值
		user.setOid(oid);

		// 判断输入值是否存在 （只有一个）只填写一个；
		if (user.getUsername() != null) {
			ver = verifyUserByUsername(user.getUsername());
		} else if (user.getPhone() != null) {
			User u = uri.selUserByPhone(user.getPhone());
			Verification v = new Verification();
			if (u != null) {
				v.setInfo("该电话已被注册");
				ver = v;
			} else {
				v.setInfo("该电话可用");
				ver = v;
			}

		} else if (user.getEmail() != null) {
			ver = verifyUserByEmail(user.getEmail());
		}

		UserInfo in = new UserInfo();
		try {
			// 判断数据库是否存在
			if (ver.getInfo().equals("该用户名已被注册")
					|| ver.getInfo().equals("该邮箱已被注册")
					|| ver.getInfo().equals("该电话已被注册")) {
				in.setStatus("该账户已注册，不可用");

			} else {
				User u = new User();
				u.setOid(user.getOid());
				u.setPassword(user.getPassword());
				u.setPhone(user.getPhone());
				u.setEmail(user.getEmail());
				u.setUsername(user.getUsername());

				// 暂时随机生成token
				u.setToken(RandomUtil.getRandomFileName());

				// 持久化保存数据
				uri.addUser(u);
				// 返回信息
				in.setStatus("注册成功");
				in.setOid(oid);
				in.setToken(u.getToken());
				// 查询uid
				String uid = null;

				// 注册成功以后，默认添加设备分类
				ResourcesTypes type1 = new ResourcesTypes();
				type1.setName("其他");
				type1.setUid(uid);
				resourceType.saveTypeOne(type1);
				ResourcesTypes type2 = new ResourcesTypes();
				type2.setName("灯光");
				type2.setUid(uid);
				resourceType.saveTypeOne(type2);
				ResourcesTypes type3 = new ResourcesTypes();
				type3.setName("音频");
				type3.setUid(uid);
				resourceType.saveTypeOne(type3);
				ResourcesTypes type4 = new ResourcesTypes();
				type4.setName("视频");
				type4.setUid(uid);
				resourceType.saveTypeOne(type4);
				// 注册成功以后，默认生成用户图片库
				// 新建image库
				String imageOid = RandomUtil.getRandomFileName();
				Image image = new Image();
				image.setOid(imageOid);
				image.setUid(token.tokenToOid());
				// 新建一个图片库
				imageService.saveImageService(image);

			}
		} catch (Exception e) {
			in.setStatus("注册失败，不能输入空值");
		}
		return in;
	}

	@Override
	public Verification verifyUserByUsername(String username) {
		// TODO Auto-generated method stub
		Verification ver = new Verification();
		User user = uri.selUserByUsername(username);
		if (user != null) {
			// ver.setStatus("查询成功");
			ver.setInfo("该用户名已被注册");
		} else {
			ver.setInfo("该用户可用");
		}
		return ver;
	}

	@Override
	public Verification verifyUserByPhone(String phone) {
		// TODO Auto-generated method stub
		Verification ver = new Verification();

		User user = uri.selUserByPhone(phone);
		if (user != null) {
			// ver.setStatus("查询成功");
			ver.setInfo("该电话已被注册");
		} else {
			Info info = requestSmsCode(phone);
			ver.setInfo(info.getStatus());
		}
		return ver;
	}

	@Override
	public Verification verifyUserByEmail(String email) {
		// TODO Auto-generated method stub
		Verification ver = new Verification();
		User user = uri.selUserByEmail(email);
		if (user != null) {
			// ver.setStatus("查询成功");
			ver.setInfo("该邮箱已被注册");
		} else {
			ver.setInfo("该邮箱可用");
		}
		return ver;
	}

	@Override
	public Msg userLogin(UserVO user) {
		User u = new User();
		Msg msg = new Msg();

		try {
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
					msg.setInfo("登录成功");
				} else {
					msg.setInfo("登陆失败，未授权");
				}
				// 返回

			} else {
				msg.setInfo("登录失败，密码错误");
			}
			return msg;
		} catch (Exception e) {
			msg.setInfo("登录失败，用户不存在");
		}
		return msg;
	}

	/**
	 * 发送短信
	 */
	@Override
	public Info requestSmsCode(String phone) {
		Info in = new Info();
		// leanCloud API 短信发送
		String apiUrl = "https://api.leancloud.cn/1.1/requestSmsCode";
		// 添加键
		String json = "{\"mobilePhoneNumber\":\"" + phone + "\"}";
		try {
			String resp = JavaHttpSend.sendPost(apiUrl, json);
			System.out.println(resp);
			if (resp.equals(200)) {
				in.setStatus("发送成功");
			} else {
				in.setStatus("发送失败");
			}
		} catch (Exception e) {
			in.setStatus("发送失败500");
		}

		return in;
	}

	/**
	 * 验证短信
	 */
	@Override
	public Info verifySmsCode(String code, String phone) {
		Info in = new Info();
		// leandCloud API 验证短信
		String apiUrl = "https://api.leancloud.cn/1.1/verifySmsCode/" + code
				+ "?mobilePhoneNumber=" + phone;
		// 添加键值对
		Integer status = HttpUtil.doPost(apiUrl);
		System.out.println(status);
		if (status == 200) {
			in.setStatus("验证成功");
		} else {
			in.setStatus("验证失败");
		}
		return in;
	}

	/**
	 * 增加用户信息
	 */
	@Override
	public Info addUserInfo(User user) {
		Info in = new Info();
		try {
			uri.addUser(user);

			in.setStatus("添加成功");
		} catch (Exception e) {
			in.setStatus("添加失败");
		}

		return in;
	}

	/**
	 * 修改客户信息
	 */
	@Override
	public Info updateInfo(UserInfoVO uivo) {
		Info in = new Info();
		try {
			uri.updateUser(uivo);
			in.setStatus("修改成功");
		} catch (Exception e) {
			in.setStatus("修改失败");
		}
		return in;
	}

	@Override
	public Info updatePassword(UpdateUserPassword up) {
		Info info = new Info();
		try {
			uri.updateUserPwd(up);
			info.setStatus("修改成功");
		} catch (Exception e) {
			info.setStatus("修改失败");
		}
		return info;
	}

	@Override
	public Info uploadImage(String oid, MultipartFile file) {
		Info info = new Info();
		try {
			String imageOid = selUserInfo(token.tokenToOid()).getImage();

			// 上传图片
			// 作用域
			String imagelocation = "客户头像";
			imageService.saveImageOneService(file, imageOid, imagelocation);
			info.setStatus("成功");
		} catch (Exception e) {
			info.setStatus("失败");
		}

		return info;
	}

	@Override
	public UserInfoVO selUserInfo(String oid) {
		// TODO Auto-generated method stub
		return uri.selUserInfoOne(oid);
	}

	/**
	 * 手机号码注册或登录
	 */

	// @Override
	// public UserLeanCloud usersByMobilePhone(SmsCode smscode) {
	// String apiUrl = "https://api.leancloud.cn/1.1/usersByMobilePhone";
	// Map<String, Object> params = new HashMap<String, Object>();
	// params.put("mobilePhoneNumber", smscode.getMobilePhoneNumber());
	// params.put("smsCode", smscode.getSmscode());
	//
	// HttpUtil.doPost(apiUrl, params);
	// return null;
	// }

}
