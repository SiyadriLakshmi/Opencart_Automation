package testCases;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TestBase.Baseclass;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class TC01_Registrationtest extends Baseclass {

	
	@Test(groups={"Regression","master"})
	void Registration_Account_test()
	{
		try
		{
		
		logger.info("**** Starting TC01_Registrationtest ****");//log4j
		HomePage hp=new HomePage(driver);
		hp.myAccount_click();
		logger.info("clicked on account link");
		hp.Registration_click();
		logger.info("clicked on Registeration link");
		RegistrationPage rg=new RegistrationPage(driver);
		logger.info("providing user detals..");
		rg.setFirstName(randomstring());
		rg.setLastName(randomstring());
		//String s=randomstring()+"@gamil.com";
		//System.out.println(s);
		rg.setEmail(randomstring()+"@gamil.com");
		rg.setPhonenum(randomnum());
		String pwd=setpwd();
		//System.out.println(pwd);
		rg.setPassword(pwd);
		rg.setConfirmPassword(pwd);
		rg.ClickNosubscribe();
		rg.chktermsandconditions();
		rg.Click_continue();
		logger.info("Validationg expected essage ..");
		String rgcnfirm_msg=rg.chk_reg_confirm_msg();
		if(rgcnfirm_msg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test failed");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(rgcnfirm_msg,"Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("**** Finished TC01_Registrationtest ****");
	}
		
	
}

