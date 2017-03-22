package com.test.nav;

import java.net.*;
import java.util.*;
import java.io.*;
import javax.xml.namespace.QName;

public class TestClass {
	public static void main(String[] args) {
		try {
			String baseURL = "http://52.172.207.164:7047/DynamicsNAV90/WS/CRONUS%20India%20Ltd./Codeunit/NAVWebService";
			// Code to make a webservice HTTP request
			URL url = new URL(baseURL);
			URLConnection connection = url.openConnection();
			HttpURLConnection httpConn = (HttpURLConnection) connection;
			httpConn.setRequestMethod("POST");
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			OutputStream out = httpConn.getOutputStream();

			// write the content of the request to the outputstream of the HTTP
			// Connection.
			// out.write();
			out.close();
		} catch (Exception e) {

		}
	}
}
