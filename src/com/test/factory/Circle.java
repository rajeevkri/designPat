package com.test.factory;

public class Circle implements Shape {

	@Override
	public String getAreaCalculationFormula() {
		return "pie * radius * radius";
	}

	@Override
	public String getName() {
		return "Circle";
	}

}
