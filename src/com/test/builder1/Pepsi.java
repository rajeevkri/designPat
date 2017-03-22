package com.test.builder1;

import java.math.BigDecimal;

public class Pepsi extends Colddrink {

	@Override
	public BigDecimal getPrice() {
		return BigDecimal.valueOf(35.0);
	}

	@Override
	public String getName() {
		return "Pepsi";
	}
}