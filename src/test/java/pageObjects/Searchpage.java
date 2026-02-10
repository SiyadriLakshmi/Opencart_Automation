package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Searchpage extends Basepage {
	//declare constructor
	public Searchpage(WebDriver driver)
	{
		super(driver);
	}
	
	//declare locators
	@FindBy(xpath="//a[normalize-space()='Search']")
	WebElement searchpagetitle;
	
	@FindBy(xpath="//img[@title='iMac']")
	WebElement productimg;
	
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/h4[1]/a[1]")
	WebElement pname;
	
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/p[2]")
	WebElement pprice;
	
	@FindBy(xpath="//h4/a")
	List<WebElement> productlist; 
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	WebElement checkmsgfornotavailableproducts;
	
	public void Click_on_Pdoduct()
	{
		productimg.click();
	}
	public WebElement Pdoductimg()
	{
		return productimg;
	}
	public String pprice()
	{
		return pprice.getText();
	}
	public String pname()
	{
		return pname.getText();
	}
	public List<WebElement> productlist()
	{
		return productlist;
	}
	public String chk_searchpage()
	{
		try
		{
			return searchpagetitle.getText();
		}catch(Exception e)
		{ return e.getMessage();}
	}
	public boolean checkmsgfornotavailableproducts()
	{
		return checkmsgfornotavailableproducts.isDisplayed();
	}
	

}
