package me.kvq.weather;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KeyLoaderTest {

	@Test
	void test() {
		
		WeatherApplication application = new WeatherApplication();
		
		KeyLoader key = new KeyLoader(WeatherApplication.class);
		assertTrue(key.get("API_KEY").isPresent());
	}

}
