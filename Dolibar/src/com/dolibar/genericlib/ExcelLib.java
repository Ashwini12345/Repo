package com.dolibar.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
	String filepath="E:\\programs\\workspace\\SeleniumProject\\Ashwini\\Project\\testdata\\TestData.xlsx";
public String getExcelData(String sheetName,int rowNum,int colNum) throws EncryptedDocumentException, InvalidFormatException, IOException{
	FileInputStream fis=new FileInputStream(filepath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	Row row=sh.getRow(rowNum);
	String data=row.getCell(colNum).getStringCellValue();
	return data;
	}

public void setExcelData(String sheetName,int rowNum,int colNum,String data) throws EncryptedDocumentException, InvalidFormatException, IOException{
	FileInputStream fis=new FileInputStream(filepath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	Row row=sh.getRow(rowNum);
	Cell cell=row.createCell(colNum);
	cell.setCellType(cell.CELL_TYPE_STRING);
	FileOutputStream fos=new FileOutputStream(filepath);
	cell.setCellValue(data);
	wb.write(fos);
	wb.close();
}
	
	
}

