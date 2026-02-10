package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.Baseclass;
import pageObjects.HomePage;
import pageObjects.Searchpage;
import pageObjects.ViewProductpage;

public class TC06_viewProductDetailsTest extends Baseclass {

	@Test(groups={"Regression","master"})
	public void ViewProductDetails()
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
		ViewProductpage vp=new ViewProductpage(driver);
		boolean pname=vp.pname();
		boolean pdiscription=vp.pdiscription();
		boolean pprice=vp.pprice();
		
		//Validations
		if(pname&pdiscription&pprice)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}catch(Exception e) {e.getMessage();}
}}
