package org.launchcode.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.launchcode.models.Food;
import org.launchcode.models.dao.FoodDao;
//import org.launchcode.models.dao.OrderDao;
//import org.launchcode.models.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController extends AbstractController {
	
//	@Autowired
//	private UserDao userDao;
//	
//	@Autowired
//	private OrderDao orderDao;
//	
	@Autowired
	private FoodDao foodDao;
	
	String orderedEM = "Please select at least one item to proceed with your order";
	String howManyEM = "Please enter the quantity of each item you'd like to order";
	
	//** to access current session ** Session thisSession = request.getSession();
	
	@RequestMapping(value = "/grill", method = RequestMethod.GET)
	public String grillForm(Model model) {
		List<Food> items = foodDao.findByType("Grill");
		model.addAttribute("items", items);
		return "grill";
	}
	
	@RequestMapping(value = "/grill", method = RequestMethod.POST)
	public String grill(HttpServletRequest request, Model model) {
		orderList = getOrderListFromSession(request.getSession());
//		String orderedEM = "Please select at least one item to proceed with your order";
		String[] grillOrder = request.getParameterValues("ordered");
		if(grillOrder != null) {
			for(String item: grillOrder) {
			Food checkedItem = foodDao.findByItem(item);
				if(!orderList.contains(checkedItem)) {
					orderList.add(checkedItem);
				}
			}
		} else {
			model.addAttribute("orderedEM", orderedEM);
			return "order";
		}
		model.addAttribute("items", orderList);
		model.addAttribute("total", orderSubTotal);
		model.addAttribute("numberOfItems", numberOfItems);
		return "order";
	}
	
	@RequestMapping(value = "/SandIC", method = RequestMethod.GET)
	public String SandICForm(Model model) {
		List<Food> items = foodDao.findByType("Snacks and Ice Cream");
		model.addAttribute("items", items);
		return "SandIC";
	}
	
	@RequestMapping(value = "/SandIC", method = RequestMethod.POST)
	public String SandIC(HttpServletRequest request, Model model) {
		orderList = getOrderListFromSession(request.getSession());
//		String orderedEM = "Please select at least one item to proceed with your order";
		String[] SandICOrder = request.getParameterValues("ordered");
		if(SandICOrder != null) {
			for(String item: SandICOrder) {
			Food checkedItem = foodDao.findByItem(item);
				if(!orderList.contains(checkedItem)) {
					orderList.add(checkedItem);
				}
			}
		} else {
			model.addAttribute("orderedEM", orderedEM);
			return "order";
		}
		model.addAttribute("items", orderList);
		model.addAttribute("total", orderSubTotal);
		model.addAttribute("numberOfItems", numberOfItems);
		return "order";
	}
	
	@RequestMapping(value = "/drinks", method = RequestMethod.GET)
	public String drinksForm(Model model) {
		List<Food> items = foodDao.findByType("Drinks");
		model.addAttribute("items", items);
		return "drinks";
	}
	
	@RequestMapping(value = "/drinks", method = RequestMethod.POST)
	public String drinks(HttpServletRequest request, Model model) {
		orderList = getOrderListFromSession(request.getSession());
//		String orderedEM = "Please select at least one item to proceed with your order";
		String[] drinksOrder = request.getParameterValues("ordered");
		if(drinksOrder != null) {
			for(String item: drinksOrder) {
			Food checkedItem = foodDao.findByItem(item);
				if(!orderList.contains(checkedItem)) {
					orderList.add(checkedItem);
				}
			}
		} else {
			model.addAttribute("orderedEM", orderedEM);
			return "order";
		}
		model.addAttribute("items", orderList);
		model.addAttribute("total", orderSubTotal);
		model.addAttribute("numberOfItems", numberOfItems);
		return "order";
	}
	
	@RequestMapping(value = "/SandW", method = RequestMethod.GET)
	public String SandWForm(Model model) {
		List<Food> items = foodDao.findByType("Salads and Wraps");
		model.addAttribute("items", items);
		return "SandW";
	}
	
	@RequestMapping(value = "/SandW", method = RequestMethod.POST)
	public String SandW(HttpServletRequest request, Model model) {
		orderList = getOrderListFromSession(request.getSession());
//		String orderedEM = "Please select at least one item to proceed with your order";
		String[] SandWOrder = request.getParameterValues("ordered");
		if(SandWOrder != null) {
			for(String item: SandWOrder) {
			Food checkedItem = foodDao.findByItem(item);
				if(!orderList.contains(checkedItem)) {
					orderList.add(checkedItem);
				}
			}
		} else {
			model.addAttribute("orderedEM", orderedEM);
			return "order";
		}
		model.addAttribute("items", orderList);
		model.addAttribute("total", orderSubTotal);
		model.addAttribute("numberOfItems", numberOfItems);
		return "order";
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String orderForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		orderList = getOrderListFromSession(session);
		for(Food item : orderList) {
			BigDecimal itemTotal = item.getPrice();
			numberOfItems += 1; // ***TODO*** add javascript, jquery, etc to display dynamic numberOfItems and orderSubTotal
			orderSubTotal = orderSubTotal.add(itemTotal);
		}
		model.addAttribute("items", orderList);
		model.addAttribute("numberOfItems", numberOfItems);
		model.addAttribute("subTotal", orderSubTotal);
		return "order";
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String order(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		orderList = getOrderListFromSession(session);
//		String howManyEM = "Please enter the quantity you'd like to order";
		for(Food item : orderList) {
			String howManyString = request.getParameter("howMany");
			String notes = request.getParameter("notes");
			if(howManyString != null && howManyString != "") {
				howManyString.trim();
				
			} else {
				model.addAttribute("howManyEM", howManyEM);
				return "checkout";
			}
			
			int howManyInt = Integer.parseInt(howManyString);		
			BigDecimal howMany = new BigDecimal(howManyInt);
						
//			try {
//				howManyInt = Integer.parseInt(howManyString); 
//			} catch (NumberFormatException e) {
//				e.printStackTrace();
//			}
			
			BigDecimal itemTotal = item.getPrice().multiply(howMany);
			numberOfItems += howManyInt;
			orderSubTotal = orderSubTotal.add(itemTotal);
			model.addAttribute("quantity", howMany);
			model.addAttribute("notes", notes);
			
		}
		BigDecimal taxRateBD = BigDecimal.valueOf(taxRate);
		BigDecimal tax = orderSubTotal.multiply(taxRateBD);
		tax = tax.setScale(2, RoundingMode.CEILING);
		BigDecimal total = orderSubTotal.add(tax);
		
		model.addAttribute("items", orderList);
		model.addAttribute("subTotal", orderSubTotal);
		model.addAttribute("tax", tax);
		model.addAttribute("numberOfItems", numberOfItems);
		model.addAttribute("total", total);
		
		return "checkout";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkoutForm(HttpServletRequest request, Model model) {
		orderList = getOrderListFromSession(request.getSession());
		List<Food> items = new ArrayList<Food>();
//		for(String item : orderList) {
//			Food listItem = foodDao.findByItem(item);
//			items.add(listItem);
//		}
		BigDecimal taxRateBD = BigDecimal.valueOf(taxRate);
		BigDecimal tax = orderSubTotal.multiply(taxRateBD);
		tax = tax.setScale(2, RoundingMode.CEILING);
		BigDecimal total = orderSubTotal.add(tax);
		
		model.addAttribute("numberOfItems", numberOfItems);
		model.addAttribute("subtotal", orderSubTotal);
		model.addAttribute("tax", tax);
		model.addAttribute("total", total);
		model.addAttribute("items", items);	
		
		return "checkout";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkout(HttpServletRequest request, Model model) {
		
		//***TODO*** Implement orderSummary
		
		return "orderSummary";
	}
	
	@RequestMapping(value = "/orderSummary", method = RequestMethod.GET)
	public String orderSummary(HttpServletRequest request, Model model) {
		
		//***TODO*** Implement orderSummary
		
		return "orderSummary";
	}
	
	
	
	
}