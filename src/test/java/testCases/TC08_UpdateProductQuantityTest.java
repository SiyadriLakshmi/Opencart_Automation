package testCases;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.Baseclass;
import pageObjects.Addtocartpage;
import pageObjects.HomePage;
import pageObjects.Searchpage;
import pageObjects.ShopingCartPage;
import pageObjects.ViewProductpage;

public class TC08_UpdateProductQuantityTest extends Baseclass {
	
	@Test(groups = {"Regression", "Master"})
	public void updateproductquatity() {
		logger.info("***** Starting TC08_UpdateProductQuantityTest *****");

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
            
            // --- STEP A: SYNCHRONIZATION ---
            // Explicitly wait for the cart table/total price to be rendered to avoid "Empty String" errors
            logger.info("Waiting for cart elements to be visible...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(sc.getTotalPriceElement()));
            
            // --- STEP B: DATA EXTRACTION ---
            // Capturing raw strings from the UI
            String qua = sc.Pquantity1(); // Uses getAttribute("value") inside PageObject
            String price = sc.price();
            String totprice = sc.totprice();
            
            logger.info("Captured UI Data -> Qty: [" + qua + "], Unit Price: [" + price + "], Total Price: [" + totprice + "]");

            // --- STEP C: DATA NORMALIZATION & PARSING ---
            logger.info("Normalizing and parsing numeric values...");
            
            // Remove currency symbols, commas, and spaces using Regex
            double quantity = Double.parseDouble(qua.replaceAll("[^0-9.]", ""));
            double priceValue = Double.parseDouble(price.replaceAll("[^0-9.]", ""));
            double actualTotalValue = Double.parseDouble(totprice.replaceAll("[^0-9.]", ""));
            
            // --- STEP D: BUSINESS LOGIC CALCULATION ---
            double expectedTotal = priceValue * quantity;
            logger.info("Calculation: " + priceValue + " * " + quantity + " = Expected Total: " + expectedTotal);
            logger.info("Actual Total from UI: " + actualTotalValue);
            
            // --- STEP E: VALIDATION ---
            logger.info("Validating Total Price matches Unit Price * Quantity...");
            // Using a delta of 0.01 to handle potential floating-point precision issues
            Assert.assertEquals(actualTotalValue, expectedTotal, "Total price mismatch in the cart!");
            
            logger.info("TC08_UpdateProductQuantityTest Passed Successfully");

        } catch (Exception e) {
            logger.error("Test Failed due to Exception: " + e.getMessage());
            // Fail the test explicitly so it shows up in TestNG reports
            Assert.fail("Test failed due to exception: " + e.getMessage());
        } finally {
            logger.info("***** Finished TC08_UpdateProductQuantityTest *****");
        }
	}
}