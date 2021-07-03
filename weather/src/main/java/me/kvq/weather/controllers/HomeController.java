package me.kvq.weather.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import me.kvq.weather.dataworker.IpInfo;
import me.kvq.weather.dataworker.Weather;
import me.kvq.weather.exceptions.NoWeatherDataException;

@Controller
public class HomeController {
	
	@GetMapping("/redirect")
	public String redirector(HttpServletRequest request,Model model) {
		
		return "redirect:https://" + request.getParameter("to");
	}
	
	@GetMapping("/")
	public String getWeatherPage(HttpServletRequest request,Model model) {
		
		String ip = request.getRemoteAddr();
		
		try {
			IpInfo info = new IpInfo(ip);
			Weather weather = new Weather(info);
			
			
			model.addAttribute("weather", weather.getTemperature() + " ℃ | " +info.getCountry() + " " + info.getCity() + " " + info.getZIP());
		} catch (IOException | NoWeatherDataException e) {
			e.printStackTrace();
			
			model.addAttribute("weather","An error has occured");
		}
		
		
		return "home";
	}
	
	
}
