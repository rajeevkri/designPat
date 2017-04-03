package com.test.foodDeliveryApp;

import java.util.ArrayList;
import java.util.List;

public class RestaurantKitchen {
	Restaurant restaurant = new Restaurant();
	RestaurantDashboard restaurantDashboard = new RestaurantDashboard(restaurant);
	
	List<Order> orders = new ArrayList<>();

	public List<Order> getOrders() {
		return orders;
	}

	public void prepareFood(Order order) {
		orders.add(order);
		System.out.println("preparing food" + order.getId());
	}

	public void foodPrepared(Order order) {
		System.out.println("Food is prepared for order " + order.getId());
		orders.remove(order);
		restaurantDashboard.notifyUserOrderCompletion(order);
	}

	public void cancelCooking(Order order) {
		System.out.println("Cancelling order " + order.getId());
		orders.remove(order);
	}
}
