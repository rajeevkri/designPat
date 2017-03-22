package com.test.builder1;

import java.math.BigDecimal;

public class Coke extends Colddrink {

	@Override
	public BigDecimal getPrice() {
		return BigDecimal.valueOf(30.0);
	}

	@Override
	public String getName() {
		return "Coke";
	}
}