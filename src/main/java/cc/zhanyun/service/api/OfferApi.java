package cc.zhanyun.service.api;

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

import cc.zhanyun.service.domain.OfferService;
import cc.zhanyun.service.model.offer.Offer;
import cc.zhanyun.service.model.vo.OfferStatusVO;
import cc.zhanyun.service.model.vo.OfferVO;

@Controller
@RequestMapping(value = "/offer", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/offer", description = "the offer API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-18T06:37:51.280Z")
public class OfferApi {

	@Autowired
	private OfferService service;

	/**
	 * 增加 单条报价
	 * 
	 * @param offer
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "增加单条报价单", notes = "增加单条报价单", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = Void.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = Void.class) })
	@RequestMapping(value = "", produces = { "application/json" },

	method = RequestMethod.POST)
	public ResponseEntity<Void> offerPost(

	@ApiParam(value = "项目属性") @RequestBody Offer offer)
			throws NotFoundException {
		// do some magic!
		service.addOffer(offer);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * 删除报价单
	 * 
	 * @param offerId
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "删除报价单（未开启）", notes = "删除当前项目下的报价单", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "删除成功", response = Void.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = Void.class) })
	@RequestMapping(value = "/{oid}", produces = { "application/json" },

	method = RequestMethod.DELETE)
	public ResponseEntity<Void> offerOfferIdDelete(
			@ApiParam(value = "报价单ID", required = true) @PathVariable("oid") String oid

	) throws NotFoundException {
		// do some magic!
		service.delOffer(oid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * 查询单条报价
	 * 
	 * @param oid
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "查询单条项目报价单", notes = "报价单单条  ", response = Offer.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "获取成功", response = Offer.class) })
	@RequestMapping(value = "/{oid}", produces = { "application/json" },

	method = RequestMethod.GET)
	public @ResponseBody
	Offer offerOidGet(
			@ApiParam(value = "报价单ID", required = true) @PathVariable("oid") String oid

	) throws NotFoundException {
		// do some magic!
		return service.selOfferById(oid);

	}

	/**
	 * 修改报价
	 * 
	 * @param offerId
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "修改单条报价", notes = "修改单条报价", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "修改成功", response = Void.class),
			@ApiResponse(code = 500, message = "响应失败", response = Void.class) })
	@RequestMapping(value = "/{OfferId}", produces = { "application/json" },

	method = RequestMethod.PUT)
	public ResponseEntity<Void> offerOfferIdPut(
			@ApiParam(value = "报价单ID", required = true) @PathVariable("oid") String oid

			,

			@ApiParam(value = "项目属性") @RequestBody Offer offer)
			throws NotFoundException {
		// do some magic!
		service.addOffer(offer);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * 修改报价单状态
	 * 
	 * @param offerId
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "修改单条报价状态", notes = "修改单条报价状态", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "修改成功", response = Void.class),
			@ApiResponse(code = 500, message = "响应失败", response = Void.class) })
	@RequestMapping(value = "status/{offer-id}", produces = { "application/json" },

	method = RequestMethod.PUT)
	public ResponseEntity<Void> offerOidPut(
			@ApiParam(value = "报价单ID", required = true) @PathVariable("offer-id") String oid

			,

			@ApiParam(value = "项目属性") @RequestBody OfferStatusVO osvo)
			throws NotFoundException {
		// do some magic!
		service.updateOfferStatus(osvo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * 查询报价单列表
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "查询报价单列表", notes = "查询全部已经创建的报价单列表", response = OfferVO.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = OfferVO.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = OfferVO.class) })
	@RequestMapping(value = "", produces = { "application/json" },

	method = RequestMethod.GET)
	public @ResponseBody
	List<OfferVO> offerGet() throws NotFoundException {
		// do some magic!

		return service.selOffer();
	}

	/**
	 * 查询不同状态下的单列表
	 * 
	 * @param status
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "查询不同状态下的单列表", notes = "查询不同状态下的报价单列表", response = OfferVO.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = OfferVO.class),
			@ApiResponse(code = 500, message = "获取失败", response = Error.class) })
	@RequestMapping(value = "/status/{status}", produces = { "application/json" },

	method = RequestMethod.GET)
	public @ResponseBody
	List<OfferVO> offerStatusGet(
			@ApiParam(value = "报价状态", required = true) @PathVariable("status") Integer status

	) throws NotFoundException {
		// do some magic!
		return service.selOfferByStatus(status);
	}

}
