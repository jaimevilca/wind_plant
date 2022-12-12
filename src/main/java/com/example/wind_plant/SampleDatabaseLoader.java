package com.example.wind_plant;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SampleDatabaseLoader {

	@Autowired 
	private WindPlantRepository plants;
	
	@PostConstruct
	public void init() {
		plants.save(new WindPlant("Madrid"));
		plants.save(new WindPlant("Barcelona"));
	}
}
