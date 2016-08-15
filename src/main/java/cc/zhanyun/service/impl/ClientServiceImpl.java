package cc.zhanyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cc.zhanyun.model.Info;
import cc.zhanyun.model.client.Clientmanager;
import cc.zhanyun.model.image.Image;
import cc.zhanyun.model.vo.ClientVO;
import cc.zhanyun.repository.impl.ClientRepoImpl;
import cc.zhanyun.service.ClientService;
import cc.zhanyun.service.ImageService;
import cc.zhanyun.util.RandomUtil;
import cc.zhanyun.util.TokenUtil;

@Service
public class ClientServiceImpl implements ClientService {
	/**
	 * 上传头像
	 */

	@Autowired
	private ClientRepoImpl clientRepoImpl;

	@Autowired
	private TokenUtil token;

	@Autowired
	private ImageService imageService;

	/**
	 * 增加
	 */
	@Override
	public Info addClientOne(Clientmanager client) {
		// TODO Auto-generated method stub
		Info info = new Info();
		String oid = RandomUtil.getRandomFileName();
		String imageOid = RandomUtil.getRandomFileName();
		String uid = token.tokenToOid();

		try {
			client.setOid(oid);
			client.setUid(uid);
			client.setImage(imageOid);
			clientRepoImpl.addClient(client);

			// 新建image库s
			Image image = new Image();
			image.setOid(imageOid);
			image.setUid(token.tokenToOid());
			// 新建一个图片库
			imageService.saveImageService(image);

			info.setOid(oid);
			info.setStatus("添加成功");
		} catch (Exception e) {
			info.setStatus("添加失败");
		}

		return info;
	}

	/**
	 * 更新
	 */
	@Override
	public Info updateClientOne(Clientmanager client) {
		// TODO Auto-generated method stub
		Info info = new Info();
		try {
			clientRepoImpl.addClient(client);
			info.setStatus("添加成功");
		} catch (Exception e) {
			info.setStatus("添加失败");
		}

		return info;
	}

	@Override
	public Info addClientImage(MultipartFile file, String oid) {
		Info info = new Info();
		try {
			String imageOid = selClientInfo(oid).getImage();
			// 上传图片
			// 作用域
			String imagelocation = "客户头像";
			imageService.saveImageOneService(file, imageOid, imagelocation);
			info.setStatus("成功");
		} catch (Exception e) {
			info.setStatus("失败");
		}

		return info;
	}

	@Override
	public Clientmanager selClientInfo(String oid) {
		// TODO Auto-generated method stub
		return clientRepoImpl.selClientById(oid);
	}

	@Override
	public Info delClientInfo(String oid) {
		Info info = new Info();
		// TODO Auto-generated method stub
		try {
			clientRepoImpl.delClient(oid);
			info.setStatus("成功");
		} catch (Exception e) {
			info.setStatus("失败");
		}

		return info;
	}

	@Override
	public List<ClientVO> selClientList() {
		String uid = token.tokenToOid();
		return clientRepoImpl.selClients(uid);

	}
}
