package com.zeygame.demoJpa.DataAccess;

import java.util.List;
import com.zeygame.demoJpa.Entities.City;

public interface ICityDal {
	List<City> getAllCity();
	City getCityByID(int id);
	void addCity(City city);
	void update(City city);
	void delete(City city);
}
