package com.test.prototype;

public class Circle extends Shape {

	@Override
	void draw() {
		System.out.println("drawing circle.");
	}

	@Override
	public void setType() {
		this.type = ShapeType.CIRCLE;
	}

}
