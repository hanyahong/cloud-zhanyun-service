package cc.zhanyun.util.myutil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Util {

 /**
  * @param args
  * @throws IOException
  * @throws FileNotFoundException
  */

 @SuppressWarnings("deprecation")
 public static void main(String[] args) {
  try {
   POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
     "exlsample.xls"));
   HSSFWorkbook wb = new HSSFWorkbook(fs);

//source ,target 为,源sheet 页和目标sheet页,
   copyRows(wb, "source", "target", 3, 4, 20);
   FileOutputStream fileOut = new FileOutputStream("exlsample.xls");
   wb.write(fileOut);
   fileOut.flush();
   fileOut.close();
   System.out.println("Operation finished......");
  } catch (Exception e) {
   e.printStackTrace();
  }
 }

 public static void copyRows(HSSFWorkbook wb, String pSourceSheetName,
   String pTargetSheetName, int pStartRow, int pEndRow, int pPosition) {
  HSSFRow sourceRow = null;
  HSSFRow targetRow = null;
  HSSFCell sourceCell = null;
  HSSFCell targetCell = null;
  HSSFSheet sourceSheet = null;
  HSSFSheet targetSheet = null;
  Region region = null;
  int cType;
  int i;
  short j;
  int targetRowFrom;
  int targetRowTo;

  if ((pStartRow == -1) || (pEndRow == -1)) {
   return;
  }
  sourceSheet = wb.getSheet(pSourceSheetName);
  targetSheet = wb.getSheet(pTargetSheetName);
  // 拷贝合并的单元格
  for (i = 0; i < sourceSheet.getNumMergedRegions(); i++) {
   region = sourceSheet.getMergedRegionAt(i);
   if ((region.getRowFrom() >= pStartRow)
     && (region.getRowTo() <= pEndRow)) {
    targetRowFrom = region.getRowFrom() - pStartRow + pPosition;
    targetRowTo = region.getRowTo() - pStartRow + pPosition;
    region.setRowFrom(targetRowFrom);
    region.setRowTo(targetRowTo);
    targetSheet.addMergedRegion(region);
   }
  }
  // 设置列宽
  for (i = pStartRow; i <= pEndRow; i++) {
   sourceRow = sourceSheet.getRow(i);
   if (sourceRow != null) {
    for (j = sourceRow.getLastCellNum(); j > sourceRow
      .getFirstCellNum(); j--) {
     targetSheet
       .setColumnWidth(j, sourceSheet.getColumnWidth(j));
     targetSheet.setColumnHidden(j, false);
    }
    break;
   }
  }
  // 拷贝行并填充数据
  for (; i <= pEndRow; i++) {
   sourceRow = sourceSheet.getRow(i);
   if (sourceRow == null) {
    continue;
   }
   targetRow = targetSheet.createRow(i - pStartRow + pPosition);
   targetRow.setHeight(sourceRow.getHeight());
   for (j = sourceRow.getFirstCellNum(); j < sourceRow
     .getPhysicalNumberOfCells(); j++) {
    sourceCell = sourceRow.getCell(j);
    if (sourceCell == null) {
     continue;
    }
    targetCell = targetRow.createCell(j);
   // targetCell.setEncoding(sourceCell.getEncoding());
    targetCell.setCellStyle(sourceCell.getCellStyle());
    cType = sourceCell.getCellType();
    targetCell.setCellType(cType);
    switch (cType) {
    case HSSFCell.CELL_TYPE_BOOLEAN:
     targetCell.setCellValue(sourceCell.getBooleanCellValue());
     System.out.println("--------TYPE_BOOLEAN:"
       + targetCell.getBooleanCellValue());
     break;
    case HSSFCell.CELL_TYPE_ERROR:
     targetCell
       .setCellErrorValue(sourceCell.getErrorCellValue());
     System.out.println("--------TYPE_ERROR:"
       + targetCell.getErrorCellValue());
     break;
    case HSSFCell.CELL_TYPE_FORMULA:
     // parseFormula这个函数的用途在后面说明
     targetCell.setCellFormula(parseFormula(sourceCell
       .getCellFormula()));
     System.out.println("--------TYPE_FORMULA:"
       + targetCell.getCellFormula());
     break;
    case HSSFCell.CELL_TYPE_NUMERIC:
     targetCell.setCellValue(sourceCell.getNumericCellValue());
     System.out.println("--------TYPE_NUMERIC:"
       + targetCell.getNumericCellValue());
     break;
    case HSSFCell.CELL_TYPE_STRING:
     targetCell
       .setCellValue(sourceCell.getRichStringCellValue());
     System.out.println("--------TYPE_STRING:" + i
       + targetCell.getRichStringCellValue());
     break;
    }

   }

  }

 }

 private static String parseFormula(String pPOIFormula) {
  final String cstReplaceString = "ATTR(semiVolatile)"; //$NON-NLS-1$
  StringBuffer result = null;
  int index;

  result = new StringBuffer();
  index = pPOIFormula.indexOf(cstReplaceString);
  if (index >= 0) {
   result.append(pPOIFormula.substring(0, index));
   result.append(pPOIFormula.substring(index
     + cstReplaceString.length()));
  } else {
   result.append(pPOIFormula);
  }

  return result.toString();
 }

}