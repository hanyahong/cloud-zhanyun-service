package cc.zhanyun.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cc.zhanyun.model.project.Project;
import cc.zhanyun.model.vo.ProjectVO;
import cc.zhanyun.repository.OfferRepository;
import cc.zhanyun.repository.ProjectRepository;

@Repository
public class ProjectRepoImpl {

	@Autowired
	private ProjectRepository projectRepo;
	@Autowired
	private OfferRepository offerRepo;

	/**
	 * 增加 项目
	 */
	public void addProject(Project project) {

		projectRepo.save(project);

	}

	/**
	 * 查询项目列表 部分键返回
	 */
	public List<ProjectVO> selProject() {
		// 查询项目
		return projectRepo.findByIdNotNull();

	}

	/**
	 * 查询不同状态下的报价
	 */
	public List<ProjectVO> selProjectOfStatus(Integer status) {
		return projectRepo.findByStatus(status);
	}

	/**
	 * 单条查询详情
	 */
	public Project selProjectOne(String oid) {
		return projectRepo.findOne(oid);
	}

	/**
	 * 单条删除
	 */
	public void delProjectOne(String oid) {
		projectRepo.delete(oid);
	}

}
