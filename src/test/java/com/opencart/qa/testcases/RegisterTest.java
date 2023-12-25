package com.opencart.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.qa.POM.Accountpage;
import com.opencart.qa.POM.Accountsuccesspage;
import com.opencart.qa.POM.Homepage;
import com.opencart.qa.POM.Registerpage;
import com.opencart.qa.baseclass.Base;
import com.opencart.qa.utility.utilities;

public class RegisterTest extends Base {
	
	public WebDriver driver;
	Registerpage register;
	Accountpage account;
	Accountsuccesspage success;
	
	public RegisterTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		driver=browserurl(prop.getProperty("browser"));
		
		Homepage home=new Homepage(driver);
		/*home.clickonAccount();
		register=home.selectregister();
		*/
		register=home.naviagetoregisterpage();
		
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

	
	

	@Test(priority=1)
	public void verifyregisterwithmandatoryfield() throws InterruptedException {
		
		
		/*register.firstnameinput(utilities.generateralpha());
		register.lastnameinput(utilities.generateralpha());
		register.emailinput(utilities.generaterandomemail());
		register.teleinput("6897"+utilities.generateint());
		register.passinput("123456");
		register.confinput("123456");
		register.privacycheckbox();
		success=register.submitbutton();
		
		//or 
		 * 
	     driver.findElement(By.id("input-firstname")).sendKeys(utilities.generateralpha());
		driver.findElement(By.id("input-lastname")).sendKeys(utilities.generateralpha());
		driver.findElement(By.id("input-email")).sendKeys(utilities.generaterandomemail());
		driver.findElement(By.id("input-telephone")).sendKeys("6897"+utilities.generateint());
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.id("input-confirm")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();		
		*/
		success=register.registeraccount(utilities.generateralpha(), utilities.generateralpha(), utilities.generaterandomemail(), "6897"+utilities.generateint(), "123456", "123456");
	
		
		String Actual=success.Regwarningmsg();
		Assert.assertEquals(Actual, "Your Account Has Been Created!","Account wasn't created successfully");
		
		
		Thread.sleep(5);
	}
	
	@Test(priority=2)
	public void verifyregisterwithallfield() throws InterruptedException {
		
		
	
		/*	register.firstnameinput(utilities.generateralpha());
		register.lastnameinput(utilities.generateralpha());
		register.emailinput(utilities.generaterandomemail());
		register.teleinput("6897"+utilities.generateint());
		register.passinput("123456");
		register.confinput("123456");
		register.subscriberadio();
		register.privacycheckbox();
		success=register.submitbutton();
		
		driver.findElement(By.id("input-firstname")).sendKeys(utilities.generateralpha());
		driver.findElement(By.id("input-lastname")).sendKeys(utilities.generateralpha());
		driver.findElement(By.id("input-email")).sendKeys(utilities.generaterandomemail());
		driver.findElement(By.id("input-telephone")).sendKeys("6897"+utilities.generateint());
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.id("input-confirm")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();		
		*/
		
		success=register.registeraccountallfield(utilities.generateralpha(), utilities.generateralpha(), utilities.generaterandomemail(), "6897"+utilities.generateint(), "123456", "123456");
		
		
		String Actual=success.Regwarningmsg();
		
		Assert.assertEquals(Actual, "Your Account Has Been Created!","Account wasn't created successfully");
		
		
		Thread.sleep(5);
	}
	
	@Test(priority=3)
	public void verifyregisterwithsameemail() {
		
		
		
		
		/*	register.firstnameinput(utilities.generateralpha());
		register.lastnameinput(utilities.generateralpha());
		register.emailinput(prop.getProperty("user"));
		register.teleinput("6897"+utilities.generateint());
		register.passinput(prop.getProperty("pass"));
		register.confinput(prop.getProperty("pass"));
		register.subscriberadio();
		register.privacycheckbox();
		register.submitbutton();
		
		driver.findElement(By.id("input-firstname")).sendKeys(utilities.generateralpha());
		driver.findElement(By.id("input-lastname")).sendKeys(utilities.generateralpha());
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("user"));
		driver.findElement(By.id("input-telephone")).sendKeys("6897"+utilities.generateint());
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.id("input-confirm")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	*/	
		
		register.registeraccountallfield(utilities.generateralpha(), utilities.generateralpha(), prop.getProperty("user"), "6897"+utilities.generateint(), "123456", "123456");
		
		String Actualline= register.AlreadyregWarnMSG();
		Assert.assertTrue(Actualline.contains("Warning: E-Mail Address is already registered!"),"msg is not displayed");
		

	}
	
	@Test(priority=4)
	public void verifyregisterwithoutdetails() {
		
		
		
		register.submitbutton();
		
		register.PrivacyWarnMsg();
		register.FirstWarnMsg();
		register.LastWarnMsg();
		register.EmailWarnMsg();
		register.TeleWarnMsg();
		register.PassWarnMsg();
		
		/*driver.findElement(By.xpath("//input[@type='submit']")).click();	
		
		
		String actualprivacy=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertTrue(actualprivacy.contains("Warning: You must agree to the Privacy Policy!"),"privacymsg is not displayed");
		
		String actualfname=driver.findElement(By.xpath("//input[@name='firstname']/following-sibling::div")).getText();
		Assert.assertTrue(actualfname.contains("First Name must be between 1 and 32 characters!"),"firstname msg is not displayed");
		
		String actuallname=driver.findElement(By.xpath("//input[@name='lastname']/following-sibling::div")).getText();
		Assert.assertTrue(actuallname.contains("Last Name must be between 1 and 32 characters!"),"lastname msg is not displayed");
		
		String actualemail=driver.findElement(By.xpath("//input[@name='email']/following-sibling::div")).getText();
		Assert.assertTrue(actualemail.contains("E-Mail Address does not appear to be valid!"),"email msg is not displayed");
		
		String actualtelephone=driver.findElement(By.xpath("//input[@name='telephone']/following-sibling::div")).getText();
		Assert.assertTrue(actualtelephone.contains("Telephone must be between 3 and 32 characters!"),"telephone msg is not displayed");
		
		String actualpass=driver.findElement(By.xpath("//input[@name='password']/following-sibling::div")).getText();
		Assert.assertTrue(actualpass.contains("Password must be between 4 and 20 characters!"),"password msg is not displayed");
		*/

	}
}
