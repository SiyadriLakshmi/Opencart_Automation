package testCases;


	
	

	import java.util.List;

	import org.openqa.selenium.WebElement;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	import TestBase.Baseclass;
import Utilities.DataProviderUtility;
import pageObjects.Addtocartpage;
	import pageObjects.HomePage;
	import pageObjects.Searchpage;

	public class TC05_SearchpageDataproviderTest extends Baseclass{
		
		@Test(groups={"Regression","master"}, dataProvider="Searchdata", dataProviderClass=DataProviderUtility.class)
		public void searchTest(String data, String Datavalidation) {
		    try {
		        logger.info("**** Starting TC05_SearchpageDataproviderTest for keyword: " + data + " ****");
		        
		        HomePage hp = new HomePage(driver);
		        
		        // Handle the 'Blank' entry from Excel Row 4
		        // If data is null or empty, we send an empty string to the search box
		        String searchKeyword = (data == null) ? "" : data.trim();
		        
		        hp.txt_search(searchKeyword);
		        hp.search_click();
		        
		        Searchpage sp = new Searchpage(driver);
		        List<WebElement> prolist = sp.productlist();
		        
		        boolean productFound = false;
		        
		        // Check if any product in the results matches our search keyword
		        if (!prolist.isEmpty() && !searchKeyword.isEmpty()) {
		            for (WebElement product : prolist) {
		                if (product.getText().toLowerCase().contains(searchKeyword.toLowerCase())) {
		                    productFound = true;
		                    break;
		                }
		            }
		        }

		        // --- VALIDATION LOGIC BASED ON EXCEL ---

		        if (Datavalidation.equalsIgnoreCase("valid")) {
		            // Case: MacBook (Row 2)
		            if (productFound) {
		                logger.info("Test Passed: Valid product '" + searchKeyword + "' found.");
		                Assert.assertTrue(true);
		            } else {
		                logger.error("Test Failed: Valid product '" + searchKeyword + "' NOT found.");
		                Assert.fail("Expected product was not found in results.");
		            }
		        } 
		        
		        else if (Datavalidation.equalsIgnoreCase("invalid")) {
		            // Case: XYZ123 (Row 3) and Blank (Row 4)
		            if (productFound) {
		                logger.error("Test Failed: Invalid data '" + searchKeyword + "' actually returned a product.");
		                Assert.fail("Product found for invalid search criteria.");
		            } else {
		                logger.info("Validation: Product correctly not found. Checking for 'No results' message.");
		                
		                // Use a try-catch for the specific element check to avoid crashing the whole test
		                try {
		                    boolean isMessageDisplayed = sp.checkmsgfornotavailableproducts();
		                    Assert.assertTrue(isMessageDisplayed, "The 'No product matches' message was not displayed.");
		                } catch (Exception e) {
		                    Assert.fail("Search failed for '" + searchKeyword + "' but the 'No products' error message was not found on the page.");
		                }
		            }
		        }
		        hp.clearSearchBox();

		    } catch (Exception e) {
		        logger.error("Critical Exception: " + e.getMessage());
		        e.printStackTrace(); 
		        Assert.fail("Test interrupted by exception: " + e.getMessage());
		    }
		    logger.info("**** TC05_SearchpageDataproviderTest Finished ****");
		}
	}
		    
		



