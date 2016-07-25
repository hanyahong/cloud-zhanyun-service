package cc.zhanyun.service.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cc.zhanyun.service.model.Project;

@Controller
@RequestMapping(value = "/offer", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/offer", description = "the offer API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-18T02:04:53.655Z")
public class OfferApi {

	@ApiOperation(value = "删除报价单（未开启）", notes = "删除当前项目下的报价单", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "删除成功", response = Void.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = Void.class) })
	@RequestMapping(value = "/{offer-id}", produces = { "application/json" },

	method = RequestMethod.DELETE)
	public ResponseEntity<Void> offerOfferIdDelete(
			@ApiParam(value = "报价单ID", required = true) @PathVariable("offerId") String offerId

	) throws NotFoundException {
		// do some magic!
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "查询单条项目报价单", notes = "报价单单条  ", response = Object.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = Object.class),
			@ApiResponse(code = 400, message = "服务器响应失败", response = Object.class) })
	@RequestMapping(value = "/{offer-id}", produces = { "application/json" },

	method = RequestMethod.GET)
	public ResponseEntity<Object> offerOfferIdGet(
			@ApiParam(value = "报价单ID", required = true) @PathVariable("offerId") String offerId

	) throws NotFoundException {
		// do some magic!
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@ApiOperation(value = "修改单条报价单", notes = "修改单条报价单", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = Void.class),
			@ApiResponse(code = 500, message = "响应失败", response = Void.class) })
	@RequestMapping(value = "/{offer-id}", produces = { "application/json" },

	method = RequestMethod.PUT)
	public ResponseEntity<Void> offerOfferIdPut(
			@ApiParam(value = "报价单ID", required = true) @PathVariable("offerId") String offerId

			,

			@ApiParam(value = "项目属性") @RequestBody Project project)
			throws NotFoundException {
		// do some magic!
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "增加单条报价单", notes = "增加单条报价单", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = Void.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = Void.class) })
	@RequestMapping(value = "", produces = { "application/json" },

	method = RequestMethod.POST)
	public ResponseEntity<Void> offerPost(

	@ApiParam(value = "项目属性") @RequestBody Project project)
			throws NotFoundException {
		// do some magic!
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
