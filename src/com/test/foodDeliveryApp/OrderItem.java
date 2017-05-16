package com.test.foodDeliveryApp;

public class OrderItem {

	private String id;
	
	private FoodItem item;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public FoodItem getItem() {
		return item;
	}

	public void setItem(FoodItem item) {
		this.item = item;
	}
	
}
