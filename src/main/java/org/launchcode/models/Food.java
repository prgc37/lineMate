package org.launchcode.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "food")
public class Food extends AbstractEntity {
  
	public String item;
	public String description;
	public BigDecimal price;
	public String foodType;
//	private final Image image; https://docs.oracle.com/javase/tutorial/2d/images/
	
	
	public Food(String item, String description, BigDecimal price, String type) {
		
		super();
		
		this.item = item;
		this.description = description;
		this.price = price;
		this.foodType = type;
		
	}
	
	public Food() {}
	
	@NotNull
	@Column(name = "item", unique = true)
	public String getItem() {
		return this.item;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@NotNull
	@Column(name = "price")
	public BigDecimal getPrice() {
		return this.price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@NotNull
	@Column(name = "type")
	public String getType() {
		return this.foodType;
	}
	
	public void setType(String type) {
		this.foodType = type;
	}
	
	public String toString() {
		return getItem() + " costs " + getPrice();
	}
	
	
	
	
	
}
