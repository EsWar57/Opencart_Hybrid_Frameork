package com.opencart.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generatereport() {
		
		ExtentReports extentreport= new ExtentReports();
		File reportfile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreports.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportfile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Opencart Test Result");
		sparkReporter.config().setDocumentTitle("Opencart Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentreport.attachReporter(sparkReporter);
		
		Properties prop=new Properties();
		File file= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\opencart\\qa\\config\\config.properties");
		FileInputStream config;
		try {
			config = new FileInputStream(file);
			prop.load(config);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
			
		extentreport.setSystemInfo("Application url",prop.getProperty("url"));
		extentreport.setSystemInfo("Browser name", prop.getProperty("browser"));
		extentreport.setSystemInfo("Email", prop.getProperty("user"));
		extentreport.setSystemInfo("Password", prop.getProperty("pass"));
		extentreport.setSystemInfo("Os Name",System.getProperty("os.name"));
		extentreport.setSystemInfo("UserName",System.getProperty("user.name"));
		extentreport.setSystemInfo("java Version ",System.getProperty("java.version") );
		
		return extentreport;
	}

}
