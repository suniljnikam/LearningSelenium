//This Program is to only read data through excel

package AutomationFramework;
import org.testng.annotations.Test;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class DayThreeProject {
	WebDriver driver = null;
  @Test
  public void Test() throws IOException, BiffException{
	  // Currently only reading data from excel
	  //first create file object and workbook object
	  
	 File file = new File("C://UBS//DEV//ReadingExcelFileDemo.xls");
	 Workbook wb = Workbook.getWorkbook(file);	  
	  
	  // or you can create workbook object as below as well using file stream
	  
	  /*String FilePath = "C://UBS//DEV//ReadingExcelFileDemo.xlsx";
	  FileInputStream fs = new FileInputStream(FilePath);
	  Workbook wb = Workbook.getWorkbook(fs);*/
	 
	 //or you can directly write it as 
	 //Workbook wb = Workbook.getWorkbook(new File("samplefile.xls"));

	 // Create a Sheet object as below
	 Sheet sh=wb.getSheet(0); // that means first sheet - you can write sheet name as well 
	 						  // example sheet sh=getSheet("Sheet1") or getSheet("Data")
	 
	 // reading data in for loop 
	 int TotalRows = sh.getRows();
	 int TotalColumns = sh.getColumns();
	 
	 System.out.println("total number of rows detected =\t"+TotalRows+"\n total number of Columns detected =\t"+TotalColumns);
	 
	 for (int row=1; row<TotalRows; row++)
	 {
		 for (int column =0; column<TotalColumns; column++)
		 {
			 String data = sh.getCell(column,row).getContents(); //VIP - getCell(0,1) will point to cell of 0th COLUMN and 1st ROW in excel
			 System.out.print(data+"\t");
		 }
		 System.out.println("");
	 }
	 
	 
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
  }

  @AfterMethod
  public void afterMethod() {
	
  }

}
