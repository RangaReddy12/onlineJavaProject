package Constant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PBConstant {
public static WebDriver driver;
@BeforeMethod
public void setUp()
{
	System.setProperty("webdriver.chrome.driver", "E:\\Online_Framework\\Orange_HRM\\CommonDrivers\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("http://primusbank.qedgetech.com/");
	driver.manage().window().maximize();
	
}
@AfterMethod
public void tearDown()
{
	driver.close();
}
}
