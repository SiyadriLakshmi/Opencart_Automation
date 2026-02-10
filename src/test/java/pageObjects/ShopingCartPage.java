package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopingCartPage extends Basepage {
	public ShopingCartPage(WebDriver driver)
	{
		super(driver);
	}
	// Specifically looks in the tbody to avoid header text
    @FindBy(xpath = "//div[@id='content']//form//table/tbody/tr/td[@class='text-left']/a")
    WebElement productname;

    @FindBy(xpath = "//div[@id='content']//form//table/tbody/tr/td[@class='text-center']//img")
    WebElement productimg;

    // Index 5 is usually 'Unit Price', Index 6 is 'Total'
    @FindBy(xpath = "//div[@id='content']//form//table/tbody/tr/td[5]")
    WebElement productprice;
    
    @FindBy(xpath="//div[@id='content']//form//table/tbody/tr/td[4]//div[@class='input-group btn-block']/input")
    WebElement Pquantity1;
    
    @FindBy(xpath="//div[@id='content']//form//table/tbody/tr/td[6]")
    WebElement totprice;
    
    @FindBy(xpath="//i[@class='fa fa-times-circle']")
    WebElement removeproduct;
    
    @FindBy(xpath="//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")
    WebElement removemsg;
    
    public WebElement getProductNameElement() {
        return productname;
    }

    public String Productnm() {
        return productname.getText();
    }

    public String price() {
        return productprice.getText();
    }
    public String Pquantity1() {
        // Use getAttribute("value") for input fields, getText() for labels
        return Pquantity1.getAttribute("value"); 
    }
    public String totprice()
    {
    	return totprice.getText();
    }

	public WebElement getTotalPriceElement() {
		// TODO Auto-generated method stub
		return totprice;
	}
	public void removeproduct() {
        removeproduct.click();
    }
	public boolean  removemsg() {
        return removeproduct.isDisplayed();
    }

	}


	/*//Loactors
	@FindBy(xpath="//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
	WebElement Productnm;
	@FindBy(xpath="//input[@name='quantity']")
	WebElement pquantity;
	@FindBy(xpath="//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]/img[1]")
	WebElement pimg;
	@FindBy(xpath="//div[@id='content']/form/div/table/tbody/tr/td[5]")
	WebElement price;
	
	//Action methods
	public String Productnm()
	{
		return Productnm.getText();
	}
	public String pquantity()
	{
		return pquantity.getText();
	}
	public boolean pimg()
	{
		return pimg.isDisplayed();
	}
	public String price()
	{
		return price.getText();
	}*/


