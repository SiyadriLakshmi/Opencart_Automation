package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewProductpage extends Basepage{
	
	public ViewProductpage(WebDriver driver)
	{
		super(driver);
	}
	//Locators
	@FindBy(xpath="//div[@class='col-sm-4']/h1[1]")
	WebElement productname;
	@FindBy(xpath="//div[@class='col-sm-4']//ul[1]")
	WebElement pdiscription;
	@FindBy(xpath="//div[@class='col-sm-4']//ul[2]/li[1]")
	WebElement pprice;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement Quantity;
	
	//Action methods
	public void Pquantity(String num) {
		Quantity.clear();
		Quantity.sendKeys(num);
	}
	
	public String getProductName() {
	    return productname.getText();
	}
	public boolean pdiscription()
	{
		return pdiscription.isDisplayed();
	}
	public boolean pprice()
	{
		return pprice.isDisplayed();
	}
	public boolean pname() {
		// TODO Auto-generated method stub
		return productname.isDisplayed();
	}
	
	


}
