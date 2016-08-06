package cc.zhanyun.util.myutil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class Test2 {
	@Test
	public void teste() {
		readXml("E:/test1.xls");
		System.out.println("-------------");
		// readXml("E:/test56565.xls");
	}

	public static void readXml(String fileName) {
		boolean isE2007 = false; // 判断是否是excel2007格式
		if (fileName.endsWith("xlsx"))
			isE2007 = true;
		try {
			InputStream input = new FileInputStream(fileName); // 建立输入流
			Workbook wb = null;
			// 根据文件格式(2003或者2007)来初始化
			if (isE2007)
				wb = new XSSFWorkbook(input);
			else
				wb = new HSSFWorkbook(input);
			Sheet sheet = wb.getSheetAt(0); // 获得第一个表单
			Iterator<Row> rows = sheet.rowIterator(); // 获得第一个表单的迭代器
			while (rows.hasNext()) {
				Row row = rows.next(); // 获得行数据
				System.out.print("Row #" + row.getRowNum()); // 获得行号从0开始
				Iterator<Cell> cells = row.cellIterator(); // 获得第一行的迭代器
				while (cells.hasNext()) {
					StringBuffer buffer=null; 
					Cell cell = cells.next();
					// System.out.print("Cell #" + cell.getColumnIndex());
					buffer.append(cell.getColumnIndex());
					switch (cell.getCellType()) { // 根据cell中的类型来输出数据
					case HSSFCell.CELL_TYPE_NUMERIC:
						// System.out.print(cell.getNumericCellValue());
						buffer.append(cell.getNumericCellValue());
						break;
					case HSSFCell.CELL_TYPE_STRING:
						// System.out.print(cell.getStringCellValue());
						buffer.append(cell.getStringCellValue());
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN:
						// System.out.print(cell.getBooleanCellValue());
						buffer.append(cell.getBooleanCellValue());
						break;
					case HSSFCell.CELL_TYPE_FORMULA:
						// System.out.print(cell.getCellFormula());
						buffer.append(cell.getCellFormula());
						break;
					default:
						System.out.print("unsuported sell type");
						break;
					}
					System.out.println(buffer);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}