package com.vtiger.genericlib;

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

public class Generic1 {
	public String getdata(String Sheet,int rowno,int colno ) throws EncryptedDocumentException, InvalidFormatException, IOException{
		String Filepath="E:\\programs\\workspace\\SeleniumProject\\Ashwini\\Project\\testdata\\TestData.xlsx";
		FileInputStream fis= new FileInputStream(Filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(Sheet);
		Row row=sh.getRow(rowno);
	   String data=row.getCell(colno).getStringCellValue();
		
		
		
		
		
		return data;
		
	}
	public void setvalue(String Sheet,int rowno,int colno,String value) throws EncryptedDocumentException, InvalidFormatException, IOException{
		String filepath="E:\\programs\\workspace\\SeleniumProject\\Ashwini\\Project\\testdata\\TestData.xlsx";
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(Sheet);
		Row row=sh.getRow(rowno);
		Cell cel=row.createCell(colno);
		cel.setCellType(cel.CELL_TYPE_STRING);
		FileOutputStream fos=new FileOutputStream(filepath);
		cel.setCellValue(value);
		wb.write(fos);
		wb.close();
		
		
		
	}
}
