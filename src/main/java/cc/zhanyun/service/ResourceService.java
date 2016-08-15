package cc.zhanyun.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cc.zhanyun.model.Info;
import cc.zhanyun.model.resources.ResourceStatusVO;
import cc.zhanyun.model.resources.Resources;

@Service
public interface ResourceService {
	/**
	 * 增加资源
	 */
	public ResourceStatusVO addResource(Resources resources);

	/**
	 * 修改资源
	 */
	public Info updateResource(Resources resources);

	/**
	 * 查询资源列表
	 */
	public List<Resources> selResourceList();

	/**
	 * 删除资源
	 */
	public Info delResourceOne(String oid);

	/**
	 * 查询单条资源
	 */
	public Resources selResourceOne(String oid);

	/**
	 * 增加资源图片
	 */
	public Info addResourceImage(MultipartFile file, String oid);

	/**
	 * 以 设备分类查找
	 */
	public List<Resources> selResourceOneByType(String type);
}
