package com.zeygame.demoJpa.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeygame.demoJpa.DataAccess.ICityDal;
import com.zeygame.demoJpa.Entities.City;

@Service //iş katmanı olduğunu belirtir
public class CityManager implements ICityService {

	private ICityDal cityDal;
	
	@Autowired
	public CityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}

	@Override
	@Transactional
	public List<City> getAllCity() {
		// TODO Auto-generated method stub
		return this.cityDal.getAllCity();
	}
	@Override
	@Transactional
	public City getCityById(int id) {
		return this.cityDal.getCityByID(id);
	}
	@Override
	@Transactional
	public void addCity(City city) {
		
		// Kontroller eklenebilir	Örn: var mı? name boş mu?
		this.cityDal.addCity(city);		
	}

	@Override
	@Transactional
	public void update(City city) {
		this.cityDal.update(city);
	}

	@Override
	@Transactional
	public void delete(City city) {
		this.cityDal.delete(city);
	}

	

}
