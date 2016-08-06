package cc.zhanyun.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import cc.zhanyun.model.OfferSend;
import cc.zhanyun.model.ProjectOffer;
import cc.zhanyun.model.vo.OfferVO;
import cc.zhanyun.model.vo.ProjectOfferVO;
import cc.zhanyun.service.EmailService;
import cc.zhanyun.service.impl.ProjectOfferServiceImpl;

@RestController
@RequestMapping(value = "/projectoffer", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/projectoffer", description = "the projectoffer API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-18T06:37:51.280Z")
public class ProjectOfferApi {

	@Autowired
	private ProjectOfferServiceImpl service;

	@Autowired
	private EmailService emailservice;

	/**
	 * 添加项目报价单
	 * 
	 * @param po
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "增加项目报价", notes = "单独增加项目报价 ", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "增加成功", response = Void.class),
			@ApiResponse(code = 500, message = "服务器无响应", response = Void.class) })
	@RequestMapping(value = "", produces = { "application/json" },

	method = RequestMethod.POST)
	public ResponseEntity<Info> projectPost(

	@ApiParam(value = "项目报价属性") @RequestBody ProjectOffer po)
			throws NotFoundException {
		// Smart
		// do some magic!
		Info info = service.addProjectOfferOne(po);
		return new ResponseEntity<Info>(info, HttpStatus.OK);
	}

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public ResponseEntity<Void> projectPostd(
			@RequestBody HttpServletRequest request, ProjectOffer po)
			throws Exception {
		// service.updatePrijectImage(file);
		service.addProjectOfferOne(po);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * 删除项目报价单
	 * 
	 * @param projectId
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "删除项目报价", notes = "删除项目报价 ", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "删除成功", response = Void.class),
			@ApiResponse(code = 500, message = "获取失败", response = Void.class) })
	@RequestMapping(value = "/{oid}", produces = { "application/json" },

	method = RequestMethod.DELETE)
	public ResponseEntity<Void> projectProjectIdDelete(
			@ApiParam(value = "项目ID", required = true) @PathVariable("oid") String oid

	) throws NotFoundException {
		// do some magic!
		service.delProjectOfferOne(oid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * 查询单条项目报价单详情
	 * 
	 * @param projectId
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "查询项目报价详情", notes = "项目报价详情 ", response = ProjectOffer.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = ProjectOffer.class),
			@ApiResponse(code = 200, message = "获取失败", response = ProjectOffer.class) })
	@RequestMapping(value = "/{oid}", produces = { "application/json" },

	method = RequestMethod.GET)
	public @ResponseBody
	ProjectOffer projectProjectIdGet(
			@ApiParam(value = "项目ID", required = true) @PathVariable("oid") String oid

	) throws NotFoundException {
		// do some magic!
		return service.selProjectOfferOne(oid);
	}

	/**
	 * 获取全部项目报价列表
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "获取全部项目报价列表", notes = "项目报价列表（该权限下的全部项目） ", response = ProjectOfferVO.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = ProjectOfferVO.class),
			@ApiResponse(code = 200, message = "获取失败", response = ProjectOfferVO.class) })
	@RequestMapping(value = "", produces = { "application/json" },

	method = RequestMethod.GET)
	public @ResponseBody
	List<ProjectOfferVO> projectsGet() throws NotFoundException {
		// do some magic!
		return service.selProjectOfferList();
	}

	/**
	 * 获取不同状态的项目报价列表
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "获取不同状态报价列表", notes = "获取不同状态报价列表 ", response = ProjectOfferVO.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = ProjectOfferVO.class),
			@ApiResponse(code = 200, message = "获取失败", response = ProjectOfferVO.class) })
	@RequestMapping(value = "/status/{status}", produces = { "application/json" },

	method = RequestMethod.GET)
	public @ResponseBody
	List<ProjectOfferVO> projectsOfStatusGet(
			@ApiParam(value = "项目状态", required = true) @PathVariable("status") Integer status)
			throws NotFoundException {
		// do some magic!
		return service.selProjectOfferOfStatus(status);
	}

	/**
	 * 修改项目报价状态
	 * 
	 * @param offerId
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "修改项目报价状态", notes = "修改项目报价状态", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "修改成功", response = Void.class),
			@ApiResponse(code = 500, message = "响应失败", response = Void.class) })
	@RequestMapping(value = "/{oid}/status", produces = { "application/json" },

	method = RequestMethod.PUT)
	public ResponseEntity<Void> prijectOfferStatusOidPut(
			@ApiParam(value = "报价单ID", required = true) @PathVariable("oid") String oid,
			@ApiParam(value = "项目属性") @RequestBody OfferVO ovo)
			throws NotFoundException {
		// do some magic!
		service.updateProjectOfferStatus(ovo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * 修改项目报价状态
	 * 
	 * @param offerId
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "修改项目报价", notes = "修改项目报价", response = Void.class)
	@RequestMapping(value = "/{oid}", produces = { "application/json" },

	method = RequestMethod.PUT)
	public ResponseEntity<Void> projectOfferOidPut(
			@ApiParam(value = "报价单ID", required = true) @PathVariable("oid") String oid

			,

			@ApiParam(value = "项目属性") @RequestBody ProjectOffer po)
			throws NotFoundException {
		// do some magic!
		service.addProjectOfferOne(po);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * 上传场地布局图
	 * 
	 * @param name
	 * @param file
	 * @return
	 */
	@ApiOperation(value = "上传项目效果图", notes = "上传项目效果图")
	@RequestMapping(value = "/image/", method = RequestMethod.POST)
	public Info handleProjectOfferImageUpload(MultipartFile file) {

		return service.updatePrijectImage(file);

	}

	/**
	 * 邮件发送
	 * 
	 * @param name
	 * @param file
	 * @return
	 */

	@ApiOperation(value = "邮件发送", notes = "邮件发送", response = Info.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "修改成功", response = Info.class),
			@ApiResponse(code = 500, message = "响应失败", response = Info.class) })
	@RequestMapping(value = "/email", method = RequestMethod.POST)
	public Info handleSendEmail(
			@ApiParam(value = "邮件属性") @RequestBody OfferSend offerSend) {
		return emailservice.sendAttachmentsMail(offerSend);

	}
}
