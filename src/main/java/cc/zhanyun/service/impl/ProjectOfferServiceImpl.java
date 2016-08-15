package cc.zhanyun.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cc.zhanyun.model.Info;
import cc.zhanyun.model.ProjectOffer;
import cc.zhanyun.model.client.Clientmanager;
import cc.zhanyun.model.image.Image;
import cc.zhanyun.model.vo.OfferVO;
import cc.zhanyun.model.vo.ProjectOfferVO;
import cc.zhanyun.repository.impl.ClientRepoImpl;
import cc.zhanyun.repository.impl.OfferRepoImpl;
import cc.zhanyun.repository.impl.ProjectOfferRepoImpl;
import cc.zhanyun.repository.impl.ProjectRepoImpl;
import cc.zhanyun.service.ProjectOfferService;
import cc.zhanyun.util.RandomUtil;
import cc.zhanyun.util.TokenUtil;

@Repository
@Service
public class ProjectOfferServiceImpl implements ProjectOfferService {

	@Autowired
	private ProjectOfferRepoImpl pori;
	@Autowired
	private ProjectRepoImpl pri;
	@Autowired
	private OfferRepoImpl ori;
	@Autowired
	private ClientRepoImpl client;
	@Autowired
	private TokenUtil tokenutil;
	@Autowired
	private ImageServiceImpl imageServiceImpl;

	/**
	 * 增加项目报价单
	 */
	@Override
	public Info addProjectOfferOne(ProjectOffer po) {
		String othername = RandomUtil.getRandomFileName();
		String imageOid = RandomUtil.getRandomFileName();
		String oid = RandomUtil.getRandomFileName();
		po.setOthername(othername);
		po.getProject().setImageOid(imageOid);
		po.setUid(tokenutil.tokenToOid());
		po.setOid(oid);
		Info info = new Info();
		try {
			// 增加项目报价单
			pori.saveProOfferOne(po);
			// 增加项目
			pri.addProject(po.getProject());
			// 增加报价
			ori.addOffer(po.getOffer());
			// 创建图库
			// 新建image库
			Image image = new Image();
			image.setOid(imageOid);
			image.setUid(tokenutil.tokenToOid());
			// 新建一个图片库
			imageServiceImpl.saveImageService(image);
			info.setOid(oid);
			info.setStatus("添加成功");
		} catch (Exception e) {
			info.setStatus("添加失败");
		}
		// info.setOid(po.getOid());
		// 判断客户信息
		String clientName = po.getOffer().getClient().getName();
		// 查询客户是否存在
		Clientmanager c = client.selClientByName(clientName);
		if (c == null) {
			Clientmanager clientmanager = new Clientmanager();
			clientmanager.setName(clientName);
			client.addClient(clientmanager);
		}
		return info;
	}

	/**
	 * 修改项目报价单
	 */
	@Override
	public Info updateProjectOfferOne(ProjectOffer po) {
		Info info = new Info();
		try {
			// 增加项目报价单
			pori.saveProOfferOne(po);
			// 增加项目
			pri.addProject(po.getProject());
			// 增加报价
			ori.addOffer(po.getOffer());
			// 以其他名查询oid
			info.setStatus("添加成功");
		} catch (Exception e) {
			info.setStatus("添加失败");
		}
		// info.setOid(po.getOid());
		// 判断客户信息
		String clientName = po.getOffer().getClient().getName();
		// 查询客户是否存在
		Clientmanager c = client.selClientByName(clientName);
		if (c == null) {
			Clientmanager clientmanager = new Clientmanager();
			clientmanager.setName(clientName);
			client.addClient(clientmanager);
		}
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

		List<ProjectOffer> polist = pori
				.selProOfferList(tokenutil.tokenToOid());
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
		List<ProjectOffer> polist = pori.selProOfferOfStatusList(status,
				tokenutil.tokenToOid());
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
	public Info updatePrijectImage(MultipartFile file, String oid) {
		Info info = new Info();
		try {
			ProjectOffer po = selProjectOfferOne(oid);
			String imageOid = po.getProject().getImageOid();

			// 上传图片
			// 作用域
			String imagelocation = "场地效果图";
			imageServiceImpl.saveImageOneService(file, imageOid, imagelocation);
			info.setStatus("成功");
		} catch (Exception e) {
			info.setStatus("失败");
		}
		return info;
	}

}
