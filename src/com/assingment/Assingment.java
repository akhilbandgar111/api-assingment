package com.assingment;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

public class Assingment
{
	public static final String API_URL = "https://seller.flipkart.com/api-docs/order-api-docs/v3/PostShipmentSearch.html#getshipment-label";
	public static String CONTENT_TYPE_KEY = "content-type";
	public static String CONTENT_TYPE_VALUE = "test/html";

	public static void main(String args[]) throws IOException
	{
		URL url = new URL(API_URL);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setRequestProperty(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
		InputStream respStream = connection.getInputStream();
		String str = Assingment.getDataFromInputStream(respStream);
		System.out.println(str);
	}

	public static String getDataFromInputStream(InputStream respStream) throws IOException
	{
		int bufferSize = 1024;
		char[] buffer = new char[bufferSize];
		StringBuilder out = new StringBuilder();
		Reader in = new java.io.InputStreamReader(respStream, StandardCharsets.UTF_8);
		for (int numRead; (numRead = in.read(buffer, 0, buffer.length)) > 0;)
		{
			out.append(buffer, 0, numRead);
		}
		return out.toString();

	}

}
