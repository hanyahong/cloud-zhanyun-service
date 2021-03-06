package cc.zhanyun.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cc.zhanyun.model.Error;
import cc.zhanyun.model.Info;
import cc.zhanyun.model.client.Clientmanager;
import cc.zhanyun.model.vo.ClientVO;
import cc.zhanyun.service.impl.ClientServiceImpl;

@RestController
@RequestMapping(value = "/client", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/client", description = "the client API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-20T07:07:41.123Z")
public class ClientApi {

	@Autowired
	private ClientServiceImpl service;

	/**
	 * 删除客户
	 * 
	 * @param oid
	 * @return
	 * @throws NotFoundException
	 */

	@ApiOperation(value = "单条删除客户信息", notes = "单条删除客户信息", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "删除成功", response = Void.class),
			@ApiResponse(code = 500, message = "服务器响应错误", response = Void.class) })
	@RequestMapping(value = "/{oid}", produces = { "application/json" },

	method = RequestMethod.DELETE)
	public ResponseEntity<Void> clientoidDelete(

	@ApiParam(value = "客户ID", required = true) @PathVariable("oid") String oid

	) throws NotFoundException {
		// do some magic!

		service.delClientInfo(oid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * 单条查询
	 * 
	 * @param oid
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "查询单条客户详情", notes = "查询单条客户详情  ", response = Clientmanager.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "获取成功", response = Clientmanager.class) })
	@RequestMapping(value = "/{oid}", produces = { "application/json" },

	method = RequestMethod.GET)
	public @ResponseBody
	Clientmanager clientoidGet(

	@ApiParam(value = "客户ID", required = true) @PathVariable("oid") String oid

	) throws NotFoundException {
		// do some magic!
		Clientmanager client = service.selClientInfo(oid);
		return client;
	}

	/**
	 * 单条修改客户
	 * 
	 * @param oid
	 * @param clientmanager
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "修改单条客户", notes = "修改单条客户", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "修改成功", response = Void.class),
			@ApiResponse(code = 500, message = "响应失败", response = Void.class) })
	@RequestMapping(value = "/{oid}", produces = { "application/json" },

	method = RequestMethod.PUT)
	public ResponseEntity<Void> clientoidPut(

	@ApiParam(value = "客户ID", required = true) @PathVariable("oid") String oid,
			@ApiParam(value = "项目属性") @RequestBody Clientmanager client)
			throws NotFoundException {
		// do some magic!
		service.updateClientOne(client);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * 查询客户列表
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "查询客户列表", notes = "查询客户列表", response = ClientVO.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = ClientVO.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = Void.class) })
	@RequestMapping(value = "", produces = { "application/json" },

	method = RequestMethod.GET)
	public @ResponseBody
	List<ClientVO> clientGet() throws NotFoundException {
		// do some magic!

		return service.selClientList();
	}

	/**
	 * 增加单条客户信息
	 * 
	 * @param clientmanager
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "增加单条客户信息", notes = "增加单条客户信息", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "添加成功", response = Void.class),
			@ApiResponse(code = 500, message = "添加失败", response = Void.class) })
	@RequestMapping(value = "", produces = { "application/json" },

	method = RequestMethod.POST)
	public ResponseEntity<Info> clientPost(
			@ApiParam(value = "客户详细信息") @RequestBody Clientmanager clientmanager)
			throws NotFoundException {
		// do some magic!
		Info in = service.addClientOne(clientmanager);
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
			@ApiParam(value = "客户ID", required = true) @PathVariable("oid") String oid,
			MultipartFile file) {
		Info in = service.addClientImage(file, oid);
		return new ResponseEntity<Info>(in, HttpStatus.OK);

	}
}