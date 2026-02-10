package TestBase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;//log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	public Logger logger;//log4j2
	public Properties p;//predefined class for config.properties file
	@BeforeClass(groups={"Regression","smoke","master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		//Loading properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		//declare for logfile
		logger=LogManager.getLogger(this.getClass());
		//this is for grid set up for remote
		//os
		DesiredCapabilities cap=new DesiredCapabilities();
		
		if(p.getProperty("execution_env").equals("remote"))
		{
			if(os.equalsIgnoreCase("windows"))
			{
				cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("No such os found");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome":cap.setBrowserName("chrome");break;
			case "edge":cap.setBrowserName("MicrosoftEdge");break;
			default:System.out.println("No broweser found");return;
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
		
		
		
		//local
		if(p.getProperty("execution_env").equals("local")) {	
	switch(br.toLowerCase())
	{
	case "chrome":driver=new ChromeDriver();break;
	case "edge":driver = new EdgeDriver();break;
    //case "edge":driver=new EdgeDriver();break;
	case "firefox":driver=new FirefoxDriver();break;
	default :System.out.println("Invalid Browser"); return;
	
	}
	}
	
	 	
	  driver.manage().deleteAllCookies();
	  driver.get(p.getProperty("AppUrl"));//https://tutorialsninja.com/demo/-->reading url from properties file
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
	  }
	@AfterClass(groups={"Regression","smoke","master"})
	public void teardown()
	{
		driver.quit();
	}
	
	public String randomstring() {
		String randomfname=RandomStringUtils.randomAlphabetic(8);
		return randomfname;
		}
	
		public String randomnum()
		{
			String numeric=RandomStringUtils.randomNumeric(10);
			return numeric;
		}
		public String setpwd()
		{
			String randomString=RandomStringUtils.randomAlphabetic(4);
			String numeric=RandomStringUtils.randomNumeric(10);
			//String pwd=RandomStringUtils.randomAlphanumeric(5);
			return (randomString+"@"+numeric);
		}
		public String captureScreen(String tname) throws IOException{
			String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot takesscreenshot=(TakesScreenshot)driver;
			File sourceFile=takesscreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_" +timeStamp +".png";
			File targetFile=new File(targetFilePath);
			sourceFile.renameTo(targetFile);
			return targetFilePath;
			
		}

}
