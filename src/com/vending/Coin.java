package com.vending;

public enum Coin {
	ONE(1), FIVE(5), TEN(10);

	private int value;

	private Coin(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
