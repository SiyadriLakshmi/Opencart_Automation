package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends Basepage {
	
	//constructor call
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//Locators
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_Firstname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_Lastname;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_Email;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement Phone_number;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Password;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement Confirm_password;
	@FindBy(xpath="//input[@value='0']")
	WebElement Clicksubscribe;
	@FindBy(xpath="//input[@name='agree']")
	WebElement chktermsandconditions;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement Click_continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement checkmsg;
	
	//Action methods
	public void setFirstName(String fname)
	{
		txt_Firstname.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		txt_Lastname.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		txt_Email.sendKeys(email);
	}
	public void setPhonenum(String phno)
	{
		Phone_number.sendKeys(phno);
	}
	public void setPassword(String pwd)
	{
		Password.sendKeys(pwd);
	}
	public void setConfirmPassword(String cpwd)
	{
		Confirm_password.sendKeys(cpwd);
	}
	public void ClickNosubscribe()
	{
		Clicksubscribe.click();
	}
	public void chktermsandconditions()
	{
		chktermsandconditions.click();
	}
	public void Click_continue()
	{
		Click_continue.click();
	}
	
	public  String chk_reg_confirm_msg()
	{
		try {
			return (checkmsg.getText());
		}catch (Exception e)
		{
			return e.getMessage();
		}
	}
	
	}
