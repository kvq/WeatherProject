package me.kvq.weather.dataworker;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONObject;

import me.kvq.weather.WeatherApplication;
import me.kvq.weather.exceptions.NoWeatherDataException;
import me.kvq.weather.util.JsonUtil;

public class Weather {
	
	private final static String API_KEY = WeatherApplication.getKeyLoader().get("API_KEY").orElse("");
	private final static String weatherGateway = "http://api.openweathermap.org/data/2.5/weather?";
	
	private JSONObject data;
	
	public Weather(IpInfo info) throws MalformedURLException, IOException, NoWeatherDataException {
		this(info.getCity());
	}
	
	public Weather(String city) throws MalformedURLException, IOException, NoWeatherDataException {
		findFromCity(city);
	}
	
	private void findFromZIP(String zipcode) throws MalformedURLException, IOException, NoWeatherDataException {
		data = request(weatherGateway, "zip=" + zipcode, API_KEY);
	}
	
	private void findFromCity(String city) throws MalformedURLException, IOException, NoWeatherDataException {
		data = request(weatherGateway, "q=" + city, API_KEY);
	}
	
	private JSONObject request(String gateway, String request,String apikey) throws MalformedURLException, IOException, NoWeatherDataException {
		JSONObject obj = JsonUtil.getFromURL(weatherGateway + request + "&appid=" + apikey + "&units=metric");
		
		if (obj.has("cod") && obj.getInt("cod")!=200) {
			String message = obj.has("message") ? (" message:" + obj.getString("message")) : "";
			throw new NoWeatherDataException(request + message);
		}
		
		return obj;
	}
	
	public String getTemperature() {
		return data.getJSONObject("main").getString("temp");
	}
}
