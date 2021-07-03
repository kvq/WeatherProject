package me.kvq.weather.dataworker;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONObject;

import me.kvq.weather.util.JsonUtil;

public class IpInfo {
	
	private String ip;
	JSONObject obj;
	
	public IpInfo(String ip) throws MalformedURLException, IOException {
		this.ip = ip;
		locate();
	}
	
	
	public String getIP() {
		return ip;
	}
	
	public String getCountry() {
		
		return obj.getString("country");
	}
	
	public String getCity() {
		return obj.getString("city");
	}
	
	public String getZIP() {
		return obj.getString("zip");
	}
	
	
	
	private IpInfo locate() throws MalformedURLException, IOException {
		
		obj = JsonUtil.getFromURL("http://ip-api.com/json/" +ip);
		
		return this;
	}
	
	

}
