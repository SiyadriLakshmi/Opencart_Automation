package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.Baseclass;
import pageObjects.Addtocartpage;
import pageObjects.HomePage;
import pageObjects.Searchpage;

public class TC04_AddToCartTest extends Baseclass {
	
	@Test(groups={"Regression","master"})
	public void searchTest()
	{
		try {
			logger.info("**** Starting TC04_Searchpagetest ****");
		//homepage class
		HomePage hp=new HomePage(driver);
		logger.info("Enter the text....");
		hp.txt_search("mac");
		logger.info("Click search button....");
		hp.search_click();
		//searchpage class
		Searchpage sp=new Searchpage(driver);
		logger.info("Serach page appear....");
		sp.Click_on_Pdoduct();
		logger.info("Clicked  on product....");
		logger.info("Add to cartpage appear....");
		Addtocartpage ap=new Addtocartpage(driver);
		logger.info("Update the quatity of the product....");
		ap.add_QuatityOfproduct("2");
		logger.info("product add to cart successfully....");
		ap.addProductToCart();
		boolean succesmsg=ap.chk_addtocart_confirm_msg();
		
		Assert.assertTrue(
			    ap.chk_addtocart_confirm_msg(),
			    "Add to cart confirmation not displayed"
			);
		
	}catch(Exception e) {Assert.fail();}
	
	
		logger.info("****TC04_Searchpagetest Finished****");
}}
