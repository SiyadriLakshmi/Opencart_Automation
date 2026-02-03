package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage{
	//Constructor
	public Loginpage(WebDriver driver)
	{
		super(driver);
	}
	//Locators
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_Email;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_pwd;
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_clicklogin;
	//Action methods
	public void setEmail(String email) {
		txt_Email.sendKeys(email);
	}
	public void setpassword(String pwd) {
		txt_pwd.sendKeys(pwd);
	}
	public void ClickLogininloginpage() {
		btn_clicklogin.click();
	}
	
	
	

}
