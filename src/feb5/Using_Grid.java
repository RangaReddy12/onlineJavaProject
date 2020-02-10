package feb5;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Using_Grid {
WebDriver driver;
DesiredCapabilities cap;
String url="http://orangehrm.qedgetech.com/";
String node="http://localhost:5550/wd/hub";
@Parameters({"browser"})
@BeforeTest
public void setup(String brw)throws Throwable
{
if(brw.equalsIgnoreCase("chrome"))
{
cap=new DesiredCapabilities();
cap.setBrowserName("chrome");
driver=new RemoteWebDriver(new URL(node),cap);
driver.get(url);
driver.manage().window().maximize();
}
else if(brw.equalsIgnoreCase("firefox"))
{
	cap=new DesiredCapabilities();
	cap.setBrowserName("firefox");
	driver=new RemoteWebDriver(new URL(node),cap);
	driver.get(url);
	
}
}
@Test
public void login()throws Throwable
{
driver.findElement(By.name("txtUsername")).sendKeys("Admin");
driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");
driver.findElement(By.name("Submit")).click();
Thread.sleep(5000);
}
@AfterTest
public void tearDown()throws Throwable
{
	Thread.sleep(5000);
	driver.close();
}
}
