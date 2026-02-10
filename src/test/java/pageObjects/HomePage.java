package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Basepage{
	
	//constructor call
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	//Locators
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement Click_Account;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement Click_Registraion;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement btn_login;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement txt_search;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement search;
	
	@FindBy(xpath="//span[normalize-space()='Shopping Cart']")
	WebElement shopingcart;
	
	//Action methods
	public void myAccount_click()
	{
		Click_Account.click();
	}
	public void Registration_click()
	{
		Click_Registraion.click();
	}
	public void ClickLogin()
	{
		btn_login.click();
	}
	public void txt_search(String value)
	{
		txt_search.sendKeys(value);
		
	}
	public void clearSearchBox() {
		txt_search.clear();
	}

	public void search_click()
	{
		
		search.click();
		
		}
	public void Click_shopingcart()
	{
		shopingcart.click();
	}

}
