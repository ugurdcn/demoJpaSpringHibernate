package com.zeygame.demoJpa.Business;

import java.util.List;

import com.zeygame.demoJpa.Entities.City;

public interface ICityService {
	List<City> getAllCity();
	City getCityById(int id);
	void addCity(City city);
	void update(City city);
	void delete(City city);

}
