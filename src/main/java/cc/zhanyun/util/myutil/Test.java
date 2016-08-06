package cc.zhanyun.util.myutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Test {
	@org.junit.Test
	public void TestPoi() {
		// excel模板路径
		File fi = new File("E:\\test.xls");

		try {
			// 转换
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fi));
			// 读取excel模板
			HSSFWorkbook workbook = new HSSFWorkbook(fs);
			// 读取了模板内所有sheet内容
			HSSFSheet sheet = workbook.getSheetAt(0);
			// 创建list 储存属性值
			List<Status> slist = new ArrayList<Status>();
			// 遍历sheet
			for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {
				// Status status = new Status();
				HSSFRow row = sheet.getRow(j);
				// 储存单元格列数
				for (int k = 0; k < row.getLastCellNum(); k++) {
					// 储存单元格行数
					String value = row.getCell(k).getStringCellValue().trim();
					// System.out.println("我需要的值是：" + value + "在第" + j + "行，"
					// + "第" + k + "列");
					Status status = new Status();
					status.setCell(k);
					status.setRow(j);
					status.setValue(value);
					// 添加元素
					slist.add(status);
				}

			}
			for (Status s : slist) {
				// System.out.println("=========数据=======：" + s.getRow() + "---"
				// + s.getValue() + "---" + s.getCell());
				if (s.getValue().equals("${project.offer.name}")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue("韩亚宏");
				} else if (s.getValue().equals("${project.offer.address}")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue("北京市");
				} else if (s.getValue().equals("${project.offer.address}")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue("北京市");
				}
				else if (s.getValue().equals("${project.offer.address}")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue("北京市");
				}
				else if (s.getValue().equals("${project.offer.address}")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue("北京市");
				}
				else if (s.getValue().equals("${project.offer.address}")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue("北京市");
				}
				else if (s.getValue().equals("${project.offer.address}")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue("北京市");
				}
				else if (s.getValue().equals("${project.offer.address}")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue("北京市");
				}
				else if (s.getValue().equals("${project.offer.address}")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue("北京市");
				}
				else if (s.getValue().equals("${project.offer.address}")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue("北京市");
				}
				else if (s.getValue().equals("${project.offer.address}")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue("北京市");
				}
				else if (s.getValue().equals("${project.offer.address}")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue("北京市");
				}
				else if (s.getValue().equals("${project.offer.address}")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue("北京市");
				}
				else if (s.getValue().equals("${project.offer.address}")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue("北京市");
				}
				else if (s.getValue().equals("${project.offer.address}")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue("北京市");
				}
				else if (s.getValue().equals("${project.offer.address}")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue("北京市");
				}
				else if (s.getValue().equals("${project.offer.address}")) {
					sheet.getRow(s.getRow()).getCell(s.getCell())
							.setCellValue("北京市");
				}
			}

			// 测试复制行
			PoiUtil.insertRow(sheet, 9, 5);
			PoiUtil.copyRow(workbook, sheet.getRow(14), sheet.createRow(11),
					true);
			// 修改模板内容导出新模板
			FileOutputStream out = new FileOutputStream("E:/testffffffffffff"
					+ "22222" + ".xls");
			workbook.write(out);
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}