package cc.zhanyun.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cc.zhanyun.model.project.Project;

@Controller
@RequestMapping(value = "/projects", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/projects", description = "the projects API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-18T06:37:51.280Z")
public class ProjectsApi {

	@ApiOperation(value = "获取全部项目", notes = "项目列表（该权限下的全部项目） ", response = Project.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = Project.class),
			@ApiResponse(code = 200, message = "获取失败", response = Project.class) })
	@RequestMapping(value = "", produces = { "application/json" },

	method = RequestMethod.GET)
	public ResponseEntity<List<Project>> projectsGet() throws NotFoundException {
		// do some magic!
		return new ResponseEntity<List<Project>>(HttpStatus.OK);
	}

}
