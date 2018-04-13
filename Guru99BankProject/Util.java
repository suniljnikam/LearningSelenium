package AutomationFramework;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Util {
	public static final String FIRST_NAME = "Sunil";
	public static final String LAST_NAME = "Nikam";

	public static final String USER_NAME = "mngr127275";
	public static final String PASSWD = "ArybAse";

	public static final int WAIT_TIME = 30;
	public static final String ExpectedAlertText = "User or Password is not valid";

	public static final String BASE_URL = "http://demo.guru99.com/";
	public static final String EXPECTED_TITLE = "Guru99 Bank Manager HomePage";
	public static final String DRIVER_TYPE = "webdriver.chrome.driver";
	public static final String DRIVER_PATH = "C:\\UBS\\Dev\\chromedriver.exe";

	// Creating function which will return 2D array with excel data

	public static String[][] getExcelData(String xlpath) throws BiffException, IOException {

		// Currently only reading data from excel
		// first create file object and workbook object
		System.out.println("Inside getExcelData Class ");
		File f = new File(xlpath);
		Workbook wb = Workbook.getWorkbook(f);
		Sheet sh = wb.getSheet(0);
		int TotalRows = sh.getRows();
		int TotalColumns = sh.getColumns();
		
		String data[][] = new String [TotalRows][TotalColumns];

		for (int row = 1; row < TotalRows; row++) {
			for (int column = 0; column < TotalColumns; column++) {
				System.out.println("Inside for loop ");
				data[row - 1][column] = sh.getCell(column, row).getContents(); // 		VIP getCell(0,1)	 point to cell at 0th column and 1st RWO in excel																// -
																				// 																	
			}

		}

		return data;

	}
}
