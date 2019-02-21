package com.umedia.zuulgateway.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {
	public static String sendPost(String url, String urlParameters) throws IOException {
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		try {
			con.setRequestMethod("POST");
		} catch (ProtocolException e) {		
			e.printStackTrace();
		}
	
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

//		int responseCode = con.getResponseCode();
//		System.out.println("\nSending 'POST' request to URL : " + url);
//		System.out.println("Post parameters : " + urlParameters);
//		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		return response.toString();
	}
	
	public static void responseJson(HttpServletResponse response, String jsonString) throws IOException {
		response.setStatus(200);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().println(jsonString);
		response.getWriter().flush();
	}
}
