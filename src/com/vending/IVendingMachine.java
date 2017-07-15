package com.vending;

import java.util.List;

public interface IVendingMachine {
	public void addItem(String name, int price, int quantity);

	public void setPrice(String name, int price);

	public void changeQuantity(String name, int newQuantity);

	public long getItemPrice(Item item, int quantity);

	public void insertCoin(Coin coin);

	public List<Coin> refund();

	public Container<Item, List<Coin>> collectItemAndChange(int quantity);

	public void reset();

	public void printStats();

}
