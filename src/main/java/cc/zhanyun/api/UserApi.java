package cc.zhanyun.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cc.zhanyun.model.Error;
import cc.zhanyun.model.Info;
import cc.zhanyun.model.user.Msg;
import cc.zhanyun.model.user.UpdateUserPassword;
import cc.zhanyun.model.user.UserInfo;
import cc.zhanyun.model.user.UserVO;
import cc.zhanyun.model.user.Verification;
import cc.zhanyun.model.vo.UserInfoVO;
import cc.zhanyun.service.impl.UserServiceImpl;

@RestController
@RequestMapping(value = "/user", produces = { APPLICATION_JSON_VALUE }, consumes = { APPLICATION_JSON_VALUE })
@Api(value = "/user", description = "the register API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-20T07:07:41.123Z")
public class UserApi {

	@Autowired
	private UserServiceImpl service;

	/**
	 * 用户注册
	 * 
	 * @param clientmanager
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "用户注册", notes = "用户注册", response = UserInfo.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "注册成功", response = UserInfo.class),
			@ApiResponse(code = 500, message = "注册失败", response = Void.class) })
	@RequestMapping(value = "/register", produces = { APPLICATION_JSON_VALUE }, consumes = { APPLICATION_JSON_VALUE },

	method = RequestMethod.POST)
	public ResponseEntity<UserInfo> clientPost(

	@ApiParam(value = "注册信息") @RequestBody UserVO uservo) {
		// do some magic!
		UserInfo in = null;

		in = service.userrRegister(uservo);

		return new ResponseEntity<UserInfo>(in, HttpStatus.OK);
	}

	/**
	 * 用户登录
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "用户登录", notes = "用户登录", response = Msg.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = Msg.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = Msg.class) })
	@RequestMapping(value = "/login", produces = { "application/json" },

	method = RequestMethod.POST)
	public Msg userRegisterGet(
			@ApiParam(value = "登录信息") @RequestBody UserVO user)

	throws NotFoundException {
		// do some magic!

		return service.userLogin(user);
	}

	/**
	 * 用户手机验证
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "用户手机验证", notes = "用户手机验证", response = Verification.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = Verification.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = Verification.class) })
	@RequestMapping(value = "/phoneVerfication/{phone}", produces = { "application/json" },

	method = RequestMethod.POST)
	public Verification phonePost(
			@ApiParam(value = "手机号码") @PathVariable("phone") String phone)

	throws NotFoundException {
		// do some magic!

		return service.verifyUserByPhone(phone);
	}

	/**
	 * 用户邮箱验证
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "用户邮箱验证", notes = "用户邮箱验证", response = Verification.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = Verification.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = Verification.class) })
	@RequestMapping(value = "/emailVerfication", produces = { "application/json" },

	method = RequestMethod.POST)
	public Verification emailPost(
			@ApiParam(value = "登录信息") @RequestBody UserVO user)

	throws NotFoundException {
		// do some magic!

		return service.verifyUserByEmail(user.getPhone());
	}

	/**
	 * 用户用户名验证
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "用户用户名验证", notes = "用户用户名验证", response = Verification.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = Verification.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = Verification.class) })
	@RequestMapping(value = "/usernameVerfication", produces = { "application/json" },

	method = RequestMethod.POST)
	public Verification usernamePost(
			@ApiParam(value = "登录信息") @RequestBody UserVO user)

	throws NotFoundException {
		// do some magic!

		return service.verifyUserByUsername(user.getPhone());
	}

	/**
	 * 修改用户信息
	 * 
	 * @param clientmanager
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "修改用户信息", notes = "修改单条用户信息", response = Void.class, responseContainer = "List")
	@RequestMapping(value = "/userinfo", produces = { "application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<Info> userInfoPut(
			@ApiParam(value = "用户详细信息") @RequestBody UserInfoVO uivo) {
		Info info = service.updateInfo(uivo);
		return new ResponseEntity<Info>(info, HttpStatus.OK);
	}

	/**
	 * 查询用户基本资料信息
	 * 
	 * @param clientmanager
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "修改用户信息", notes = "修改单条用户信息", response = Void.class, responseContainer = "List")
	@RequestMapping(value = "/userinfo/{oid}", produces = { "application/json" }, method = RequestMethod.POST)
	public UserInfoVO userInfoPost(
			@ApiParam(value = "用户详细信息") @PathVariable("oid") String oid) {
		return service.selUserInfo(oid);
	}

	/**
	 * 修改用户密码
	 * 
	 * @param clientmanager
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "修改用户密码", notes = "修改单条用户密码", response = Void.class, responseContainer = "List")
	@RequestMapping(value = "/userpwd", produces = { "application/json" }, method = RequestMethod.POST)
	public ResponseEntity<Info> userPasswordPost(
			@ApiParam(value = "用户详细信息") @RequestBody UpdateUserPassword up) {
		Info info = service.updatePassword(up);
		return new ResponseEntity<Info>(info, HttpStatus.OK);
	}

	/**
	 * 验证手机短信
	 * 
	 * @param clientmanager
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "短信验证", notes = "短信验证", response = Void.class)
	@RequestMapping(value = "/sendSMS", produces = { "application/json" }, method = RequestMethod.POST)
	public ResponseEntity<Info> sendSMSPost(

	@ApiParam(value = "用户信息") @RequestBody UserVO user) {
		// do some magic!
		Info in = service.verifySmsCode(user.getCode(), user.getPhone());
		return new ResponseEntity<Info>(in, HttpStatus.OK);
	}

	/**
	 * 上传头像
	 * 
	 * @param name
	 * @param file
	 * @return
	 */
	@ApiOperation(value = "上传头像", notes = "上传头像", response = Info.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = Info.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = Error.class) })
	@RequestMapping(value = "/upload/{oid}", method = RequestMethod.POST)
	public ResponseEntity<Info> handleFileUpload(
			@ApiParam(value = "用户ID", required = true) @PathVariable("oid") String oid,
			MultipartFile file) {
		Info in = service.uploadImage(oid, file);
		return new ResponseEntity<Info>(in, HttpStatus.OK);

	}
}