package cc.zhanyun.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	/**
	 * 修改zhi
	 * 
	 * @throws IOException
	 */
	public static void updatePro() throws IOException {
		Properties pro = new Properties();
		String file = "src/main/resources/application.properties";
		InputStream in = null;
		in = new BufferedInputStream(new FileInputStream(file));
		pro.load(in);
		// 重新写入配置文件
		FileOutputStream file2 = new FileOutputStream(file);
		pro.put("spring.data.mongodb.uri", "mongodb://localhost/18888888");
		System.out.println("得到属性key:"
				+ pro.getProperty("spring.data.mongodb.uri"));
		pro.store(file2, "系统配置修改"); // 这句话表示重新写入配置文件
	}
}
