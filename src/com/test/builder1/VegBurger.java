package com.test.builder1;

import java.math.BigDecimal;

public class VegBurger extends Burger {

	@Override
	public String getName() {
		return "vegburger";
	}

	@Override
	public BigDecimal getPrice() {
		return BigDecimal.valueOf(2.3);
	}

}
