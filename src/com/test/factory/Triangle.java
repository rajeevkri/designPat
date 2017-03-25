package com.test.factory;

public class Triangle implements Shape {

	@Override
	public String getAreaCalculationFormula() {
		return "height * base / 2";
	}

	@Override
	public String getName() {
		return "Triangle";
	}

}
