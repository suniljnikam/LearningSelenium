// refer DayTwoProject and DayThreeProject first before reading to this code 

package AutomationFramework;
import org.testng.annotations.Test;
import jxl.read.biff.BiffException;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DayFourProject {
	WebDriver driver = null;
@Test
public void Test() throws IOException, BiffException{
	
	
	 String[][] excelData = Util.getExcelData("C://UBS//DEV//ReadingExcelFileDemo.xls");
	
	 for (int i =0;i<excelData.length-1;i++)
	 {
		 String userName=excelData[i][0];
		 String passwd =excelData[i][1];
		 System.out.println("Username = "+userName+"  Passwrod="+passwd);
	 }
	
	 
	 // traversing through array to get user name and password 
	 for (int i =0;i<excelData.length-1;i++)
	 {
		 String userName=excelData[i][0];
		 String passwd =excelData[i][1];
		 
		 WebElement UserId = driver.findElement(By.name("uid"));
		  
		 WebElement Password = driver.findElement(By.name("password"));
		  
		  UserId.sendKeys(userName);
		  Password.sendKeys(passwd);
		  // clicking on login button
		  driver.findElement(By.name("btnLogin")).click();
		 
		  
		  // in case of invalid input alert will present.Handle alert as given below in try block 
		  try{
			  Alert a = driver.switchTo().alert();
			  String actualError = a.getText();
			  System.out.println(actualError);
			  a.accept();
			  Assert.assertEquals(actualError, Util.ExpectedAlertText);
		  }
		  catch (NoAlertPresentException e){
			  // On successful login compare actual page title with expected title
			  String actualTitle=driver.getTitle();
			  Assert.assertEquals(actualTitle, Util.EXPECTED_TITLE);
			  
			 
		  }
		  
	 }
	 
	  
}
@BeforeMethod
public void beforeMethod() {
	  System.setProperty(Util.DRIVER_TYPE, Util.DRIVER_PATH);
	  driver = new ChromeDriver();
	  driver.get(Util.BASE_URL+"V4/");
	 
	  
	  // or you can write it as 
	  //driver.navigate().to("http://demo.guru99.com/v4/");
}

@AfterMethod
public void afterMethod() {
	driver.close();
}

}
