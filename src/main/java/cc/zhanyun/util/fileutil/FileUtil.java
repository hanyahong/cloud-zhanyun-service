package cc.zhanyun.util.fileutil;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import cc.zhanyun.util.RandomUtil;

public class FileUtil {

	/**
	 * 上传文件
	 */
	public static Integer uploadFile(MultipartFile file, String oid,
			String url, String folder, String othername) {
		// 创建FileManager文件 用来储存信息
		if (!file.isEmpty()) {
			try {
				// 创建保存位置
				String fileSaveUrl = createUserFiles(oid, url, folder);
				// 获取字节
				byte[] bytes = file.getBytes();
				File downFile = new File(fileSaveUrl + othername);
				// 判断该路径文件是否存在
				if (!downFile.exists()) {
					downFile.createNewFile();
				}

				// 创建输出流
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(downFile));
				// 写入流
				stream.write(bytes);
				// 关闭流
				stream.close();
				// 返回信息
				return 1;
			} catch (Exception e) {
				return 0;
			}
		}
		return 2;
	}

	/**
	 * 根据路径删除指定的目录或文件，无论存在与否
	 * 
	 * @param sPath
	 *            要删除的目录或文件
	 * @return 删除成功返回 true，否则返回 false。
	 */
	public boolean DeleteFolder(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 判断目录或文件是否存在
		if (!file.exists()) { // 不存在返回 false
			return flag;
		} else {
			// 判断是否为文件
			if (file.isFile()) { // 为文件时调用删除文件方法
				return deleteFile(sPath);
			} else { // 为目录时调用删除目录方法
				return deleteDirectory(sPath);
			}
		}
	}

	/**
	 * 删除目录（文件夹）以及目录下的文件
	 * 
	 * @param sPath
	 *            被删除目录的文件路径
	 * @return 目录删除成功返回true，否则返回false
	 */
	public boolean deleteDirectory(String sPath) {
		// 如果sPath不以文件分隔符结尾，自动添加文件分隔符
		if (!sPath.endsWith(File.separator)) {
			sPath = sPath + File.separator;
		}
		File dirFile = new File(sPath);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			return false;
		}
		boolean flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			} // 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag)
			return false;
		// 删除当前目录
		if (dirFile.delete()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 删除单个文件
	 * 
	 * @param sPath
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public boolean deleteFile(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

	/**
	 * 时间格式化工具类
	 * 
	 * @return
	 */
	public static String getFormatDate() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.format(date);
		String dateAndTime = format.format(date);
		return dateAndTime;
	}

	/**
	 * 生成随机别名+类型
	 * 
	 * @return
	 */
	public static String getOtherName(MultipartFile file) {
		// format.format(date);
		// 获取文件原名称
		String fileName = file.getOriginalFilename();
		// 获取后缀
		String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
		// 获取随机名称
		String random = RandomUtil.getRandomFileName();
		// 获得随机名称+文件类型
		String othername = random + "." + prefix;
		return othername;
	}

	/**
	 * 检测并创建文件夹 返回文件夹连接
	 * 
	 * @param oid
	 *            用户id
	 * @param url
	 *            原始路径
	 * @param folder
	 *            文件名
	 * @return 返回文件夹连接
	 */
	public static String createUserFiles(String oid, String url, String folder) {

		String useroid = oid + "\\";
		String filesurl = folder + "\\";
		File file = new File(url + useroid);
		// 判断路径是否存在
		if (!file.exists() && !file.isDirectory()) {
			file.mkdir();
		}
		File file2 = new File(url + useroid + filesurl);
		if (!file2.exists() && !file2.isDirectory()) {
			file2.mkdir();
		}
		return url + useroid + filesurl;
	}

	/**
	 * 验证是否为合法xls文件
	 * 
	 * @param file
	 * @return 0 格式不正确 ，1正确
	 */
	public static Integer verifyFileType(MultipartFile file) {
		// 获取文件原名称
		String fileName = file.getOriginalFilename();
		// 获取后缀
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		if (suffix.equals("xls") || suffix.equals("xlsx")) {
			return 1;
		} else {
			return 0;
		}

	}

}
