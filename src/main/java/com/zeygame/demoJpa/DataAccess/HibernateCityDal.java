package com.zeygame.demoJpa.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zeygame.demoJpa.Entities.City;

//JPA - ORM
@Repository
public class HibernateCityDal implements ICityDal{
	private EntityManager entityManager;
	
	//Spring otomatik injection (hibernate) uygular
	@Autowired
	public HibernateCityDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	//Aspect Orianted Programming AOP --- Transaction Open ve Close otomatik ekler
	@Override
	@Transactional
	public List<City> getAllCity() {
		//hibernate
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("from City",City.class).getResultList();
	}
	@Override
	public City getCityByID(int id) {
	  Session session = entityManager.unwrap(Session.class);
	  return session.get(City.class, id);
	}
	
	
	@Override
	public void addCity(City city) {
			//if  id kontrolü ile var olan verinin eklenmesi engellenebilir
		
	
		Session session = entityManager.unwrap(Session.class);
	    //eğer id verilirse günceller id yoksa ekler
		session.saveOrUpdate(city);
	}

	@Override
	public void update(City city) {
		Session session = entityManager.unwrap(Session.class);
	    //eğer id verilirse günceller id yoksa ekler
		session.saveOrUpdate(city);
	}

	@Override
	public void delete(City city) {
		Session session = entityManager.unwrap(Session.class);
		City cityToDelete = session.get(City.class, city.getId());
	    //eğer id verilirse günceller id yoksa ekler
		session.delete(cityToDelete);
	}

	

}
