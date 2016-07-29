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
import cc.zhanyun.model.vo.ResourcesVO;
import cc.zhanyun.repository.impl.ResourcesRepoImpl;

@Controller
@RequestMapping(value = "/resources", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/resources", description = "the resources API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-22T07:04:29.065Z")
public class ResourcesApi {

	@Autowired
	private ResourcesRepoImpl resourcesRepoImpl;

	@ApiOperation(value = "查询设备列表", notes = "查询设备列表", response = ResourcesVO.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = ResourcesVO.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = ResourcesVO.class) })
	@RequestMapping(value = "", produces = { "application/json" },

	method = RequestMethod.GET)
	public @ResponseBody
	List<ResourcesVO> resourcesGet() throws NotFoundException {
		// do some magic!

		return resourcesRepoImpl.selResources();
	}

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

}
