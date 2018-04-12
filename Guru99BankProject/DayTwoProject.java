package AutomationFramework;
import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
// This Script is combination of Day one with enhancement suggested in Day 2 
public class DayTwoProject {
	WebDriver driver=null;
  @SuppressWarnings("deprecation")
@Test
  public void Test() {
	  // Entering Data is user Id / Password field and clicking on Login button
	  WebElement UserId = driver.findElement(By.name("uid"));
	  
	  WebElement Password = driver.findElement(By.name("password"));
	  
	  UserId.sendKeys(Util.USER_NAME);
	  Password.sendKeys(Util.PASSWD);
	  // clicking on login button
	  
	  driver.findElement(By.name("btnLogin")).click();
	  // Though below sentence is strike out , Assert statement is working fine
	  Assert.assertEquals(Util.EXPECTED_TITLE,driver.getTitle());
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  // setting web driver properties and opening web page
	  
	  System.setProperty(Util.DRIVER_TYPE,Util.DRIVER_PATH);
	  driver=new ChromeDriver();
	  driver.get(Util.BASE_URL+"V4/");
	  
	  // or you can access page by below alternate way
	  //driver.navigate().to("http://demo.guru99.com/v4/");
  }

  @AfterMethod
  public void afterMethod() {
	  // closing web driver instance 
	  
	  driver.close();
  }

}
