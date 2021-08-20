package commonfunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class commonfunction {
    
	public static Properties properties=null;
	public static WebDriver driver=null;
	static Logger logger=Logger.getLogger(commonfunction .class);
	
		public Properties loadpropertyfile() throws IOException {
		FileInputStream inputstream= new FileInputStream("config.properties");
	    properties=new Properties();	
		properties.load(inputstream);
		return properties;
		}
	
	
	@BeforeSuite
	public void launch_browser() throws IOException {
	PropertyConfigurator.configure("log4j.properties");
	logger.info("loading property file");
	loadpropertyfile();
	String  driverlocation=  properties.getProperty("Driverlocation");
    String  browser =properties.getProperty("browser");
	String  url= properties.getProperty("url");	
		
	if(browser.equalsIgnoreCase("chrome")){
		logger.info("opening chrome browser");
		System.setProperty("webdriver.chrome.driver", driverlocation);
		driver = new ChromeDriver();
		
	  }else if (browser.equalsIgnoreCase("firefox")) {
		  logger.info("opening firefox browser");
			System.setProperty("webdriver.gecko.driver", driverlocation);
			driver = new FirefoxDriver();	
			
		}	
		
	   
	   
	   driver.manage().window().maximize();
	   logger.info("opening HRM applications");
	   driver.get(url);
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	

	@AfterSuite
	public void teardown() {
	 logger.info(" closing the browser");
	 driver.quit();
   
	}

}

