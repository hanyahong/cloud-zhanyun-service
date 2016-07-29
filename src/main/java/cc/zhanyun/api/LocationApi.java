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

import cc.zhanyun.model.location.Location;
import cc.zhanyun.model.vo.LocationVO;
import cc.zhanyun.repository.impl.LocationRepoImpl;

@Controller
@RequestMapping(value = "/location", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/location", description = "the location API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-18T02:04:53.655Z")
public class LocationApi {

	@Autowired
	private LocationRepoImpl service;

	@ApiOperation(value = "查询场地列表", notes = "查询场地列表", response = LocationVO.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = LocationVO.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = LocationVO.class) })
	@RequestMapping(value = "", produces = { "application/json" },

	method = RequestMethod.GET)
	public @ResponseBody
	List<LocationVO> locationGet() throws NotFoundException {
		// do some magic!
		List<LocationVO> llist = service.selLocation();
		return llist;
	}

	/**
	 * 增加一条场地
	 * 
	 * @param location
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "增加单条场地信息", notes = "增加单条场地信息", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "添加成功", response = Void.class),
			@ApiResponse(code = 500, message = "添加失败", response = Void.class) })
	@RequestMapping(value = "", produces = { "application/json" },

	method = RequestMethod.POST)
	public ResponseEntity<Void> locationPost(

	@ApiParam(value = "场地详细信息") @RequestBody Location location)
			throws NotFoundException {
		// do some magic!
		service.addLocation(location);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * 删除单条场地
	 * 
	 * @param locationId
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "单条删除场地信息", notes = "单条删除场地信息", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "删除成功", response = Void.class),
			@ApiResponse(code = 500, message = "服务器响应错误", response = Void.class) })
	@RequestMapping(value = "/{oid}", produces = { "application/json" },

	method = RequestMethod.DELETE)
	public ResponseEntity<Void> locaitonLocationIdDelete(
			@ApiParam(value = "客户ID", required = true) @PathVariable("oid") String oid

	) throws NotFoundException {
		// do some magic!
		service.delLocationById(oid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * 单条查询
	 * 
	 * @param locationId
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "查询单条场地详情", notes = "查询单条场地详情  ", response = Location.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "获取成功", response = Location.class) })
	@RequestMapping(value = "/{oid}", produces = { "application/json" },

	method = RequestMethod.GET)
	public @ResponseBody
	Location locaitonLocationIdGet(
			@ApiParam(value = "客户ID", required = true) @PathVariable("oid") String oid

	) throws NotFoundException {
		// do some magic!
		return service.selLocationById(oid);
	}

	/**
	 * 修改单条场地
	 * 
	 * @param locationId
	 * @param location
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "修改单条场地", notes = "修改单条场地", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "修改成功", response = Void.class),
			@ApiResponse(code = 500, message = "响应失败", response = Void.class) })
	@RequestMapping(value = "/{oid}", produces = { "application/json" },

	method = RequestMethod.PUT)
	public ResponseEntity<Void> locaitonLocationIdPut(
			@ApiParam(value = "客户ID", required = true) @PathVariable("oid") String oid

			,

			@ApiParam(value = "项目属性") @RequestBody Location location)
			throws NotFoundException {
		// do some magic!
		service.addLocation(location);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
