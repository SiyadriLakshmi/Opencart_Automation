package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.Baseclass;
import pageObjects.HomePage;
import pageObjects.Loginpage;
import pageObjects.MyAccountPage;

public class TC02_Logintest extends Baseclass {
	
	
	@Test(groups={"smoke","master"})
	void Login() throws IOException
	{
		try {
		logger.info("****Login test Start...****");
		//Home page
		HomePage hp=new HomePage(driver);
		hp.myAccount_click();
		hp.ClickLogin();
		//Login page
		Loginpage lp=new Loginpage(driver);
		lp.setEmail(p.getProperty("Email"));
		lp.setpassword(p.getProperty("password"));
		lp.ClickLogininloginpage();
		//MyAccountPage
		MyAccountPage mp=new MyAccountPage(driver);
		//validation
		boolean Accountmsg=mp.Myaccountmsg();
		Assert.assertTrue(Accountmsg);//Assert.assertEquals(Accountmsg,true,"Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}

}
