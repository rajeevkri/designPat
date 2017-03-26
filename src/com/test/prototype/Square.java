package com.test.prototype;

public class Square extends Shape {

	@Override
	void draw() {
		System.out.println("drawing square.");
	}

	@Override
	public void setType() {
		this.type = ShapeType.SQUARE;
	}

}
