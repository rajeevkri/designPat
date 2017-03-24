package com.test.command;

public class Demo {
	public static void main(String[] args) {
		Stock someStock = new Stock();
		
		BuyStockOrder buyOrder = new BuyStockOrder(someStock);
		SellStockOrder sellOrder = new SellStockOrder(someStock);
		
		Broker broker = new Broker();
		broker.takeOrder(buyOrder);
		broker.takeOrder(sellOrder);
		
		broker.placeOrder();
	}
}
