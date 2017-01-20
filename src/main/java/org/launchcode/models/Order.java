package org.launchcode.models;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Items")
public class Order extends AbstractEntity {

	private double total;
	private User customer;
	private Date created;
	private HashMap<String, Food> listOfItems;
	private int numberOfItems;
	private String notes;


	public Order() {}

	public Order(User customer, int numberOfItems, HashMap<String, Food> listOfItems, String notes, double total){
	
	super();
	
	this.customer = customer;
	this.numberOfItems = numberOfItems;
	this.listOfItems = listOfItems;
	this.notes = notes;
	this.total = total;
	this.created = new Date();

	}
	
	@ManyToOne
	public User getCustomer() {
		return this.customer;
	}
	
	@SuppressWarnings("unused")
	private void setCustomer(User customer) {
		this.customer = customer;
	}
	
	@NotNull
	@Column(name = "numOfItems")
	public int getNumberItems() {
		return this.numberOfItems;
	}
	
	@SuppressWarnings("unused")
	private void setNumberItems(int number) {
		this.numberOfItems = number;
	}
	
	@NotNull
	@Column(name = "listItems")
	public HashMap<String, Food> getListFood() {
		return this.listOfItems;
	}
	
	
	@SuppressWarnings("unused")
	private void setListFood(HashMap<String, Food> list) {
		this.listOfItems = list;
	}
	
	@Column(name = "notes")
	public String getNotes() {
		return this.notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	@NotNull
	@Column(name = "total")
	public double getTotal() {
		return this.total;
	}
	
	
	@SuppressWarnings("unused")
	private void setTotal(double total) {
		this.total = total;
	}
	@NotNull
	@OrderColumn
	@Column(name = "created")
	public Date getCreated() {
		return this.created;
	}
	
	@SuppressWarnings("unused")
	private void setCreated(Date created) {
		this.created = created;
	}
	
	
}
