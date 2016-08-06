package cc.zhanyun.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cc.zhanyun.model.Info;
import cc.zhanyun.model.ProjectOffer;
import cc.zhanyun.model.location.Images;
import cc.zhanyun.model.vo.OfferVO;
import cc.zhanyun.model.vo.ProjectOfferVO;
import cc.zhanyun.repository.impl.OfferRepoImpl;
import cc.zhanyun.repository.impl.ProjectOfferRepoImpl;
import cc.zhanyun.repository.impl.ProjectRepoImpl;
import cc.zhanyun.service.ProjectOfferService;
import cc.zhanyun.util.RandomUtil;
import cc.zhanyun.util.fileutil.FileUtil;

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
	public Info addProjectOfferOne(ProjectOffer po) {
		
		Info info = new Info();
		try {
			// 增加项目报价单
			pori.saveProOfferOne(po);
			// 增加项目
			pri.addProject(po.getProject());
			// 增加报价
			ori.addOffer(po.getOffer());
		} catch (Exception e) {
			info.setStatus("添加失败");
		}
		info.setOid(po.getOid());
		info.setStatus("添加成功");
		return info;
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
			povo.setClientmanager(p.getOffer().getClient().getName());
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
			povo.setClientmanager(p.getOffer().getClient().getName());
			povolist.add(povo);
		}

		return povolist;
	}

	@Override
	public void updateProjectOfferStatus(OfferVO ovo) {
		pori.updateProjectOfferStatus(ovo);

	}

	/**
	 * 上传图片
	 */
	@Override
	public Info updatePrijectImage(MultipartFile file) {
		Info in = new Info();
		// 保存文件位置
		String url = "src\\main\\resources\\public\\";
		// String oid = tokenutil.tokenToOid();
		String oid = "57a1cc51bc9ee7ffc3ce6322";
		String folder = "projectimages";
		String othername = FileUtil.getOtherName(file);
		// 文件（IO）
		Integer status = FileUtil.uploadFile(file, oid, url, folder, othername);
		// 判断状态
		if (status == 1) {
			// 对客户数据库进行持久化
			Images images = new Images();
			// 随机产生id
			images.setImageoid(RandomUtil.getRandomFileName());
			images.setName(othername);
			images.setUrl(oid + "/" + folder + "/");
			// 持久化
			Integer info = pori.addProjectImage(images, oid);

			if (info == 1) {
				in.setStatus("上传成功");
			} else {
				in.setStatus("上传失败");
			}
		} else if (status == 0) {
			in.setStatus("上传失败，服务器错误");
		} else if (status == 2) {
			in.setStatus("上传失败，文件不能为空");
		}
		return in;
	}

}
