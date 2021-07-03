package me.kvq.weather.dataworker;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.jupiter.api.Test;

class IpInfoTest {

	@Test
	void test() throws MalformedURLException, IOException {
		IpInfo info = new IpInfo("1.1.1.1");
		assertNotNull(info.getCity());
		assertNotNull(info.getCountry());
		assertNotNull(info.getZIP());
	}

}
