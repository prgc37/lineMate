package org.launchcode.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.launchcode.models.User;
import org.launchcode.models.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController extends AbstractController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupForm() {
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(HttpServletRequest request, Model model) {
		
		//***DONE***- implement signup
		//get parameters from request
		//validate parameters (username, password, verify)
		//if good, create a new user and put their uid in the session
		//** to access current session ** Session thisSession = request.getSession();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String verify = request.getParameter("verify");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		if(!User.isValidUsername(username)){
			//ERROR MESSAGE
			String username_error = "Please enter a valid username";
			model.addAttribute("username_error", username_error);
			return "signup";
		} 
		else{
			if(!User.validateEmail(email)) {
				String email_error = "Please enter a valid email address";
				model.addAttribute("username", username);
				model.addAttribute("email_error", email_error);
				return "signup";
			}
			else{
				if(!User.validatePhone(phone)) {
					String phone_error = "Please enter a valid 10 digit mobile phone number";
					model.addAttribute("username", username);
					model.addAttribute("email", email);
					model.addAttribute("phone_error", phone_error);
					return "signup";
				}
				else{
					if(!User.isValidPassword(password)) {
						//ERROR MESSAGE
						String password_error = "Please enter a valid password";
						model.addAttribute("password_error", password_error);
						model.addAttribute("username", username);
						model.addAttribute("email", email);
						model.addAttribute("phone", phone);
						return "signup";
					} 
					else{
						if(!password.equals(verify)) {
							//ERROR MESSAGE
							String verify_error = "Please make sure your password and password verification match";
							model.addAttribute("verify_error", verify_error);
							model.addAttribute("username", username);
							model.addAttribute("email", email);
							model.addAttribute("phone", phone);
							model.addAttribute("pwhash", password);
							return "signup";
						}
						else{		
							User user = new User(username, password, email, phone);
							userDao.save(user);
							model.addAttribute("username", username);
							model.addAttribute("pwhash", password);
							loginHelper(request, user);
							return "redirect:/";
						}
					}
				}
			}	
		}
//		
//		if(User.isValidUsername(username) && User.isValidPassword(password) && password.equals(verify)){
//			User user = new User(username, password);
//			userDao.save(user);
//			model.addAttribute("username", username);
//			model.addAttribute("pwhash", password);
//			loginHelper(request, user);
//			return "redirect:blog/newpost";
//		}
//		else
//			return "redirect:/signup";
	}
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) {
		
		// ***DONE***- implement login
		// get parameters from request
		// get user by their username
		// check password
		// if good, log in (put their uid in the current session)
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = userDao.findByUsername(username);
		
		if(user == null){
			String error = "Please enter a valid username or create a new account";
			model.addAttribute("error", error);
			return "login";
		} else if(!user.getPwHash().equals(User.hashPassword(password))){
			String error = "Please enter a valid password for the selected user";
			model.addAttribute("error", error);
			model.addAttribute("username", username);
			return "login";
		} else
			loginHelper(request, user);
			return "redirect:/";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
        request.getSession().invalidate();
		return "redirect:/";
	}
	
	public void loginHelper(HttpServletRequest request, User user){
		HttpSession session = request.getSession();
		setUserInSession(session, user);
		}
}