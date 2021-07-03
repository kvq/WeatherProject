package me.kvq.weather.exceptions;

public class NoWeatherDataException extends Exception {

	private static final long serialVersionUID = 3342065293333106591L;
	
	public NoWeatherDataException(String raw) {
		super("Unable to get weather for " + raw);
	}

}
