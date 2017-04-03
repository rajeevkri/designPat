package com.test.foodDeliveryApp;

import java.util.List;

public class RestaurantDashboard {

	private Restaurant restaurant;
	
	private RestaurantKitchen kitchen;
	
	public RestaurantDashboard(Restaurant restaurant) {
		this.restaurant = restaurant;
		kitchen = restaurant.getKitchen();
	}
	
	public void addMenuItem(FoodItem item){
		
	}
	
	public void removeMenuItem(FoodItem item){
		
	}
	
	public List<Order> getOrders(){
		return kitchen.getOrders();
	}
	
	public void receiveOrders(Order order) {
		prepareOrder(order);
	}

	public void prepareOrder(Order order) {
		System.out.println("Started preparing food");
		kitchen.prepareFood(order);
	}
	
	public void cancelOrder( Order order) {
		kitchen.cancelCooking(order);
		System.out.println("order is cancelled");
	}
	
	public void notifyUserOrderCompletion(Order order) {
		User user = order.getUser();
		user.getContact().sendNotification("Food is prepared");
		
	}
}
