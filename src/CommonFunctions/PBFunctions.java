package CommonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Constant.PBConstant;

public class PBFunctions extends PBConstant {
	public static boolean verifyLogin(String username,String pasword)throws Throwable
	{
	driver.findElement(By.name("txtuId")).sendKeys(username);
	driver.findElement(By.name("txtPword")).sendKeys(username);
	driver.findElement(By.name("login")).click();
	Thread.sleep(4000);
	if(driver.getCurrentUrl().contains("adminflow"))
	{
		System.out.println("Login success");
		return true;
	}
	else
	{
		System.out.println("Login Fail");
		return false;
	}
	}
public static void navigatebranches()throws Throwable
{
driver.findElement(By.xpath("//tr//tr//tr//tr//tr[2]//td[1]//a[1]//img[1]")).click();
Thread.sleep(4000);
}
public static boolean verifyBranccreation(String bname,String address1,String zipcode,int country,int state,int city)
throws Throwable{
driver.findElement(By.name("BtnNewBR")).click();	
Thread.sleep(4000);
driver.findElement(By.name("txtbName")).sendKeys(bname);
driver.findElement(By.name("txtAdd1")).sendKeys(address1);
driver.findElement(By.name("txtZip")).sendKeys(zipcode);
new Select(driver.findElement(By.name("lst_counrtyU"))).selectByIndex(country);
new Select(driver.findElement(By.name("lst_stateI"))).selectByIndex(state);
new Select(driver.findElement(By.name("lst_cityI"))).selectByIndex(city);
driver.findElement(By.name("btn_insert")).click();
Thread.sleep(4000);
String alertmessage=driver.switchTo().alert().getText();
System.out.println(alertmessage);
Thread.sleep(4000);
driver.switchTo().alert().accept();
if(alertmessage.contains("New Branch"))
{
	System.out.println("Branch Creation is success");
	return true;
}
else
{
	System.out.println("Branch Creation is Fail");
	return false;
}
}
public static boolean verifyBranchUpdation(String bname,String address1)throws Throwable
{
	driver.findElement(By.xpath("//tr[3]//td[7]//a[1]//img[1]")).click();
	Thread.sleep(4000);
WebElement branchn=driver.findElement(By.name("txtbnameU"));
branchn.clear();
branchn.sendKeys(bname);
WebElement address=driver.findElement(By.name("txtadd1u"));
address.clear();
address.sendKeys(address1);
driver.findElement(By.name("btnupdate")).click();
Thread.sleep(4000);
String alertmessage1=driver.switchTo().alert().getText();
System.out.println(alertmessage1);
Thread.sleep(4000);
driver.switchTo().alert().accept();
if(alertmessage1.contains("Branch updated"))
{
	System.out.println("Branch update is success");
	return true;
}
else
{
	System.out.println("Branch update is Fail");
	return false;
}
}
public static boolean verifyLogout()throws Throwable
{
	driver.findElement(By.xpath("//td//td//td//td[3]//a[1]//img[1]")).click();
	Thread.sleep(4000);
if(driver.findElement(By.name("login")).isDisplayed())
{
	System.out.println("Logout success");
	return true;
}
else
{
	System.out.println("Logout Fail");
	return false;
}
}
}


















