package testcases;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonfunctions.commonfunction;
import pageobject_liveproject.Dashboard_pageobject;
import pageobject_liveproject.login_pageobject;



public class test_pending_leave_request extends commonfunction {
	 String actualmessage = null;
	 static Logger logger=Logger.getLogger(test_pending_leave_request .class);
	 
	public void login(){
		logger.info("login the application");
		PageFactory.initElements(driver,login_pageobject.class );
		login_pageobject.username.sendKeys(properties.getProperty("username"));
		login_pageobject.password.sendKeys(properties.getProperty("password"));
		login_pageobject.loginbutton.click();
		}
	
	
	public void getleaverequesttext() {
		logger.info(" getting the text in pending leave request");
		PageFactory.initElements(driver,Dashboard_pageobject.class);
		actualmessage= Dashboard_pageobject.pending_leave_requests.getText();
	    }
	
	@Test
	public void verifyPendingLeaveRquests(){
		login();	
		getleaverequesttext(); 
		logger.info(" verifiying the actual message with the expected message");
	    Assert.assertEquals(actualmessage,"No Records are Available");
	    
		}

}

