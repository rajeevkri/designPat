package com.vending;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasicVendingMachine implements IVendingMachine {

	private CoinStore cashInventory = new CoinStore();
	private ItemInventory itemInventory = new ItemInventory();
	private long totalSales;
	private Item currentItem;
	private long currentBalance;

	public BasicVendingMachine() {
		// initialize machine with 5 coins of each denomination
		// and 5 cans of each Item
		for (Coin c : Coin.values()) {
			cashInventory.addCoins(c, 5);
		}
		for (Item i : Item.initialValues()) {
			itemInventory.updateQuantity(i, 5);
		}
	}

	@Override
	public void addItem(String name, int price, int quantity) {
		Item item = new Item(name, price);
		itemInventory.updateQuantity(item, quantity);
	}

	@Override
	public void setPrice(String name, int price) {
		Item item = new Item(name, price);
		int quantity = itemInventory.getQuantity(item);
		itemInventory.removeItem(item);
		itemInventory.updateQuantity(item, quantity);
	}

	@Override
	public void changeQuantity(String name, int newQuantity) {
		Item item = new Item(name);
		itemInventory.updateQuantity(item, newQuantity);
	}
	
	@Override
	public long getItemPrice(Item item, int quantity) {
		if (itemInventory.hasItem(item)) {
			int existingQuantity = itemInventory.getQuantity(item);
			if(existingQuantity < quantity) {
				throw new InSufficientInventoryException("Only " +existingQuantity +" of item available with name " +item.getName());
			}
			currentItem = item;
			return quantity * currentItem.getPrice();
		}
		throw new NotAvailableException("Sold Out, Please buy another item");
	}

	@Override
	public void insertCoin(Coin coin) {
		currentBalance = currentBalance + coin.getValue();
		cashInventory.addCoin(coin);
	}

	@Override
	public Container<Item, List<Coin>> collectItemAndChange(int quantity) {
		Item item = collectItem(quantity);
		totalSales = totalSales + quantity *currentItem.getPrice();

		List<Coin> change = collectChange(quantity);

		return new Container<Item, List<Coin>>(item, change);
	}

	private Item collectItem(int quantity) throws InSufficientChangeException, NotFullPaidException {
		if (isFullPaid()) {
			if (hasSufficientChange(quantity)) {
				itemInventory.decreaseQuantity(currentItem, quantity);
				return currentItem;
			}
			throw new InSufficientChangeException("Not Sufficient change in Inventory");

		}
		long remainingBalance = currentItem.getPrice() - currentBalance;
		throw new NotFullPaidException("Price not full paid, remaining : ", remainingBalance);
	}

	private List<Coin> collectChange(int quantity) {
		long changeAmount = currentBalance - quantity * currentItem.getPrice();
		List<Coin> change = getChange(changeAmount);
		updateCashInventory(change);
		currentBalance = 0;
		currentItem = null;
		return change;
	}

	@Override
	public List<Coin> refund() {
		List<Coin> refund = getChange(currentBalance);
		updateCashInventory(refund);
		currentBalance = 0;
		currentItem = null;
		return refund;
	}

	private boolean isFullPaid() {
		if (currentBalance >= currentItem.getPrice()) {
			return true;
		}
		return false;
	}

	private List<Coin> getChange(long amount) {
		List<Coin> changes = Collections.EMPTY_LIST;

		if (amount > 0) {
			changes = new ArrayList<Coin>();
			long balance = amount;
			while (balance > 0) {
				if (balance >= Coin.TEN.getValue() && cashInventory.hasCoin(Coin.TEN)) {
					changes.add(Coin.TEN);
					balance = balance - Coin.TEN.getValue();
					continue;

				} else if (balance >= Coin.FIVE.getValue() && cashInventory.hasCoin(Coin.FIVE)) {
					changes.add(Coin.FIVE);
					balance = balance - Coin.FIVE.getValue();
					continue;

				} else if (balance >= Coin.ONE.getValue() && cashInventory.hasCoin(Coin.ONE)) {
					changes.add(Coin.ONE);
					balance = balance - Coin.ONE.getValue();
					continue;

				} else {
					System.out.println("Not Sufficient Change Please try another product");
					throw new InSufficientChangeException("Not Sufficient Change Please try another product");
				}
			}
		}

		return changes;
	}

	@Override
	public void reset() {
		cashInventory.clear();
		itemInventory.clear();
		totalSales = 0;
		currentItem = null;
		currentBalance = 0;
	}

	public void printStats() {
		System.out.println("Total Sales : " + totalSales);
		System.out.println("Current Item Inventory : " + itemInventory);
		System.out.println("Current Cash Inventory : " + cashInventory);
	}

	private boolean hasSufficientChange(int quantity) {
		return hasSufficientChangeForAmount(currentBalance - quantity *currentItem.getPrice());
	}

	private boolean hasSufficientChangeForAmount(long amount) {
		boolean hasChange = true;
		try {
			getChange(amount);
		} catch (InSufficientChangeException nsce) {
			return hasChange = false;
		}

		return hasChange;
	}

	private void updateCashInventory(List<Coin> change) {
		for (Coin c : change) {
			cashInventory.deduct(c);
		}
	}

	public long getTotalSales() {
		return totalSales;
	}

	public boolean hasItem(Item item) {
		return itemInventory.hasItem(item);
	}

}
