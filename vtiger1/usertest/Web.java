package com.vtiger.usertest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xpath.axes.WalkerFactory;
import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Web {

	//private static final int Integer = 0;

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
	FileInputStream fis=new FileInputStream("C:\\Users\\ash\\Desktop\\A.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		Row row=sh.getRow(1);
		String username=row.getCell(1).getStringCellValue();
		String Password=row.getCell(2).getStringCellValue();
		String CustomName=row.getCell(3).getStringCellValue();
        long MobNo=(long)(row.getCell(4).getNumericCellValue());
        String M=Long.toString(MobNo);
        
		System.out.println(username);
		System.out.println(Password);
		System.out.println(CustomName);
		System.out.println(M);

	}

}
