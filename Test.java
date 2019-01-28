package ECFD;

	import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;

	public class Test {

		public static void main(String[] args) throws Exception {
			
			/*try
			{
			URL url = new URL("http://da-dev.web.boeing.com:8081/web/api/datasets");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//conn.connect();
			//System.out.println(conn.getResponseCode());
			//conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			
			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
	*/
			
			
			
			
			/// POST
			
			
			try {

				URL url = new URL("http://da-dev.web.boeing.com:8081/web/api/ecfd/datasets/search");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
				File src = new File("D:\\Users\\diwakarsd\\Desktop\\Test.xlsx"); 
			 	FileInputStream fis=new FileInputStream(src);
			 	XSSFWorkbook wb = new XSSFWorkbook(fis); 
			 	XSSFSheet sheet1=wb.getSheetAt(0);
			    String Request =sheet1.getRow(0).getCell(0).getStringCellValue();	
			    System.out.println(Request);

				//String input = "{\"id\":[] ,\"name\":[] ,\"category\": [],\"createdStartDate\":1495693512064,\"createdEndDate\": 1495618797089}";
				String input = Request;
					
				 
				 
				 
				OutputStream os = conn.getOutputStream();
				os.write(input.getBytes());
				os.flush();

				/*if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
					throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
				}*/

				BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream())));

				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}

				conn.disconnect();

			  } catch (MalformedURLException e) {

				e.printStackTrace();

			  } catch (IOException e) {

				e.printStackTrace();

			 }

			
			
			
			
			

		}

	}



