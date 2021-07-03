package me.kvq.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherApplication {

	private static KeyLoader keyLoader;
	public static void main(String[] args) {
		keyLoader = new KeyLoader(WeatherApplication.class);
		
		SpringApplication.run(WeatherApplication.class, args);
	}
	
	public static KeyLoader getKeyLoader() {
		if (keyLoader==null) keyLoader = new KeyLoader(WeatherApplication.class);
		return keyLoader;
	}

}
