package cc.zhanyun.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

public class RandomUtil {

	/**
	 * 生成随机文件名：当前年月日时分秒+五位随机数
	 * 
	 * @return
	 */
	public static String getRandomFileName() {

		SimpleDateFormat simpleDateFormat;

		simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		Date date = new Date();

		String str = simpleDateFormat.format(date);

		Random random = new Random();

		int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 100000;// 获取5位随机数

		return str + rannum;// 当前时间
	}

	@Test
	public void Test() {

		String fileName = RandomUtil.getRandomFileName();

		System.out.println(fileName);// 8835920140307
	}
}