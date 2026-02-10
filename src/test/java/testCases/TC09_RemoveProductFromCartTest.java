package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.Baseclass;
import pageObjects.Addtocartpage;
import pageObjects.HomePage;
import pageObjects.Searchpage;
import pageObjects.ShopingCartPage;

public class TC09_RemoveProductFromCartTest extends Baseclass {
	
	@Test
	void Removeproduct()
	{
		try {
            // 1. Search for product
            HomePage hp = new HomePage(driver);
            logger.info("Searching for product: mac");
            hp.txt_search("mac");
            hp.search_click();

            // 2. Click on product in search results
            Searchpage sp = new Searchpage(driver);
            logger.info("Clicking on product from search page");
            sp.Click_on_Pdoduct();
            
            // 3. Set quantity and add to cart
            Addtocartpage ap = new Addtocartpage(driver);
            logger.info("Setting quantity to '2' and adding to cart");
            ap.add_QuatityOfproduct("2");
            ap.addProductToCart();

            // 4. Navigate to Shopping Cart
            logger.info("Navigating to Shopping Cart page");
            hp.Click_shopingcart();
            
            ShopingCartPage sc = new ShopingCartPage(driver);
            sc.removeproduct();
            boolean msg=sc.removemsg();
            
            
            //Validation
            Assert.assertTrue(msg);
	}catch(Exception e) {e.getMessage();}

}}
