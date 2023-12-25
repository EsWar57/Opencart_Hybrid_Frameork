package com.opencart.qa.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	WebDriver driver;
	
	@FindBy(id="input-email")
	private WebElement emailbox;
	
	
	@FindBy(id="input-password")
	private WebElement passwordbox;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	private WebElement loginbutton;
	
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningmsg;
	
	
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void emailinput(String emailtxt) {
		
		emailbox.sendKeys(emailtxt);
		
	}
	
	public void passinput(String passtxt) {
		
		passwordbox.sendKeys(passtxt);
		
	}
	
	public Accountpage loginclick() {
		
		loginbutton.click();
		return new Accountpage(driver);
		
	}
	//or 
	public Accountpage login(String emailtxt,String passtxt) {
		
		emailbox.sendKeys(emailtxt);
		passwordbox.sendKeys(passtxt);
		loginbutton.click();
		return new Accountpage(driver);
		
	}
	
	public String Invalidemailpasswarning(){
		String msg=warningmsg.getText();
		return msg;
	}
	
}
