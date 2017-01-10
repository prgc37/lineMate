package org.launchcode.controllers;

import javax.servlet.http.HttpServletRequest;

import org.launchcode.models.Food;
import org.launchcode.models.dao.FoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
public class HomeController extends AbstractController {
	
	@Autowired
	private FoodDao foodDao;

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contactForm() {
		return "contact";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String contact(HttpServletRequest request, Model model) {
		
		//***TODO*** Implement contact
		
		return "contact";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexForm() {
		return "index";
	}
	
//	@RequestMapping(value = "/index", method = RequestMethod.POST)
//	public String index(HttpServletRequest request, Model model) {
//		
//		return "index";
//	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeForm() {
		return "home";
	}
	
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public String home(HttpServletRequest request, Model model) {
//		
//	
//		
//		return "home";
//	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorForm(Model model) {
		Food item = foodDao.findByItem("Orange Soda");
		model.addAttribute("items", item);
		return "error";
	}
	
//	@RequestMapping(value = "/error", method = RequestMethod.POST)
//	public String error(HttpServletRequest request, Model model) {
//		
//	
//		
//		return "error";
//	}
//	
	
	
}
