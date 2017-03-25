package com.test.factory;

public class Square implements Shape {

	@Override
	public String getAreaCalculationFormula() {
		return "dimension * dimension";
	}

	@Override
	public String getName() {
		return "Square";
	}

}
