package org.launchcode.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class HomeController extends AbstractController {

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
	
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String index(HttpServletRequest request, Model model) {
		
		//***TODO*** Implement index
		
		return "index";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeForm() {
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String home(HttpServletRequest request, Model model) {
		
		//***TODO*** Implement home
		
		return "home";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorForm() {
		return "error";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.POST)
	public String error(HttpServletRequest request, Model model) {
		
		//***TODO*** Implement error
		
		return "error";
	}
	
	
	
}
