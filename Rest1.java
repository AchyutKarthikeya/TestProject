package com.ecfd;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Rest1 {

	public static void main (String args[]) {
		
		//String restURL_XML = "http://parabank.parasoft.com/parabank/services/bank/customers/12212/";
		String restURL_JSON = "http://da-dev.web.boeing.com:8081/web/api/datasets";

		try {
			//testStatusCode(restURL_XML);
			testStatusCode(restURL_JSON);
			//testMimeType(restURL_XML,"application/xml");
			testMimeType(restURL_JSON,"application/json");
			//testContent(restURL_XML,"lastName","Smith");
			testContentJSON(restURL_JSON,"name","Amsterdam");
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testStatusCode(String restURL_JSON) throws ClientProtocolException, IOException {

		HttpUriRequest request = new HttpGet(restURL_JSON);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		
		Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),HttpStatus.SC_OK);
	}
	
	public static void testMimeType(String restURL_JSON, String expectedMimeType) throws ClientProtocolException, IOException {
		
		HttpUriRequest request = new HttpGet(restURL_JSON);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		
		Assert.assertEquals(expectedMimeType,ContentType.getOrDefault(httpResponse.getEntity()).getMimeType());
	}
	
	public static void testContent(String restURL_JSON, String element, String expectedValue) throws ClientProtocolException, IOException, SAXException, ParserConfigurationException {
		
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(restURL_JSON);
		NodeList nodelist = doc.getElementsByTagName(element);
		
		Assert.assertEquals(expectedValue,nodelist.item(0).getTextContent());		
	}
	
	public static void testContentJSON(String restURL_JSON, String element, String expectedValue) throws ClientProtocolException, IOException, SAXException, ParserConfigurationException, JSONException {

		HttpUriRequest request = new HttpGet(restURL_JSON);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// Convert the response to a String format
		String result = EntityUtils.toString(httpResponse.getEntity());
		System.out.println(result);

		// Convert the result as a String to a JSON object
		JSONObject jo = new JSONObject(result);

		Assert.assertEquals(expectedValue, jo.getString(element));

	}
	

}