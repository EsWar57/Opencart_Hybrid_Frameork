package com.opencart.qa.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
	private WebElement MyAccount;
	
	
	@FindBy(linkText="Login")
	private WebElement loginoption;
	
	@FindBy(linkText="Register")
	private WebElement Registeroption;
	
	@FindBy(name="search")
	private WebElement searchinput;
	
	@FindBy(xpath="//button[@Class='btn btn-default btn-lg']")
	private WebElement searchbutton;
	
	
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonAccount(){
		
		MyAccount.click();
	}
	
	public Loginpage selectLogin() {
		
		loginoption.click();
		return new Loginpage(driver);
	}
	//or
	
	public Loginpage navigatetologin() {
		
		MyAccount.click();
		loginoption.click();
		return new Loginpage(driver);
	}
	
	public Registerpage selectregister() {
		
		Registeroption.click();
		return new Registerpage(driver);
	}
	
	public void Searchinput(String name) {
		
		searchinput.sendKeys(name);
	}
	
	public Searchpage Searchclick()
	{
		searchbutton.click();
		return new Searchpage(driver);
	}
	
	public Registerpage naviagetoregisterpage() {
		
		MyAccount.click();
		Registeroption.click();
		return new Registerpage(driver);
	}
	
}
