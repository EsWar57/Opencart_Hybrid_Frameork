package com.opencart.qa.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchpage {

	
	WebDriver driver;
	
	@FindBy(linkText="HP LP3065")
	private WebElement validhpproduct;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement noproduct;
	
	
	public Searchpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean Validproduct() {
		
		boolean status=validhpproduct.isDisplayed();
		return status;
	}
	
	public String NoproductMsg() {
		String msg=noproduct.getText();
		return msg;
	}
	
}
