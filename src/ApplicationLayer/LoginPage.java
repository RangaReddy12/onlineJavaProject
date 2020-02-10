package ApplicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
//define Repository
@FindBy(name="txtUsername")
WebElement EnterUsername;
@FindBy(name="txtPassword")
WebElement EnterPassword;
@FindBy(name="Submit")
WebElement ClickLogin;
//Develope method
public void verify_Login(String username,String password)
{
	EnterUsername.sendKeys(username);
	EnterPassword.sendKeys(password);
	ClickLogin.click();
}
}
