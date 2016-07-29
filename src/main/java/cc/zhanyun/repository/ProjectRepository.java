package cc.zhanyun.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import cc.zhanyun.model.project.Project;
import cc.zhanyun.model.vo.ProjectVO;

public interface ProjectRepository extends MongoRepository<Project, String> {

	/**
	 * 查询项目列表 部分字段（列表）
	 * 
	 * @return List Of Clients
	 */
	@Query(value = "{'_id':{'$ne':null}}", fields = "{'oid':1,'name':1,'client':1}")
	public List<ProjectVO> findByIdNotNull();

	/**
	 * 查询不同状态的项目
	 */
	@Query(value = "{'status':{'$ne':null}}", fields = "{'oid':1,'name':1,'location.address':1,'offer.status':1,'client':1}")
	public List<ProjectVO> findByStatus(Integer status);

}
