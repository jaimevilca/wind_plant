package com.example.wind_plant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.Optional;

@Controller
public class WindPlantController {

	@Autowired
	private WindPlantRepository windPlant;

	@QueryMapping
	public Collection<WindPlant> windPlants() {
		return windPlant.findAll();
	}

	@QueryMapping
	public Optional<WindPlant> windPlant(@Argument long id) {
		return windPlant.findById(id);
	}

	@MutationMapping
	public WindPlant createWindPlant(@Argument WindPlant windPlant) {

		this.windPlant.save(windPlant);

		return windPlant;
	}

	@MutationMapping
	public WindPlant replaceWindPlant(@Argument long id, @Argument WindPlant windPlant) {

		this.windPlant.findById(id).orElseThrow();
		
		windPlant.setId(id);
		this.windPlant.save(windPlant);
		
		return windPlant;
	}

	@MutationMapping
	public WindPlant deleteWindPlant(@Argument long id) {

		WindPlant windPlant = this.windPlant.findById(id).orElseThrow();

		this.windPlant.deleteById(id);
		
		return windPlant;
	}
}
