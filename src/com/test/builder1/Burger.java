package com.test.builder1;

/**
 * 
 * @author Rajeev Krishna Singh
 *
 */
public abstract class Burger implements Item {

	@Override
	public Packing getPacking() {
		return new Wrapper();
	}

}
