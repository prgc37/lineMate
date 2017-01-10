package org.launchcode.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.launchcode.models.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface FoodDao extends CrudRepository<Food, Integer>{

	List<Food> findByType(String type);
	
	List<Food> findAll();
	
	Food findByItem(String item);
}
