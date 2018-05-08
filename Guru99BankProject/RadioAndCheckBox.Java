package AutomationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class RadioandCheckBoxDemo {
	
	WebDriver driver=null; 
	@Test
  public void TestCase1() throws InterruptedException {
	  //Storing property of first radio button to element radio 1 and clicking on it.
	  WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
	  radio1.click();
	  Thread.sleep(1000);
	  //Clicking on second radio button
	driver.findElement(By.id("vfb-7-2")).click();
	  
	if(radio1.isSelected())
	{
		System.out.println("Radio1 is selected");
	}
	else{
		System.out.println("Radio2 is selected");
	}
	
	// Selecting Check Box Check boxes can be toggle by simply clicking on it
	
	WebElement CheckBox1=driver.findElement(By.id("vfb-6-0"));
	
	// First click will select checkBox
	CheckBox1.click();
	
	if(CheckBox1.isSelected())
	{
		System.out.println("CheckBox1 is selected");
	}
	else{
		System.out.println("CheckBox1 is not selected");
	}
	Thread.sleep(1000);
	
CheckBox1.click();
	
	if(CheckBox1.isSelected())
	{
			System.out.println("CheckBox1 is selected");
	}
	else{
		System.out.println("CheckBox1 is not selected");
	}
  }
  @BeforeMethod
  public void beforeMethod() {
	  // setting web driver property
	  System.setProperty("webdriver.chrome.driver", "C:\\UBS\\Dev\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.navigate().to("http://demo.guru99.com/test/radio.html");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
