package cc.zhanyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cc.zhanyun.model.Info;
import cc.zhanyun.model.vo.ClientimageVO;
import cc.zhanyun.repository.impl.ClientRepoImpl;
import cc.zhanyun.repository.impl.FileRepoImpl;
import cc.zhanyun.service.ClientService;
import cc.zhanyun.util.TokenUtil;
import cc.zhanyun.util.fileutil.FileUtil;

@Service
public class ClientServiceImpl implements ClientService {
	/**
	 * 上传头像
	 */
	@Autowired
	private TokenUtil tokenutil;
	@Autowired
	private ClientRepoImpl clientRepoImpl;
	@Autowired
	private FileRepoImpl fileRepoImpl;

	@Override
	/**
	 * 客户头像上传
	 */
	public Info uploadImage(MultipartFile file) {
		Info info = new Info();
		// 保存文件位置
		String url = "src\\main\\resources\\public\\";
		// String oid = tokenutil.tokenToOid();
		String oid = "57a1cc51bc9ee7ffc3ce6322";
		String folder = "clientimages";
		String othername = FileUtil.getOtherName(file);
		// 文件（IO）
		Integer status = FileUtil.uploadFile(file, oid, url, folder, othername);
		// 判断状态
		if (status == 1) {
			// 对客户数据库进行持久化
			ClientimageVO civo = new ClientimageVO();
			civo.setImage(folder + "\\" + othername);
			Integer in = clientRepoImpl.saveClientImage(civo);
			if (in == 1) {
				info.setStatus("上传成功");
			} else {
				info.setStatus("上传失败");
			}
		} else if (status == 0) {
			info.setStatus("上传失败");
		}
		return info;
	}
}
