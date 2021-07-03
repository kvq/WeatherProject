package me.kvq.weather.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONObject;

public class JsonUtil {
	
	public static JSONObject getFromURL(String url) throws MalformedURLException, IOException {
		 InputStream is = new URL(url).openStream();
		    try (BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")))){
		      
		      String jsonText = readAll(rd);
		      JSONObject json = new JSONObject(jsonText);
		      return json;
		    } 
	}
	
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

}
