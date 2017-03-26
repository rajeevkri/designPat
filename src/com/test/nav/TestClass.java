package com.test.nav;

import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.namespace.QName;

import org.apache.commons.codec.binary.Base64;

public class TestClass {
	
	static class MyAuthenticator extends Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            // I haven't checked getRequestingScheme() here, since for NTLM
            // and Negotiate, the usrname and password are all the same.
        	System.out.println("Requesting Host  : " + getRequestingHost());
            System.out.println("Requesting Port  : " + getRequestingPort());
            System.out.println("Requesting Prompt : " + getRequestingPrompt());
            System.out.println("Requesting Protocol: "
                + getRequestingProtocol());
            System.out.println("Requesting Scheme : " + getRequestingScheme());
            System.out.println("Requesting Site  : " + getRequestingSite());
        	/*String userName = "BS-APPSRV\\OMS.PMS";
			String password = "BlueStoneNAV!@#$)(*&";*/
            String userName = "BS-APPSRV\\vivek.krishna";
			String password = "DeltaEcho123";
            System.err.println("Feeding username and password for " + getRequestingScheme());
            return (new PasswordAuthentication(userName, password.toCharArray()));
        }
    }
	
	public static void main(String[] args) {
//		Authenticator.setDefault(new MyAuthenticator());
		try {
			String baseURL = "http://52.172.207.164:7047/DynamicsNAV90/WS/CRONUS%20India%20Ltd./Codeunit/NAVWebService";
			String soapAction = "urn:microsoft-dynamics-schemas/codeunit/NAVWebService:TestFunction";
			// Code to make a webservice HTTP request
			URL url = new URL(baseURL);
			/*String userName = "vivek.krishna";
			String password = "DeltaEcho123";*/
			String userName = "BS-APPSRV\\OMS.PMS";
			String password = "BlueStoneNAV!@#$)(*&";
			String userPassword = "http://" + userName + ":" + password + "@52.172.207.164";
//			String encoding1 = new sun.misc.BASE64Encoder().encode(userPassword.getBytes(StandardCharsets.UTF_8));
			//output - QlMtQVBQU1JWXHZpdmVrLmtyaXNobmE6RGVsdGFFY2hvMTIz
			byte[] data = userPassword.getBytes(StandardCharsets.UTF_8);
			//String encoding = Base64.getEncoder().encodeToString(data);

			//String encoding = new sun.misc.BASE64Encoder().encode(data);
			//String encoding = new String(Base64.decodeBase64(Base64.encodeBase64(userPassword.getBytes())));
			String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));
			//output - QlMtQVBQU1JWXHZpdmVrLmtyaXNobmE6RGVsdGFFY2hvMTIz
			URLConnection connection = url.openConnection();
			/*connection.setRequestProperty("Authorization", "Basic " + encoding);
			connection.connect();*/
			HttpURLConnection httpConn = (HttpURLConnection) connection;
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			String xmlInput = " <Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" + "  <Body>\n"
					+ " <TestFunction  xmlns=\"urn:microsoft-dynamics-schemas/codeunit/NAVWebService\">\n"
					+ " <inputTxt>a</inputTxt>\n" + "  </TestFunction>\n" + "  </Body>\n" + " </Envelope>";

			byte[] buffer = new byte[xmlInput.length()];
			buffer = xmlInput.getBytes();
			bout.write(buffer);
			byte[] b = bout.toByteArray();
			// Set the appropriate HTTP parameters.
			httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
			httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			httpConn.setRequestProperty("SOAPAction", soapAction);
			httpConn.setRequestProperty("Authorization", "Basic " + encoding);
			httpConn.setRequestMethod("POST");
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			OutputStream out = httpConn.getOutputStream();
			// Write the content of the request to the outputstream of the HTTP
			// Connection.
			out.write(b);
			out.close();
			// Ready with sending the request.

			// Read the response.
			httpConn.connect();
			InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			String responseString = "";
			String outputString = "";
			// Write the SOAP message response to a String.
			while ((responseString = in.readLine()) != null) {
				outputString = outputString + responseString;
			}
			System.out.println(outputString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
