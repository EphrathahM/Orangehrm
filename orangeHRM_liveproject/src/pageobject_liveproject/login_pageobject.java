package pageobject_liveproject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login_pageobject {
	@FindBy(id="txtUsername")
	public static WebElement username;
	
	@FindBy(id="txtPassword")
	public static WebElement password;
	
	@FindBy(id="btnLogin")
	public static WebElement loginbutton;
}
