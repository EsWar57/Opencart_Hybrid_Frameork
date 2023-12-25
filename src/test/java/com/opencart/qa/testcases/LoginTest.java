package com.opencart.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.qa.POM.Accountpage;
import com.opencart.qa.POM.Homepage;
import com.opencart.qa.POM.Loginpage;
import com.opencart.qa.baseclass.Base;
import com.opencart.qa.utility.utilities;

public class LoginTest extends Base {
	
	public WebDriver driver;
	Loginpage login;
	Accountpage account;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		driver= browserurl(prop.getProperty("browser"));
		Homepage homepage= new Homepage(driver);
	/*	homepage.clickonAccount();
		login=homepage.selectLogin();
		*/
		login=homepage.navigatetologin();
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

	
	@Test(priority=1,dataProvider="exceldata")
	public void verifylogin(String email, String password) {
		
		
	/*	login.emailinput(email);
		login.passinput(password);
		account= login.loginclick();
	*/ account=login.login(email, password);	
		
		
	/*	WebElement input=driver.findElement(By.id("input-email"));
		input.clear();
//		input.sendKeys(prop.getProperty("user"));
		input.sendKeys(email);
		WebElement pass=driver.findElement(By.id("input-password"));
		pass.clear();
//		pass.sendKeys(prop.getProperty("pass"));
		pass.sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	*/	
		Assert.assertTrue(account.Accountdetails());
		
	}
	
	@DataProvider(name="exceldata")
	public Object[][] supply() throws IOException {
		Object[][] data = utilities.exceltestdata("Login");
		
		return data;
	}
	
	@Test(priority=2)
	public void verifyloginwithinvalid() throws InterruptedException {
		
		
		
		/*login.emailinput( utilities.generaterandomemail());
		login.passinput(dataprop.getProperty("invalidpass"));
		login.loginclick();
	*/
		login.login(utilities.generaterandomemail(), dataprop.getProperty("invalidpass"));	
		
	/*	WebElement input=driver.findElement(By.id("input-email"));
		input.clear();
		input.sendKeys( utilities.generaterandomemail());
		WebElement pass=driver.findElement(By.id("input-password"));
		pass.clear();
		pass.sendKeys(dataprop.getProperty("invalidpass"));
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	*/	
		String actual= login.Invalidemailpasswarning();
		String expected="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actual.contains(expected),"Excepted not found");
		
}
	@Test(priority=3)
	public void verifyloginwithinvalidemaiandvalidpass() throws Exception {
		
		
		
	/*	login.emailinput( utilities.generaterandomemail());
		login.passinput(prop.getProperty("pass"));
		login.loginclick();
	*/	
		login.login( utilities.generaterandomemail(), prop.getProperty("pass"));	
		
	/*	WebElement input=driver.findElement(By.id("input-email"));
		input.clear();
		input.sendKeys( utilities.generaterandomemail());
		WebElement pass=driver.findElement(By.id("input-password"));
		pass.clear();
		pass.sendKeys("Pass@54321");
		*/driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		

		String actual=login.Invalidemailpasswarning();
		String expected="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actual.contains(expected),"Excepted not found");
	
		
	}
	@Test(priority=4)
	public void verifylofinwithvalidemaiandinvalidpass() throws Exception {
		
		
		
		/*login.emailinput( prop.getProperty("user"));
		login.passinput(dataprop.getProperty("invalidpass"));
		login.loginclick();
		*/
		login.login( prop.getProperty("user"), dataprop.getProperty("invalidpass"));	
		
		
	/*	WebElement input=driver.findElement(By.id("input-email"));
		input.clear();
		input.sendKeys(prop.getProperty("user"));
		WebElement pass=driver.findElement(By.id("input-password"));
		pass.clear();
		pass.sendKeys(dataprop.getProperty("invalidpass"));
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		*/

		String actual=login.Invalidemailpasswarning();
		String expected="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actual.contains(expected),"Excepted not found");
	
		
	}
	
	@Test(priority=5)
	public void verifylofinwithoutcredentials() throws Exception {
		
		
		
		
		
		login.loginclick();
		
		
	/*	WebElement input=driver.findElement(By.id("input-email"));
		input.clear();
		input.sendKeys("");
		WebElement pass=driver.findElement(By.id("input-password"));
		pass.clear();
		pass.sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	
	*/
		String actual=login.Invalidemailpasswarning();
		String expected="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actual.contains(expected),"Excepted not found");
	
	
	
	}
	
}