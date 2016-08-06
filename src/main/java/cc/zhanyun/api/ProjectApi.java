package cc.zhanyun.api;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cc.zhanyun.model.Info;
import cc.zhanyun.model.project.Project;

@Controller
@RequestMapping(value = "/project", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/project", description = "the projects API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-18T06:37:51.280Z")
public class ProjectApi {

	@ApiOperation(value = "增加项目", notes = "单独增加项目（暂未开放） ", response = Info.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "增加成功", response = Info.class),
			@ApiResponse(code = 500, message = "服务器无响应", response = Info.class) })
	@RequestMapping(value = "", produces = { "application/json" },

	method = RequestMethod.POST)
	public ResponseEntity<Info> projectPost(

	@ApiParam(value = "项目属性") @RequestBody Project p) throws NotFoundException {
		// do some magic!
		return new ResponseEntity<Info>(HttpStatus.OK);
	}

	@ApiOperation(value = "删除项目", notes = "删除项目（暂未开放） ", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "删除成功", response = Void.class),
			@ApiResponse(code = 500, message = "获取失败", response = Void.class) })
	@RequestMapping(value = "/{project-id}", produces = { "application/json" },

	method = RequestMethod.DELETE)
	public ResponseEntity<Void> projectProjectIdDelete(
			@ApiParam(value = "项目ID", required = true) @PathVariable("projectId") String projectId

	) throws NotFoundException {
		// do some magic!
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "查询项目详情", notes = "项目详情 ", response = Project.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = Project.class),
			@ApiResponse(code = 200, message = "获取失败", response = Project.class) })
	@RequestMapping(value = "/{project-id}", produces = { "application/json" },

	method = RequestMethod.GET)
	public ResponseEntity<List<Project>> projectProjectIdGet(
			@ApiParam(value = "项目ID", required = true) @PathVariable("projectId") String projectId

	) throws NotFoundException {
		// do some magic!
		return new ResponseEntity<List<Project>>(HttpStatus.OK);
	}

}
