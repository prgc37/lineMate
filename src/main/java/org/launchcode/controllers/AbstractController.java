package org.launchcode.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.launchcode.models.User;
import org.launchcode.models.dao.OrderDao;
import org.launchcode.models.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.launchcode.models.Food;

public abstract class AbstractController {

	@Autowired
    protected UserDao userDao;
	
	@Autowired
	protected OrderDao orderDao;
	
	public ArrayList<Food> orderList;
	public static BigDecimal orderSubTotal = new BigDecimal(0.00);
	public static int numberOfItems = 0;
	public double taxRate = 0.0956;

    public static final String userSessionKey = "user_id";

    protected User getUserFromSession(HttpSession session) {
    	
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findByUid(userId);
    }
    
    protected void setUserInSession(HttpSession session, User user) {
    	session.setAttribute(userSessionKey, user.getUid());
    }
    
    protected void initOrderListInSession(HttpSession session) {
    	orderList = new ArrayList<Food>();
    	session.setAttribute("orderList", orderList);
    }
	
    @SuppressWarnings("unchecked")
    protected ArrayList<Food> getOrderListFromSession(HttpSession session) {
    	return (ArrayList<Food>) session.getAttribute("orderList");
    }
    
    protected void initOrderSubTotalInSession(HttpSession session) {
    	session.setAttribute("orderSubTotal", orderSubTotal);
    }
    
    protected BigDecimal getOrderSubTotalFromSession(HttpSession session) {
    	return (BigDecimal) session.getAttribute("orderSubTotal");
    }
    
    protected void setOrderSubTotalInSession(HttpSession session, BigDecimal orderSubTotal) {
    	session.setAttribute("orderSubTotal", orderSubTotal);
    }
    
    protected void resetOrderSubTotalInSession(HttpSession session) {
    	session.setAttribute("orderSubTotal", 0.00);
    }
    
    protected void initNumberOfItemsInSession(HttpSession session) {
    	session.setAttribute("numberOfItems", numberOfItems);
    }
    
    protected int getNumberOfItemsFromSession(HttpSession session) {
    	return (int) session.getAttribute("numberOfItems");
    }
    
    protected void setNumberOfItemsInSession(HttpSession session, int numberOfItems) {
    	session.setAttribute("numberOfItems", numberOfItems);
    }
    
    protected void resetNumberOfItemsInSession(HttpSession session) {
    	session.setAttribute("numberOfItems", 0);
    }
    
    
    protected double getTaxRateFromSession(HttpSession session) {
    	return (double) session.getAttribute("taxRate");
    }
    
    protected void initTaxRateInSession(HttpSession session) {
    	session.setAttribute("taxRate", taxRate);
    }
    
}