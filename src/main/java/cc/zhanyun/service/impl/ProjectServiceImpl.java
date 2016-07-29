package cc.zhanyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cc.zhanyun.model.project.Project;
import cc.zhanyun.model.vo.ProjectVO;
import cc.zhanyun.repository.impl.ProjectRepoImpl;
import cc.zhanyun.service.ProjectService;

@Repository
@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepoImpl rpi;

	@Override
	public void addProjectOne(Project project) {
		rpi.addProject(project);
	}

	@Override
	public void delProjectOne(String oid) {
		// TODO Auto-generated method stub
		rpi.delProjectOne(oid);
	}

	@Override
	public Project selProjectOne(String oid) {

		return rpi.selProjectOne(oid);
	}

	@Override
	public void updateProjectOne(Project project) {
		rpi.addProject(project);

	}

	@Override
	public List<ProjectVO> selProjectsList() {
		// TODO Auto-generated method stub
		return rpi.selProject();
	}

}
