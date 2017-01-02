package org.launchcode.models;

public class Food {
  
	private final String item;
	private float price;
	private String foodType;
//	private final Image image; https://docs.oracle.com/javase/tutorial/2d/images/
	
	public Food(String item, float price, String type) {
		this.item = item;
		this.price = price;
		this.foodType = type;
		
	}
	
	public String getItem() {
		return this.item;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public String getType() {
		return this.foodType;
	}
	
	
	public String toString() {
		return getItem() + " costs " + getPrice();
	}
	
	
	
	
	
}
