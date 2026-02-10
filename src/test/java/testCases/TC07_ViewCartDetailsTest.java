package testCases;

import java.time.Duration;

import org.openqa.selenium.WebElement;
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

public class TC07_ViewCartDetailsTest extends Baseclass{
	@Test(groups = {"Regression", "master"})
    public void viewcartdetails() {
        logger.info("***** Starting TC07_ViewCartDetailsTest *****");

        try {
            // 1. Search and Select Product
            HomePage hp = new HomePage(driver);
            hp.txt_search("mac");
            hp.search_click();

            Searchpage sp = new Searchpage(driver);
            sp.Click_on_Pdoduct();

            // 2. Capture Name from Product Page
            ViewProductpage vp = new ViewProductpage(driver);
            String expectedName = vp.getProductName().trim();
            logger.info("Expected Product Name: " + expectedName);

            // 3. Add to Cart
            Addtocartpage ap = new Addtocartpage(driver);
            ap.add_QuatityOfproduct("2");
            ap.addProductToCart();

            // 4. Navigate to Cart
            hp.Click_shopingcart();

            // 5. WAIT for Cart to Load (Crucial Step)
            ShopingCartPage sc = new ShopingCartPage(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            logger.info("Waiting for product name to be visible in cart...");
            wait.until(ExpectedConditions.visibilityOf(sc.getProductNameElement()));

            // 6. Extract Data
            String actualNameRaw = sc.Productnm();
            String priceText = sc.price();
            
            logger.info("Raw Product Name from Cart: [" + actualNameRaw + "]");
            logger.info("Raw Price Text from Cart: [" + priceText + "]");

            // 7. Data Normalization
            String actualName = actualNameRaw.replace("***", "").trim();
            
            // Safety check for empty price string
            if (priceText.trim().isEmpty()) {
                throw new Exception("Price text is empty! The cart table did not load values correctly.");
            }
            
            double price = Double.parseDouble(priceText.replaceAll("[^0-9.]", ""));
            logger.info("Cleaned Name: " + actualName + " | Parsed Price: " + price);

            // 8. Assertions
            Assert.assertEquals(actualName, expectedName, "Product name mismatch!");
            Assert.assertTrue(price > 0, "Cart price should be greater than zero");

            logger.info("TC07_ViewCartDetailsTest Passed");

        } catch (Exception e) {
            logger.error("Test Failed: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
        
        logger.info("***** Finished TC07_ViewCartDetailsTest *****");
    }
}


