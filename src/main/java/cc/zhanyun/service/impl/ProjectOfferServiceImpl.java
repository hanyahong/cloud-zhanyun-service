package cc.zhanyun.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cc.zhanyun.model.ProjectOffer;
import cc.zhanyun.model.vo.OfferVO;
import cc.zhanyun.model.vo.ProjectOfferVO;
import cc.zhanyun.repository.impl.OfferRepoImpl;
import cc.zhanyun.repository.impl.ProjectOfferRepoImpl;
import cc.zhanyun.repository.impl.ProjectRepoImpl;
import cc.zhanyun.service.ProjectOfferService;

@Repository
@Service
public class ProjectOfferServiceImpl implements ProjectOfferService {

	@Autowired
	ProjectOfferRepoImpl pori;
	@Autowired
	ProjectRepoImpl pri;
	@Autowired
	OfferRepoImpl ori;

	/**
	 * 增加项目报价单
	 */
	@Override
	public void addProjectOfferOne(ProjectOffer po) {
		// 增加项目报价单
		pori.saveProOfferOne(po);
		// 增加项目
		pri.addProject(po.getProject());
		// 增加报价
		ori.addOffer(po.getOffer());
	}

	/**
	 * 删除项目报价单
	 */

	@Override
	public void delProjectOfferOne(String oid) {

		pori.delProOfferOne(oid);

	}

	/**
	 * 查询项目报价单
	 */
	@Override
	public ProjectOffer selProjectOfferOne(String oid) {
		// TODO Auto-generated method stub
		return pori.selProOfferOne(oid);
	}

	/**
	 * 查询项目报价单列表
	 */
	@Override
	public List<ProjectOfferVO> selProjectOfferList() {
		List<ProjectOffer> polist = pori.selProOfferList();
		List<ProjectOfferVO> povolist = new ArrayList<ProjectOfferVO>();

		for (ProjectOffer p : polist) {
			ProjectOfferVO povo = new ProjectOfferVO();
			povo.setOid(p.getOid());
			povo.setName(p.getName());
			povo.setAddress(p.getProject().getLocation().getAddress());
			povo.setStatus(p.getOffer().getStatus());
			povolist.add(povo);
		}

		return povolist;
	}

	/**
	 * 查询不同状态项目
	 */
	@Override
	public List<ProjectOfferVO> selProjectOfferOfStatus(Integer status) {
		List<ProjectOffer> polist = pori.selProOfferOfStatusList(status);
		List<ProjectOfferVO> povolist = new ArrayList<ProjectOfferVO>();

		for (ProjectOffer p : polist) {
			ProjectOfferVO povo = new ProjectOfferVO();
			povo.setOid(p.getOid());
			povo.setName(p.getName());
			povo.setAddress(p.getProject().getLocation().getAddress());
			povo.setStatus(p.getOffer().getStatus());
			povolist.add(povo);
		}

		return povolist;
	}

	/**
	 * 修改项目状态
	 */

	@Override
	public void updateProjectOfferStatus(OfferVO ovo) {
		pori.updateProjectOfferStatus(ovo);

	}

}
