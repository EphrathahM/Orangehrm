package pageobject_liveproject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class userrole_pageobject {

	@FindBy(id="searchSystemUser_userName")
	public static WebElement username;
	
	@FindBy(id="searchSystemUser_userType")
	public static WebElement userrole;
	
	@FindBy(id="searchSystemUser_status")
	public static WebElement userstatus;
	
	@FindBy(id="searchBtn")
	public static WebElement searchbutton;

	@FindBy(xpath="//tr/td[3]")
	public static WebElement userrolevalue;

	@FindBy(xpath="//tr/td[5]")
	public static WebElement userstatusvalue;
	

	@FindBy(id = "menu_admin_viewAdminModule" )
	public static WebElement admin_link;
	
	@FindBy(id="menu_admin_UserManagement")
	public static WebElement usermanagement_link;
	
	@FindBy(id="menu_admin_viewSystemUsers")
	public static WebElement users_link;
	
	
	
	
	
	
	
	
	/*
	 * @FindBy(linkText ="Admin" ) public static WebElement admin_link;
	 * 
	 * @FindBy(linkText = "User Management") public static WebElement
	 * usermanagement_link;
	 * 
	 * @FindBy(linkText = "Users") public static WebElement users_link;
	 */
	
}
