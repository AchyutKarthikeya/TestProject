package Sec;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import commonUtils.CommonFun;
//import Cucumbertest.smoke;
import cucumber.api.java.en.When;

public class Secja {

	@SuppressWarnings("deprecation")
	@When("^User Navigate to LogIn Page$")
	public static void main() throws IOException {
		// System.setProperty("webdriver.gecko.driver","D:\\workspace\\External
		// Jars\\FF_geckodriver-v0.19.1-win64\\geckodriver.exe");
		WebDriver driver;
		// driver = new FirefoxDriver();
		// driver.get("https://google.co.in");
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
		caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
		caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		System.setProperty("webdriver.ie.driver",
				"D:\\workspace\\External Jars\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe");
		driver = new InternetExplorerDriver(caps);
		
		CommonFun objExcelFile = new CommonFun();
		String URL1 = objExcelFile.GetConfigData("URL");
		driver.get(URL1);
		
		//driver.get("https://phptravels.com/demo/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//String url = driver.findElement(By.xpath("//a[@href='//www.phptravels.net/admin']")).getText();
		//String url1 = driver.findElement(By.xpath("//div[contains(@data-wow-delay,'0.5s') and contains(@class,'animated')]")).getAttribute("innertext");
		// div[contains(@data-wow-delay,'0.5s') and
		// contains(@class,'animated')]"
		//System.out.println(url);
		//System.out.println(url1);

		// Create an object of ReadExcelFile class
		// Prepare the path of excel file

		// String filePath =
		// System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
		
		/*
		
		String filePath = "D:\\workspace";
		String fileName = "New Microsoft Excel Worksheet.xlsx";
		
		// Call read file method of the class to read data
		String sheetName = "Sheet1";
		String[] dataToWrite = { "Mr.F", "India" };
		objExcelFile.readExcel(filePath, fileName, sheetName);

		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook xlWorkbook = null;
		String fileExtenstion = fileName.substring(fileName.indexOf("."));

		if (fileExtenstion.equals(".xls")) {
			xlWorkbook = new HSSFWorkbook(inputStream);
		} else if (fileExtenstion.equals(".xlsx")) {
			xlWorkbook = new XSSFWorkbook(inputStream);
		}

		Sheet xlWorksheet = xlWorkbook.getSheet(sheetName);

		int rowCount = xlWorksheet.getLastRowNum() - xlWorksheet.getFirstRowNum();

		for (int i = 0; i < rowCount + 1; i++) {
			Row row = xlWorksheet.getRow(i);

			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.println(row.getCell(j).getStringCellValue());
			}

		}
		// Read excel sheet by sheet name

		// Sheet sheet = xlWorkbook.getSheet(sheetName);

		// Get the current count of rows in excel file

		int rowCount1 = xlWorksheet.getLastRowNum() - xlWorksheet.getFirstRowNum();

		// Get the first row from the sheet

		Row row = xlWorksheet.getRow(0);

		// Create a new row and append it at last of sheet

		Row newRow = xlWorksheet.createRow(rowCount1 + 1);

		// Create a loop over the cell of newly created Row

		for (int j = 0; j < row.getLastCellNum(); j++) {

			// Fill data in row

			Cell cell = newRow.createCell(j);

			cell.setCellValue(dataToWrite[j]);
		}
		  inputStream.close();

		    //Create an object of FileOutputStream class to create write data in excel file

		    FileOutputStream outputStream = new FileOutputStream(file);

		    //write data in the excel file

		    xlWorkbook.write(outputStream);

		    //close output stream

		    outputStream.close();
		    
		    */
		    System.out.println(objExcelFile.ReadFile("TestCases.xml","1"));
		    

	}
}
