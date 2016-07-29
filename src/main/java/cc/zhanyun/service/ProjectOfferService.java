package cc.zhanyun.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cc.zhanyun.model.ProjectOffer;
import cc.zhanyun.model.vo.OfferVO;
import cc.zhanyun.model.vo.ProjectOfferVO;

@Repository
@Service
public interface ProjectOfferService {

	/**
	 * 增加项目报价单
	 */
	public void addProjectOfferOne(ProjectOffer po);

	/**
	 * 删除项目报价单
	 */
	public void delProjectOfferOne(String oid);

	/**
	 * 查询项目报价单
	 */
	public ProjectOffer selProjectOfferOne(String oid);

	/**
	 * 查询项目报价单列表
	 */
	public List<ProjectOfferVO> selProjectOfferList();

	/**
	 * 按照 项目报价状态查询报价
	 */
	public List<ProjectOfferVO> selProjectOfferOfStatus(Integer status);

	/**
	 * 修改 项目报价状态
	 */
	public void updateProjectOfferStatus(OfferVO ovo);
}
