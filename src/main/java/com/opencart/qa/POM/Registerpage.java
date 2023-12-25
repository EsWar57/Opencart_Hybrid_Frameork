package com.opencart.qa.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {
	
	WebDriver driver;
	
	
	
	@FindBy(id="input-firstname")
	private WebElement firstname;
	
	@FindBy(id="input-lastname")
	private WebElement lastname;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephone;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirm;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement subscribe;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement checkbox;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;
	
	
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement alreadyregmsg;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement privacymsg;
	
	@FindBy(xpath="//input[@name='firstname']/following-sibling::div")
	WebElement firstmsg;
	
	@FindBy(xpath="//input[@name='lastname']/following-sibling::div")
	WebElement lastmsg;
	
	@FindBy(xpath="//input[@name='email']/following-sibling::div")
	WebElement emailymsg;
	
	@FindBy(xpath="//input[@name='telephone']/following-sibling::div")
	WebElement telemsg;
	
	@FindBy(xpath="//input[@name='password']/following-sibling::div")
	WebElement passmsg;
	
	
	public Registerpage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void firstnameinput(String fname) 
	{
		 firstname.sendKeys(fname);
	}
	
	public void lastnameinput(String lname) 
	{
		 lastname.sendKeys(lname);
	}
	
	public void emailinput(String emailname) 
	{
		email.sendKeys(emailname);
	}
	
	public void teleinput(String tele) 
	{
		 telephone.sendKeys(tele);
	}
	
	public void passinput(String passw) 
	{
		 password.sendKeys(passw);
	}
	
	public void confinput(String confi) 
	{
		 confirm.sendKeys(confi);
	}
	
	public void subscriberadio() 
	{
		 subscribe.click();
	}
	
	public void privacycheckbox() 
	{
		 checkbox.click();
	}
	
	public Accountsuccesspage submitbutton() 
	{
		submit.click();
		return new Accountsuccesspage(driver);
	}
	
	
	
	public String AlreadyregWarnMSG() {
		String warning= alreadyregmsg.getText();
		return warning;
	}
	
	public String PrivacyWarnMsg() {
		String warning= privacymsg.getText();
		return warning;
	}
	
	public String FirstWarnMsg() {
		String warning= firstmsg.getText();
		return warning;
	}
	
	public String LastWarnMsg() {
		String warning= lastmsg.getText();
		return warning;
	}
	
	public String EmailWarnMsg() {
		String warning= emailymsg.getText();
		return warning;
	}
	
	public String TeleWarnMsg() {
		String warning= telemsg.getText();
		return warning;
	}
	
	public String PassWarnMsg() {
		String warning= passmsg.getText();
		return warning;
	}

	
	public Accountsuccesspage registeraccount(String fname,String lname,String emailname,String tele,String passw,String confi) {
		
		 firstname.sendKeys(fname);
		 lastname.sendKeys(lname);
		 email.sendKeys(emailname);
		 telephone.sendKeys(tele);
		 password.sendKeys(passw);
		 confirm.sendKeys(confi);
		// subscribe.click();
		 checkbox.click();
		 submit.click();
		return new Accountsuccesspage(driver);
	}
	public Accountsuccesspage registeraccountallfield(String fname,String lname,String emailname,String tele,String passw,String confi) {
		
		 firstname.sendKeys(fname);
		 lastname.sendKeys(lname);
		 email.sendKeys(emailname);
		 telephone.sendKeys(tele);
		 password.sendKeys(passw);
		 confirm.sendKeys(confi);
		subscribe.click();
		 checkbox.click();
		 submit.click();
		return new Accountsuccesspage(driver);
	}
}
