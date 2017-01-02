package org.launchcode.models.dao;

import javax.transaction.Transactional;

import org.launchcode.models.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface FoodDao extends CrudRepository<Food, Integer>{

}
