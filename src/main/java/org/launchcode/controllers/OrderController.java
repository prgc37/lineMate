package org.launchcode.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.launchcode.models.Food;
import org.launchcode.models.dao.FoodDao;
import org.launchcode.models.dao.OrderDao;
import org.launchcode.models.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController extends AbstractController {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private FoodDao foodDao;
	
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
	
	@RequestMapping(value = "/grill", method = RequestMethod.GET)
	public String grillForm(Model model) {
		List<Food> items = foodDao.findByType("Grill");
		model.addAttribute("items", items);
		return "grill";
	}
	
	@RequestMapping(value = "/grill", method = RequestMethod.POST)
	public String grill(HttpServletRequest request, Model model) {
		return "grill";
	}
	
	@RequestMapping(value = "/SandIC", method = RequestMethod.GET)
	public String SandICForm(Model model) {
		List<Food> items = foodDao.findByType("Snacks and Ice Cream");
		model.addAttribute("items", items);
		return "SandIC";
	}
	
	@RequestMapping(value = "/SandIC", method = RequestMethod.POST)
	public String SandIC(HttpServletRequest request, Model model) {
		
		//***TODO*** Implement SandIC
		
		
		
		return "SandIC";
	}
	
	@RequestMapping(value = "/drinks", method = RequestMethod.GET)
	public String drinksForm(Model model) {
		List<Food> items = foodDao.findByType("Drinks");
		model.addAttribute("items", items);
		return "drinks";
	}
	
	@RequestMapping(value = "/drinks", method = RequestMethod.POST)
	public String drinks(HttpServletRequest request, Model model) {
		
		//***TODO*** Implement drinks

//		boolean itemState;
//		List<Food> items = foodDao.findByType("Drinks");
//		List<Food> orderList = new ArrayList<Food>();
//		for (Food item : items) {
//			if (itemState = request.getParameter("item") != null) {
//				orderList.add(item);
//			}
//		}
//		model.addAttribute("items", orderList);
//		
		
		return "drinks";
	}
	
	@RequestMapping(value = "/SandW", method = RequestMethod.GET)
	public String SandWForm(Model model) {
		List<Food> items = foodDao.findByType("Salads and Wraps");
		model.addAttribute("items", items);
		return "SandW";
	}
	
	@RequestMapping(value = "/SandW", method = RequestMethod.POST)
	public String SandW(HttpServletRequest request, Model model) {
		
		//***TODO*** Implement SandW
		
		
		
		return "SandW";
	}
	
}