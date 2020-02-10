package ApplicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmpPage {
@FindBy(id="menu_pim_viewPimModule")
WebElement ClickPim;
@FindBy(name="btnAdd")
WebElement ClickAdd;
@FindBy(name="firstName")
WebElement EnterFname;
@FindBy(name="lastName")
WebElement EnterLname;
@FindBy(id="btnSave")
WebElement ClickSave;
public void verifyEmp(String fname,String lanme)
throws Throwable{
	ClickPim.click();
	Thread.sleep(3000);
	ClickAdd.click();
	Thread.sleep(3000);
	EnterFname.sendKeys(fname);
	EnterLname.sendKeys(lanme);
	ClickSave.click();
	Thread.sleep(4000);
}
}
