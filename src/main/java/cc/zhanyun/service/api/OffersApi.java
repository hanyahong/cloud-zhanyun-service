package cc.zhanyun.service.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cc.zhanyun.service.model.Offer;

@Controller
@RequestMapping(value = "/offers", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/offers", description = "the offers API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-18T02:04:53.655Z")
public class OffersApi {

	@ApiOperation(value = "查询报价单列表", notes = "查询全部已经创建的报价单列表", response = Offer.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = Offer.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = Offer.class) })
	@RequestMapping(value = "", produces = { "application/json" },

	method = RequestMethod.GET)
	public ResponseEntity<List<Offer>> offersGet() throws NotFoundException {
		// do some magic!
		return new ResponseEntity<List<Offer>>(HttpStatus.OK);
	}

	@ApiOperation(value = "查询报价单列表", notes = "查询不同状态下的不同报价单列表", response = Offer.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = Offer.class),
			@ApiResponse(code = 500, message = "获取失败", response = Offer.class) })
	@RequestMapping(value = "/{status-id}", produces = { "application/json" },

	method = RequestMethod.GET)
	public ResponseEntity<List<Offer>> offersStatusIdGet(
			@ApiParam(value = "报价状态", required = true) @PathVariable("statusId") Integer statusId

	) throws NotFoundException {
		// do some magic!
		return new ResponseEntity<List<Offer>>(HttpStatus.OK);
	}

}
