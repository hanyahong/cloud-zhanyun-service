package cc.zhanyun.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import javax.ws.rs.Produces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cc.zhanyun.model.project.Project;
import cc.zhanyun.model.user.Msg;
import cc.zhanyun.model.user.User;
import cc.zhanyun.model.user.UserVO;
import cc.zhanyun.model.user.Verification;
import cc.zhanyun.service.impl.UserServiceImpl;

@Controller
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
	@ApiOperation(value = "用户注册", notes = "用户注册", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "注册成功", response = Void.class),
			@ApiResponse(code = 500, message = "注册失败", response = Void.class) })
	@RequestMapping(value = "/register", produces = { APPLICATION_JSON_VALUE }, consumes = { APPLICATION_JSON_VALUE },

	method = RequestMethod.POST)
	public ResponseEntity<Void> clientPost(

	@ApiParam(value = "注册信息") @RequestBody User user) throws NotFoundException {
		// do some magic!
		service.userrRegister(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
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
	@RequestMapping(value = "/phoneVerfication", produces = { "application/json" },

	method = RequestMethod.POST)
	public Verification phonePost(
			@ApiParam(value = "登录信息") @RequestBody UserVO user)

	throws NotFoundException {
		// do some magic!

		return service.verifyUserByPhone(user.getPhone());
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
}