package ApplicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage {
@FindBy(id="menu_admin_viewAdminModule")
WebElement ClickAdmin;
@FindBy(id="btnAdd")
WebElement ClickAdd;
@FindBy(name="systemUser[employeeName][empName]")
WebElement EnterEname;
@FindBy(name="systemUser[userName]")
WebElement Enteruser;
@FindBy(name="systemUser[password]")
WebElement Enterpass;
@FindBy(name="systemUser[confirmPassword]")
WebElement EnterCpass;
@FindBy(name="btnSave")
WebElement ClickSave;
public void verifyUser(String ename,String username,String password,String cpassword)
throws Throwable{
	ClickAdmin.click();
	Thread.sleep(3000);
	ClickAdd.click();
	Thread.sleep(3000);
	EnterEname.sendKeys(ename);
	Enteruser.sendKeys(username);
	Enterpass.sendKeys(password);
	EnterCpass.sendKeys(cpassword);
	ClickSave.click();
	Thread.sleep(4000);
}
}
