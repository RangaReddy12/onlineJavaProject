package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ApplicationLayer.EmpPage;
import ApplicationLayer.LoginPage;
import ApplicationLayer.LogoutPage;
import ApplicationLayer.UserPage;

public class TestScript {
WebDriver driver;
@BeforeMethod
public void setup()
{
	System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("http://orangehrm.qedgetech.com/");
	LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	login.verify_Login("Admin", "Qedge123!@#");
}
@Test(priority=0)
public void usercreation()throws Throwable
{
	UserPage user=PageFactory.initElements(driver, UserPage.class);
user.verifyUser("Akhi testing", "Akhilesh0909", "Akhilesh@900", "Akhilesh@900");	
}
@Test(priority=1)
public void addemp()throws Throwable
{
	EmpPage emp=PageFactory.initElements(driver, EmpPage.class);
	emp.verifyEmp("Test123", "Selenium");
}
@AfterMethod
public void tearDown()throws Throwable
{
	LogoutPage logout=PageFactory.initElements(driver, LogoutPage.class);
	logout.verifyLogout();
	driver.close();
}
}










