package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertBoxDemo {
static WebDriver driver=null;
	public static void main(String[] args) {
		
		System.setProperty(Util.DRIVER_TYPE,Util.DRIVER_PATH);
		driver=new ChromeDriver();
		driver.navigate().to("http://jsbin.com/usidix/1");
		driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
		String alertMessage=driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		driver.switchTo().alert().accept();
		driver.close();
		

	}

}
