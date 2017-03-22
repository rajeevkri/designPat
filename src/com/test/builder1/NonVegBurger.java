package com.test.builder1;

import java.math.BigDecimal;

public class NonVegBurger extends Burger {

	@Override
	public String getName() {
		return "nonvegburger";
	}

	@Override
	public BigDecimal getPrice() {
		return BigDecimal.valueOf(4.3);
	}

}
