package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Addtocartpage extends Basepage{
    //add constructor
	public Addtocartpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//add locators
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement Quantity;
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement addtocart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successmsg;
	
	//Action method
	public void add_QuatityOfproduct(String num)
	{
		Quantity.clear();
		Quantity.sendKeys(num);
	}
	
	public void addProductToCart()
	{
		addtocart.click();
	}
	
	public  boolean chk_addtocart_confirm_msg()
	{
		return successmsg.isDisplayed();
	}


}
