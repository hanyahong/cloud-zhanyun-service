package cc.zhanyun.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cc.zhanyun.model.project.Project;
import cc.zhanyun.model.vo.ProjectVO;

@Repository
@Service
public interface ProjectService {

	/**
	 * 新增项目
	 */
	public void addProjectOne(Project project);

	/**
	 * 删除项目
	 */
	public void delProjectOne(String oid);

	/**
	 * 查询项目
	 */
	public Project selProjectOne(String oid);

	/**
	 * 修改项目
	 */
	public void updateProjectOne(Project project);

	/**
	 * 查询项目列表
	 */
	public List<ProjectVO> selProjectsList();
	/**
	 * 下载项目堡 
	 */
}
