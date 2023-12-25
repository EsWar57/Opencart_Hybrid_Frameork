package com.opencart.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.qa.POM.Homepage;
import com.opencart.qa.POM.Searchpage;
import com.opencart.qa.baseclass.Base;

public class SearchTest extends Base{
	
	public WebDriver driver;
	Searchpage search;
	
	public SearchTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		
		driver =browserurl(prop.getProperty("browser"));
		
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifysearchwithvalidproduct() {
		
		Homepage home= new Homepage(driver);
		
		home.Searchinput(dataprop.getProperty("validdata"));
		 search=home.Searchclick();
		
	/*	driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("validdata"));
		driver.findElement(By.xpath("//button[@Class='btn btn-default btn-lg']")).click();
	*/
	
		
		Assert.assertTrue(search.Validproduct(),"searched product is not displayed");
			
	}
	
	@Test(priority=2)
	public void verifysearchwithINvalidproduct() {
		
		Homepage home= new Homepage(driver);
		home.Searchinput(dataprop.getProperty("invaliddata"));
		search=home.Searchclick();
	/*	driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("invaliddata"));
		driver.findElement(By.xpath("//button[@Class='btn btn-default btn-lg']")).click();
		*/
	
		String actual=search.NoproductMsg();
		Assert.assertEquals(actual,"There is no product that matches the search criteria.","searched product is not displayed");
			
	}
	
	@Test(priority=3)
	public void verifysearchwithoutanyproduct() {
		Homepage home= new Homepage(driver);
		search=home.Searchclick(); // check  6.16
		
		/*driver.findElement(By.xpath("//button[@Class='btn btn-default btn-lg']")).click();
	*/
		String actual=search.NoproductMsg();
		Assert.assertEquals(actual,"There is no product that matches the search criteria.","searched product is not displayed");
		
	}
	
	

}
