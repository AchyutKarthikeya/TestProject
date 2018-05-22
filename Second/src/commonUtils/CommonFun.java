package commonUtils;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class CommonFun {

	public void readExcel(String filePath,String fileName,String sheetName) throws IOException {

	    //Create an object of File class to open xlsx file

	    File file =    new File(filePath+"\\"+fileName);

	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook xlWorkbook = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file

	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class

	    xlWorkbook = new XSSFWorkbook(inputStream);

	    }

	    //Check condition if the file is xls file

	    else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of XSSFWorkbook class

	        xlWorkbook = new HSSFWorkbook(inputStream);

	    }

	    //Read sheet inside the workbook by its name

	    Sheet xlSheet = xlWorkbook.getSheet(sheetName);

	    //Find number of rows in excel file

	    int rowCount = xlSheet.getLastRowNum()-xlSheet.getFirstRowNum();

	    //Create a loop over all the rows of excel file to read it

	    for (int i = 0; i < rowCount+1; i++) {

	        Row row = xlSheet.getRow(i);

	        //Create a loop to print cell values in a row

	        for (int j = 0; j < row.getLastCellNum(); j++) {

	            //Print Excel data in console

	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");

	        }

	        System.out.println();

	    }
	  

	    }
	//Get config data from properties file	
			public String GetConfigData(String parametername){
				
				Properties Configuration = new Properties();
				InputStream input = null;
				String data = null;
				try {
					input = new FileInputStream("src\\commonUtils\\Configuration.properties");			
					Configuration.load(input);			
					data = (Configuration.getProperty(parametername));
				} catch (IOException exp) {
					exp.printStackTrace();
				} finally {
					if (input != null) {
						try {
							input.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				return data;
			}
			
			public String ReadFile(String fileName,String id)
	        {

	                String testinput = null;
	                String projectPath=System.getProperty("user.dir");
	                System.out.println(projectPath);
	                File fXmlFile = new File("D:\\Users\\achyut.k\\Desktop\\TestCases.xml");//projectPath+File.separator+fileName
	                System.out.println(fXmlFile);
	                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = null;
	            try {
	                dBuilder = dbFactory.newDocumentBuilder();
	            } catch (ParserConfigurationException e) {
	                e.printStackTrace();
	            }
	            Document doc= null;
	            try {
	                doc = dBuilder.parse(fXmlFile);
	            } catch (SAXException e) {
	                e.printStackTrace();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	                XPath xPath =  XPathFactory.newInstance().newXPath();
	                String expression = String.format("/TestCases/Test[@id='"+id+"']/TestModule");
	                System.out.println(expression);
	            Node node = null;
	            try {
	                node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
	            } catch (XPathExpressionException e) {
	                e.printStackTrace();
	            }
	            testinput = node != null ? (node.getTextContent()) : "cannot read the test case xml file";
	                return testinput;

	        }
	
}
