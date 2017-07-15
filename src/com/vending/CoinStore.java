package com.vending;

import java.util.HashMap;
import java.util.Map;

public class CoinStore {
	private Map<Coin, Integer> coinMap = new HashMap<>();

	public int getQuantity(Coin coin) {
		Integer value = coinMap.get(coin);
		return value == null ? 0 : value;
	}

	public void addCoin(Coin coin) {
		int count = coinMap.get(coin);
		coinMap.put(coin, count + 1);
	}

	public void deduct(Coin coin) {
		if (hasCoin(coin)) {
			int count = coinMap.get(coin);
			coinMap.put(coin, count - 1);
		}
	}

	public boolean hasCoin(Coin coin) {
		return getQuantity(coin) > 0;
	}

	public void clear() {
		coinMap.clear();
	}

	public void addCoins(Coin coin, int quantity) {
		coinMap.put(coin, quantity);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		for (Map.Entry<Coin, Integer> entry : coinMap.entrySet()) {
			sb = sb.append("Coin ==> " + entry.getKey() + " quantity " + entry.getValue());
        }

		return "Coin details = [" + sb.toString() + "]";
	}
}
