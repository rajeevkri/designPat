package com.vending;

import java.util.HashMap;
import java.util.Map;

public class ItemInventory {
	private Map<Item, Integer> inventoryMap = new HashMap<>();

	public int getQuantity(Item item) {
		Integer value = inventoryMap.get(item);
		return value == null ? 0 : value;
	}

	public void addItem(Item item) {
		int count = inventoryMap.get(item);
		inventoryMap.put(item, count + 1);
	}

	public void decreaseQuantity(Item item, int quantity) {
		if (hasItem(item)) {
			int count = inventoryMap.get(item);
			inventoryMap.put(item, count - quantity);
		}
	}

	public boolean hasItem(Item item) {
		return getQuantity(item) > 0;
	}

	public void clear() {
		inventoryMap.clear();
	}

	public void updateQuantity(Item item, int quantity) {
		inventoryMap.put(item, quantity);
	}

	public void removeItem(Item item) {
		inventoryMap.remove(item);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		for (Map.Entry<Item, Integer> entry : inventoryMap.entrySet()) {
			sb = sb.append("Item ==> " + entry.getKey() + " quantity " + entry.getValue());
        }

		return "ItemInventory = [" + sb.toString() + "]";
	}
	
	
}
