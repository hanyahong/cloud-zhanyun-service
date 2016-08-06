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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.zhanyun.model.resources.Resources;
import cc.zhanyun.model.resources.ResourcesTypes;
import cc.zhanyun.model.vo.ResourcesVO;
import cc.zhanyun.repository.impl.ResourcesRepoImpl;
import cc.zhanyun.service.ResourceTypeService;

@Controller
@RequestMapping(value = "/resources", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/resources", description = "the resources API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-22T07:04:29.065Z")
public class ResourcesApi {
	@Autowired
	private ResourceTypeService typeservice;
	@Autowired
	private ResourcesRepoImpl resourcesRepoImpl;

	@ApiOperation(value = "查询设备列表", notes = "查询设备列表", response = Resources.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = Resources.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = Error.class) })
	@RequestMapping(value = "", produces = { "application/json" },

	method = RequestMethod.GET)
	public @ResponseBody
	List<Resources> resourcesGet() throws NotFoundException {
		// do some magic!

		return resourcesRepoImpl.selResourcesAll();
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
	 * 增加资源
	 * 
	 * @param resources
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "增加单条设备信息", notes = "增加单条设备信息", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "添加成功", response = Void.class),
			@ApiResponse(code = 500, message = "添加失败", response = Void.class) })
	@RequestMapping(value = "", produces = { "application/json" },

	method = RequestMethod.POST)
	public ResponseEntity<Void> resourcesPost(

	@ApiParam(value = "设备详细信息") @RequestBody Resources resources)
			throws NotFoundException {
		// do some magic!
		resourcesRepoImpl.addResources(resources);
		return new ResponseEntity<Void>(HttpStatus.OK);
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
	@ApiOperation(value = "单条删除设备信息", notes = "单条删除设备信息", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "删除成功", response = Void.class),
			@ApiResponse(code = 500, message = "服务器响应错误", response = Void.class) })
	@RequestMapping(value = "/{oid}", produces = { "application/json" },

	method = RequestMethod.DELETE)
	public ResponseEntity<Void> resourcesoidDelete(
			@ApiParam(value = "客户ID", required = true) @PathVariable("oid") String oid

	) throws NotFoundException {
		// do some magic!
		resourcesRepoImpl.delResourcesOne(oid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * 删除 资源
	 * 
	 * @param oid
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "单条删除设备分类", notes = "单条删除设备分类", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "删除成功", response = Void.class),
			@ApiResponse(code = 500, message = "服务器响应错误", response = Void.class) })
	@RequestMapping(value = "/type/{oid}", produces = { "application/json" },

	method = RequestMethod.DELETE)
	public ResponseEntity<Void> resourcesTypeOidDelete(
			@ApiParam(value = "客户ID", required = true) @PathVariable("oid") String oid

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
			@ApiParam(value = "客户ID", required = true) @PathVariable("oid") String oid

	) throws NotFoundException {
		// do some magic!
		return resourcesRepoImpl.selResourcesOne(oid);
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
			@ApiParam(value = "客户ID", required = true) @PathVariable("oid") String oid

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
			@ApiParam(value = "客户ID", required = true) @PathVariable("oid") String oid

			,

			@ApiParam(value = "项目属性") @RequestBody Resources resources)
			throws NotFoundException {
		// do some magic!
		resourcesRepoImpl.addResources(resources);
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
			@ApiParam(value = "客户ID", required = true) @PathVariable("oid") String oid

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
			@ApiResponse(code = 200, message = "获取成功", response = ResourcesVO.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = ResourcesVO.class) })
	@RequestMapping(value = "/classification/{type}", produces = { "application/json" },

	method = RequestMethod.GET)
	public @ResponseBody
	List<Resources> resourcesTypeGetList(
			@ApiParam(value = "类型", required = true) @PathVariable("type") String classification)
			throws NotFoundException {
		// do some magic!

		return resourcesRepoImpl.selResourcesByType(classification);
	}
}
