package cc.zhanyun.service.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.zhanyun.service.domain.ProjectService;
import cc.zhanyun.service.model.project.Project;

@Controller
@RequestMapping("/projects")
@Api(value = "/projects")
public class ProjectsApi {

	@Autowired
	private ProjectService projectService;

	@ApiOperation(value = "获取全部项目", notes = "项目列表（该权限下的全部项目） ")
	@RequestMapping(value = "", produces = { "application/json" }, method = RequestMethod.GET)
	public @ResponseBody
	List<Project> getAllProjects() throws NotFoundException {
		// do some magic!
		return projectService.getProjects();
	}

}
