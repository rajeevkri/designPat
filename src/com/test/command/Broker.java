package com.test.command;

import java.util.ArrayList;
import java.util.List;

public class Broker {
	private List<Order> orders = new ArrayList<Order>();
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void takeOrder(Order order) {
		orders.add(order);
	}
	
	public void placeOrder(){
		for(Order o:orders) {
			o.execute();
		}
		orders.clear();
	}
}
