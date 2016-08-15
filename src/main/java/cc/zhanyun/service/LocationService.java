package cc.zhanyun.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cc.zhanyun.model.Info;
import cc.zhanyun.model.location.Location;
import cc.zhanyun.model.vo.LocationImageOidVO;
import cc.zhanyun.model.vo.LocationVO;

@Service
public interface LocationService {
	/**
	 * 新建场地
	 */
	public LocationImageOidVO addLocation(Location location);
	/**
	 * 修改场地
	 */
	public LocationImageOidVO updateLocation(Location location);


	/**
	 * 查询场地
	 */
	public Location selLocationInfo(String oid);

	/**
	 * 删除场地
	 */
	public Info delLocationInfo(String oid);

	/**
	 * 场地列表
	 */
	public List<LocationVO> selLocationList();

	/**
	 * 新增场地图片
	 */
	public Info addLocationImage(String oid, MultipartFile file);

	/**
	 * 新增场地会议室图片
	 */
	public Info addLocationRoomImage(String oid, String hourseOid,MultipartFile file);
	/**
	 * 新增场地会议室案例图片
	 */
	public Info addLocationRoomCaseImage(String oid, String hourseOid,MultipartFile file);
}
