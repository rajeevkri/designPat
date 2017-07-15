package com.vending;

import java.util.ArrayList;
import java.util.List;

public class Item {
	private String name;
	private int price;

	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public Item(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public long getPrice() {
		return price;
	}

	public static List<Item> initialValues() {
		List<Item> items = new ArrayList<>();
		
		items.add(getSoda());
		items.add(getPepsi());
		items.add(getCoke());
		return items;
	}
	
	public static Item getCoke() {
		Item coke = new Item("Coke", 25);
		return coke;
	}

	public static Item getPepsi() {
		Item pepsi = new Item("Pepsi", 35);
		return pepsi;
	}

	public static Item getSoda() {
		Item soda = new Item("Soda", 45);
		return soda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + "]";
	}

}
