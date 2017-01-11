package org.launchcode.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

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
	
	public static float orderSubTotal = 0;
	public static int numberOfItems = 0;
	public static double taxRate = 9.56;
	
	//** to access current session ** Session thisSession = request.getSession();
	
	@RequestMapping(value = "/grill", method = RequestMethod.GET)
	public String grillForm(Model model) {
		List<Food> items = foodDao.findByType("Grill");
		System.out.println(items.toString());
		model.addAttribute("items", items);
		return "grill";
	}
	
	@RequestMapping(value = "/grill", method = RequestMethod.POST)
	public String grill(HttpServletRequest request, Model model) {
		String[] grillOrder = request.getParameterValues("ordered");
		for(String item: grillOrder) {
			orderList.add(item);
		}
		return "redirect:order";
	}
	
	@RequestMapping(value = "/SandIC", method = RequestMethod.GET)
	public String SandICForm(Model model) {
		List<Food> items = foodDao.findByType("Snacks and Ice Cream");
		model.addAttribute("items", items);
		return "SandIC";
	}
	
	@RequestMapping(value = "/SandIC", method = RequestMethod.POST)
	public String SandIC(HttpServletRequest request, Model model) {
		String[] SandICOrder = request.getParameterValues("ordered");
		for(String item: SandICOrder) {
			orderList.add(item);
		}
		return "redirect:order";
	}
	
	@RequestMapping(value = "/drinks", method = RequestMethod.GET)
	public String drinksForm(Model model) {
		List<Food> items = foodDao.findByType("Drinks");
		model.addAttribute("items", items);
		return "drinks";
	}
	
	@RequestMapping(value = "/drinks", method = RequestMethod.POST)
	public String drinks(HttpServletRequest request, Model model) {
		String[] drinksOrder = request.getParameterValues("ordered");
		for(String item : drinksOrder) {
			orderList.add(item);
		}
		return "redirect:order";
	}
	
	@RequestMapping(value = "/SandW", method = RequestMethod.GET)
	public String SandWForm(Model model) {
		List<Food> items = foodDao.findByType("Salads and Wraps");
		model.addAttribute("items", items);
		return "SandW";
	}
	
	@RequestMapping(value = "/SandW", method = RequestMethod.POST)
	public String SandW(HttpServletRequest request, Model model) {
		String[] SandWOrder = request.getParameterValues("ordered");
		for(String item : SandWOrder) {
			orderList.add(item);
		}
		return "redirect:order";
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String orderForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		ArrayList<String> orderList = (ArrayList<String>) session.getAttribute("orderList");
		List<Food> items = new ArrayList<Food>();
		for(String item : orderList) {
			Food listItem = foodDao.findByItem(item);
			items.add(listItem);
		}
		model.addAttribute("items", items);
		return "order";
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String order(HttpServletRequest request, Model model) {
		//***TODO*** Implement Order
		String howManyString = request.getParameter("howMany");
		int howMany = 1;
		try {
			howMany = Integer.parseInt(howManyString);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			
		}
		
		for(String item : orderList) {
			Food checkedItem = foodDao.findByItem(item);
			float itemTotal = checkedItem.getPrice() * howMany;
			numberOfItems += howMany;
			orderSubTotal += itemTotal;
		}
		model.addAttribute("items", orderList);
		model.addAttribute("total", orderSubTotal);
		model.addAttribute("numberOfItems", numberOfItems);
		
		return "order";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkoutForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		ArrayList<String> orderList = (ArrayList<String>) session.getAttribute("orderList");
		List<Food> items = new ArrayList<Food>();
		for(String item : orderList) {
			Food listItem = foodDao.findByItem(item);
			items.add(listItem);
		}
		double tax = taxRate * orderSubTotal;
		double total = tax + orderSubTotal;
		
		model.addAttribute("numberOfItems", numberOfItems);
		model.addAttribute("subtotal", orderSubTotal);
		model.addAttribute("tax", tax);
		model.addAttribute("total", total);
		model.addAttribute("items", items);	
		
		return "checkout";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkout(HttpServletRequest request, Model model) {
		
		//***TODO*** Implement checkout
		
		return "checkout";
	}
	
	
}