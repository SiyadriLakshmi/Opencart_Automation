package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Basepage {
	//Constructor
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	//Locators
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement Myaccount;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")//added step6
	WebElement linkLogout;
	
	//Action methods
	public boolean Myaccountmsg()
	{
		try {
		return(Myaccount.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void Clicklogout()//added step6
	{
		linkLogout.click();
	}

}
