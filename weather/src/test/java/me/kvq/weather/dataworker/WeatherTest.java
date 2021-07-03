package me.kvq.weather.dataworker;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import me.kvq.weather.exceptions.NoWeatherDataException;

class WeatherTest {
	


	@Test
	void test() throws MalformedURLException, IOException, NoWeatherDataException {
		Weather weather = new Weather("London");
		assertNotNull(weather.getTemperature());
	}

}
