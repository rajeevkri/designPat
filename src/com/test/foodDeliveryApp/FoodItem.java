package com.test.foodDeliveryApp;

public class FoodItem {

	private String id;
	
	private String name;
	
	private String mrp;
	
	private long expectedPreparationTime;
	
	private boolean isAvailable;

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMrp() {
		return mrp;
	}

	public void setMrp(String mrp) {
		this.mrp = mrp;
	}

	public long getExpectedPreparationTime() {
		return expectedPreparationTime;
	}

	public void setExpectedPreparationTime(long expectedPreparationTime) {
		this.expectedPreparationTime = expectedPreparationTime;
	}
	
}
