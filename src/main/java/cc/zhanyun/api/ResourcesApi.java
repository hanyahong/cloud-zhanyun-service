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

import cc.zhanyun.model.Info;
import cc.zhanyun.model.resources.ResourceStatusVO;
import cc.zhanyun.model.resources.Resources;
import cc.zhanyun.model.resources.ResourcesTypes;
import cc.zhanyun.repository.impl.ResourcesRepoImpl;
import cc.zhanyun.service.ResourceService;
import cc.zhanyun.service.ResourceTypeService;

@RestController
@RequestMapping(value = "/resources", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/resources", description = "the resources API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-22T07:04:29.065Z")
public class ResourcesApi {
	@Autowired
	private ResourceTypeService typeservice;
	@Autowired
	private ResourceService service;
	@Autowired
	private ResourcesRepoImpl repo;

	/**
	 * 查询设备列表
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "查询设备列表", notes = "查询设备列表", response = Resources.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = Resources.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = Error.class) })
	@RequestMapping(value = "", produces = { "application/json" },

	method = RequestMethod.GET)
	public @ResponseBody
	List<Resources> resourcesGet() throws NotFoundException {
		// do some magic!

		return service.selResourceList();
	}

	/**
	 * 查询分类列表
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "查询设备分类列表", notes = "查询设备分类列表", response = ResourcesTypes.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = ResourcesTypes.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = ResourcesTypes.class) })
	@RequestMapping(value = "/type", produces = { "application/json" },

	method = RequestMethod.GET)
	public @ResponseBody
	List<ResourcesTypes> resourcesTypeGet() throws NotFoundException {
		// do some magic!

		return typeservice.selTypeAll();
	}

	/**
	 * 增加单条场地信息
	 * 
	 * @param clientmanager
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "增加单条设备信息", notes = "增加单设备地信息", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "添加成功", response = Void.class),
			@ApiResponse(code = 500, message = "添加失败", response = Void.class) })
	@RequestMapping(value = "", produces = { "application/json" },

	method = RequestMethod.POST)
	public ResponseEntity<ResourceStatusVO> resourcePost(
			@ApiParam(value = "场地详细信息") @RequestBody Resources resources)
			throws NotFoundException {
		// do some magic!
		ResourceStatusVO in = service.addResource(resources);
		return new ResponseEntity<ResourceStatusVO>(in, HttpStatus.OK);
	}

	/**
	 * 增加资源分类
	 * 
	 * @param resources
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "增加单条设备分类", notes = "增加单条设备分类", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "添加成功", response = Void.class),
			@ApiResponse(code = 500, message = "添加失败", response = Void.class) })
	@RequestMapping(value = "/type", produces = { "application/json" },

	method = RequestMethod.POST)
	public ResponseEntity<Void> resourcesTypePost(

	@ApiParam(value = "分类信息") @RequestBody ResourcesTypes type)
			throws NotFoundException {
		// do some magic!
		typeservice.saveTypeOne(type);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * 删除 资源信息
	 * 
	 * @param oid
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "单条删除设备信息", notes = "单条删除设备信息", response = Info.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "删除成功", response = Info.class),
			@ApiResponse(code = 500, message = "服务器响应错误", response = Info.class) })
	@RequestMapping(value = "/{oid}", produces = { "application/json" },

	method = RequestMethod.DELETE)
	public ResponseEntity<Info> resourcesoidDelete(
			@ApiParam(value = "ID", required = true) @PathVariable("oid") String oid

	) throws NotFoundException {
		// do some magic!
		Info info = service.delResourceOne(oid);
		return new ResponseEntity<Info>(info, HttpStatus.OK);
	}

	/**
	 * 删除 资源分类
	 * 
	 * @param oid
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "单条删除设备分类", notes = "单条删除设备分类", response = Info.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "删除成功", response = Info.class),
			@ApiResponse(code = 500, message = "服务器响应错误", response = Info.class) })
	@RequestMapping(value = "/type/{oid}", produces = { "application/json" },

	method = RequestMethod.DELETE)
	public ResponseEntity<Void> resourcesTypeOidDelete(
			@ApiParam(value = "资源分类ID", required = true) @PathVariable("oid") String oid

	) throws NotFoundException {
		// do some magic!

		typeservice.delTypeOne(oid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * 查询单条资源信息
	 * 
	 * @param oid
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "查询单条设备详情", notes = "查询单条设备详情  ", response = Resources.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = Resources.class),
			@ApiResponse(code = 404, message = "未找到查找内容", response = Void.class) })
	@RequestMapping(value = "/{oid}", produces = { "application/json" },

	method = RequestMethod.GET)
	public @ResponseBody
	Resources resourcesoidGet(
			@ApiParam(value = "ID", required = true) @PathVariable("oid") String oid

	) throws NotFoundException {
		// do some magic!
		return service.selResourceOne(oid);
	}

	/**
	 * 查询单条分类信息
	 * 
	 * @param oid
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "查询单条设备分类", notes = "查询单条设备分类  ", response = ResourcesTypes.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = ResourcesTypes.class),
			@ApiResponse(code = 404, message = "未找到查找内容", response = Void.class) })
	@RequestMapping(value = "/type/{oid}", produces = { "application/json" },

	method = RequestMethod.GET)
	public @ResponseBody
	ResourcesTypes resourcesTypeOidGet(
			@ApiParam(value = "ID", required = true) @PathVariable("oid") String oid

	) throws NotFoundException {
		// do some magic!
		return typeservice.selTypeOne(oid);
	}

	/**
	 * 修改资源
	 * 
	 * @param oid
	 * @param resources
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "修改单条设备", notes = "修改单条设备", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "修改成功", response = Void.class),
			@ApiResponse(code = 500, message = "响应失败", response = Void.class) })
	@RequestMapping(value = "/{oid}", produces = { "application/json" },

	method = RequestMethod.PUT)
	public ResponseEntity<Void> resourcesoidPut(
			@ApiParam(value = "ID", required = true) @PathVariable("oid") String oid

			,

			@ApiParam(value = "项目属性") @RequestBody Resources resources)
			throws NotFoundException {
		// do some magic!
		service.updateResource(resources);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * 修改资源分类
	 * 
	 * @param oid
	 * @param resources
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "修改单条设备分类", notes = "修改单条设备分类", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "修改成功", response = Void.class),
			@ApiResponse(code = 500, message = "响应失败", response = Void.class) })
	@RequestMapping(value = "/type/{oid}", produces = { "application/json" },

	method = RequestMethod.PUT)
	public ResponseEntity<Void> resourcesTypeoidPut(
			@ApiParam(value = "ID", required = true) @PathVariable("oid") String oid

			,

			@ApiParam(value = "项目属性") @RequestBody ResourcesTypes type)
			throws NotFoundException {
		// do some magic!
		typeservice.saveTypeOne(type);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * 以分类 查询 资源列表
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "按分类查询设备分类列表(手机端)", notes = "按分类查询设备分类列表(手机端)", response = Resources.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = Resources.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = Resources.class) })
	@RequestMapping(value = "/classification/{type}", produces = { "application/json" },

	method = RequestMethod.GET)
	public @ResponseBody
	List<Resources> resourcesTypeGetList(
			@ApiParam(value = "分类", required = true) @PathVariable("type") String type)
			throws NotFoundException {
		// do some magic!

		return service.selResourceOneByType(type);
	}

	/**
	 * 上传资源图片
	 * 
	 * @param name
	 * @param file
	 * @return
	 */
	@ApiOperation(value = "上传资源图片", notes = "上传资源图片")
	@RequestMapping(value = "/image/{oid}", method = RequestMethod.POST)
	public Info handleResourceImageUpload(
			@ApiParam(value = "资源ID", required = true) @PathVariable("oid") String oid,

			MultipartFile file) {

		return service.addResourceImage(file, oid);

	}
}
