package com.opencart.qa.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.opencart.qa.utility.utilities;

public class Base {

	WebDriver driver;
	public Properties prop,dataprop;
	
	public Base() {
		
		prop =new Properties();
		File propfil=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\opencart\\qa\\config\\config.properties");
		
		dataprop= new Properties();
		File datapropfile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\opencart\\qa\\testdata\\testdata.properties");
		
		try {

			FileInputStream file= new FileInputStream(propfil);
			prop.load(file);
			
			FileInputStream datafile= new FileInputStream(datapropfile);
			dataprop.load(datafile);
			
		} catch (Throwable e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public WebDriver browserurl(String browsername) {
		
		
		String Browsername=browsername;
		
		if(Browsername.equalsIgnoreCase("chrome")) {
			
			driver= new ChromeDriver();
			
		}else if(Browsername.equalsIgnoreCase("firefox")) {
			
			driver= new FirefoxDriver();
			
		}else if(Browsername.equalsIgnoreCase("Edge")) {
			driver= new EdgeDriver();
			
		}
			
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utilities.PAGE_WAIT_TIME));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
}
