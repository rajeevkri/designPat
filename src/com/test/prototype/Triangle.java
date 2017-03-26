package com.test.prototype;

public class Triangle extends Shape {

	@Override
	void draw() {
		System.out.println("drawing triangle.");
	}

	@Override
	public void setType() {
		this.type = ShapeType.TRIANGLE;
	}

}
