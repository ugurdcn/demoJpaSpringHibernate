package com.zeygame.demoJpa.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeygame.demoJpa.Business.ICityService;
import com.zeygame.demoJpa.Entities.City;

@RestController
@RequestMapping("/api") // bu apinin root sekmesi
public class CityController {
	private ICityService cityService;

	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/cities")
	public List<City> getAll(){
		return cityService.getAllCity();
	}
	@GetMapping("/cities/{id}")
	public City get(@PathVariable int id) {
		return cityService.getCityById(id); 
	}
	
	@PostMapping("/add")
	public void add(@RequestBody City city) {
		cityService.addCity(city);
	}
	@PostMapping("/update")
	public void update(@RequestBody City city) {
		cityService.update(city);
	}
	@PostMapping("/delete")
	public void delete(@RequestBody City city) {
		cityService.delete(city);
	}
	
	
	
	
}
