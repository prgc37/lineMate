package org.launchcode.controllers;

import javax.servlet.http.HttpServletRequest;

import org.launchcode.models.dao.OrderDao;
import org.launchcode.models.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class OrderController extends AbstractController {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String orderForm() {
		return "order";
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String order(HttpServletRequest request, Model model) {
		
		//***TODO*** Implement Order
		
		return "order";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkoutForm() {
		return "checkout";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkout(HttpServletRequest request, Model model) {
		
		//***TODO*** Implement checkout
		
		return "checkout";
	}
	
	//***DONE***- implement signup
	//get parameters from request
	//validate parameters (username, password, verify)
	//if good, create a new user and put their uid in the session
	//** to access current session ** Session thisSession = request.getSession();
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menuForm() {
		return "menu";
	}
	
	@RequestMapping(value = "/menu", method = RequestMethod.POST)
	public String menu(HttpServletRequest request, Model model) {
		
		//***TODO*** Implement menu
		
		
		
		return "menu";
	}
	
}