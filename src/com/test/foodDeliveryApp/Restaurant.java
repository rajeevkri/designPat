package com.test.foodDeliveryApp;

public class Restaurant {

	private String id;

	private boolean isOpen;

	private String name;

	private Contact contact;

	private RestaurantKitchen kitchen = new RestaurantKitchen();

	private Menu menu = new Menu();

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public void setKitchen(RestaurantKitchen kitchen) {
		this.kitchen = kitchen;
	}

	public RestaurantKitchen getKitchen() {
		return kitchen;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
