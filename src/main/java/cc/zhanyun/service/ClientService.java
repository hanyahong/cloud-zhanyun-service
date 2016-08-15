package cc.zhanyun.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cc.zhanyun.model.Info;
import cc.zhanyun.model.client.Clientmanager;
import cc.zhanyun.model.vo.ClientVO;

@Service
public interface ClientService {

	/**
	 * 增加客户
	 */
	public Info addClientOne(Clientmanager client);

	/**
	 * 上传客户头像
	 */
	public Info addClientImage(MultipartFile file, String oid);

	/**
	 * 查询客户信息
	 */
	public Clientmanager selClientInfo(String oid);

	/**
	 * 删除客户信息
	 */
	public Info delClientInfo(String oid);

	/**
	 * 查询客户列表
	 */
	public List<ClientVO> selClientList();

	/**
	 * 修改用户信息
	 * 
	 * @param client
	 * @return
	 */
	public Info updateClientOne(Clientmanager client);
}
