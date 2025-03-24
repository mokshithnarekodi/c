package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetname,int rowNum, int cellNum) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("./testdata/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	public int getRowCount(String sheetname) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("./testdata/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		return rowcount;
	}
	
	public void setDataIntoExcel(String sheetname, int rowNum, int cellNum,String data) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("./testdata/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell cel = wb.getSheet(sheetname).getRow(rowNum).createCell(cellNum);
		cel.setCellType(CellType.STRING);
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./testdata/testscriptdata.xlsx");
		wb.write(fos);
		wb.close();
	}
}
