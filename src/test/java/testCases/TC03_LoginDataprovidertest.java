package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.Baseclass;
import Utilities.DataProviderUtility;
import pageObjects.HomePage;
import pageObjects.Loginpage;
import pageObjects.MyAccountPage;

public class TC03_LoginDataprovidertest extends Baseclass{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviderUtility.class)
	public void Datadriventest(String UserName,String password,String exp)
	{
		try {
		logger.info("****Login test Start...****");
		//Home page
		HomePage hp=new HomePage(driver);
		hp.myAccount_click();
		hp.ClickLogin();
		//Login page
		Loginpage lp=new Loginpage(driver);
		lp.setEmail(UserName);
		lp.setpassword(password);
		lp.ClickLogininloginpage();
		//MyAccountPage
		MyAccountPage mp=new MyAccountPage(driver);
		//validation
		boolean targetmsg=mp.Myaccountmsg();
		/*Data is Valid-->login success-->test passed-->logout
		 *                login failed-->test failed
		 *   
		 *Data is Invalid-->login success-->test failed-->logout
		 *                 login failed-->test passed
		 */
		
		//Data is Valid-->login success-->test passed-->logout
		                 //login failed-->test failed
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetmsg==true)
			{
				mp.Clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		//Data is Invalid-->login success-->test failed-->logout
		                  //login failed-->test passed
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetmsg==true)
			{
				mp.Clicklogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		logger.info("****Login test Start...****");
		
		
	}catch(Exception e)
		{
		Assert.fail();
		}
	}
	
	
	

}
