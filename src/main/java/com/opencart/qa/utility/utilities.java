package com.opencart.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utilities {

	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_WAIT_TIME=5;
	
public static String generatetimestamp() {
		
		Date date=new Date();
		return date.toString().replace(" ","_").replace(":","_");
	}
	
	public static String generaterandomemail() {
		
		String random=RandomStringUtils.randomAlphabetic(7); //need dependency package
		return random+"@gmail.com";
		
	}
	public static String generateint() {
		Random random=new Random();
		Integer numb= random.nextInt(100000);
		return numb.toString();
	}
	public static String generateralpha() {
		
		String random=RandomStringUtils.randomAlphabetic(5); //need dependency package
		return random;
		
	}
	
	public static Object[][] exceltestdata(String sheetname) throws IOException  {
	
		File  file= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\opencart\\qa\\testdata\\opencartdatadriven.xlsx");
		FileInputStream exfile= new FileInputStream (file);
		XSSFWorkbook workbook= new XSSFWorkbook(exfile);
		XSSFSheet sheet =workbook.getSheet("Login");
		
		int rowcount = sheet.getLastRowNum();
		int columncount=sheet.getRow(0).getLastCellNum();
		
		Object [][] data= new Object[rowcount][columncount];
		
		for (int i=0;i<rowcount;i++)
		{
			XSSFRow currentrow=sheet.getRow(i+1);
			for (int j=0;j<columncount;j++)
			{
				XSSFCell cell=currentrow.getCell(j);
				CellType	celltype= cell.getCellType();
				
				switch(celltype) {
				
				case STRING:
					data[i][j]=cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j]=Integer.toString((int)cell.getNumericCellValue());
					break;
					
				case BOOLEAN:
					data[i][j]=cell.getBooleanCellValue();
					break;
					
				
				}
				
			}
		}
		return data;
	}
	
	
	public static String captureScrenshot(WebDriver driver,String testname) {
	File sourcescreen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String DestinationScreen=System.getProperty("user.dir")+"\\Screenshot\\"+testname+".png";
		
		try {
			FileHandler.copy(sourcescreen, new File(DestinationScreen));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return DestinationScreen;
	}
	
}
