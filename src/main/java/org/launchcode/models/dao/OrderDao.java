package org.launchcode.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.launchcode.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface OrderDao extends CrudRepository<Order, Integer>{

	List<Order> findByCustomer(int customerId);
	
	List<Order> findAll();
	
	Order findByUid(int uid);
	
	// TODO - add method signatures as needed
}
