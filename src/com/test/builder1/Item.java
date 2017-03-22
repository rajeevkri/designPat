package com.test.builder1;

import java.math.BigDecimal;

/**
 * 
 * @author Rajeev Krishna Singh
 *
 */
public interface Item {

	public String getName();
	
	public Packing getPacking();
	
	public BigDecimal getPrice();
}
