package org.launchcode.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.launchcode.models.User;
import org.launchcode.models.dao.OrderDao;
import org.launchcode.models.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController {

	@Autowired
    protected UserDao userDao;
	
	@Autowired
	protected OrderDao orderDao;
	
	public ArrayList<String> orderList;

    public static final String userSessionKey = "user_id";

    protected User getUserFromSession(HttpSession session) {
    	
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findByUid(userId);
    }
    
    protected void setUserInSession(HttpSession session, User user) {
    	session.setAttribute(userSessionKey, user.getUid());
    }
    
    protected void setOrderListInSession(HttpSession session) {
    	ArrayList<String> orderList = new ArrayList<String>();
    	session.setAttribute("orderList", orderList);
    }
	
}