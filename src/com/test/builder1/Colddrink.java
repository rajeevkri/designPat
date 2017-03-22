package com.test.builder1;

/**
 * 
 * @author Rajeev Krishna Singh
 *
 */
public abstract class Colddrink implements Item {

	@Override
	public Packing getPacking() {
		return new Glass();
	}

	
}
