package me.kvq.weather;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

public class KeyLoader {
	
	private Class<?> clazz;
	private HashMap<String, String> secret = new HashMap<>();
	
	
	public KeyLoader(Class<?> clazz) {
		this.clazz = clazz;
		try {
			readSecret();
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public Optional<String> get(String key) {
		return Optional.ofNullable(secret.get(key));
	}
	
	private void readSecret() throws IOException, URISyntaxException {
		Stream<String> stream = Files.lines(Paths.get(clazz.getClassLoader().getResource("secret.txt").toURI()));
		stream.filter(s->s!=null && !s.isEmpty()).forEach(s -> {
			
				String[] key_value = s.split("=");
				String key = key_value[0], value = key_value[1];
				secret.put(key, value);
				
		});
	}

}
