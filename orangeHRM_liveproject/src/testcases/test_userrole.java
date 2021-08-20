package testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;



import commonfunctions.commonfunction;
import pageobject_liveproject.userrole_pageobject;

public class test_userrole extends commonfunction{
	
	static Logger logger=Logger.getLogger(test_userrole.class);

	public void movetouserpage() {
		Actions actions = new Actions(driver);
		actions.moveToElement(userrole_pageobject.admin_link);
		actions.moveToElement(userrole_pageobject.usermanagement_link);	
		actions.moveToElement(userrole_pageobject.users_link);	
		actions.click().build().perform();	
		
		}	
	
	public void userrole() {
	 
		Select selectrole=new Select(userrole_pageobject.userrole);
		selectrole.selectByIndex(1);
		}
	
	public void userstatus() {
		 
		Select selectstatus=new Select(userrole_pageobject.userstatus);
		selectstatus.selectByIndex(1);
		}
	
	public void searchbutton() {
		userrole_pageobject.searchbutton.click();
		
	}
	
	
	@Test
	public void checkuserrole() {
	
	PageFactory.initElements(driver,userrole_pageobject.class);
	logger.info(" moving to user page");
	movetouserpage();
	logger.info(" selecting the user role");
	userrole();
	logger.info(" selecting the user status");
	userstatus();
	logger.info(" click the search button");
	searchbutton();
	
  String actualrole=userrole_pageobject.userrolevalue.getText();
  
  
  String actualstatus=userrole_pageobject.userstatusvalue.getText();
  Assert.assertEquals(actualrole, "Admin");
  logger.info(" verifying the actualrole with the expected role");
  Assert.assertEquals(actualstatus, "Enabled");
  logger.info(" verifying the actual status with the expected status");
}
}