package com.test.decorator;

public abstract class ShapeDecorator implements Shape {

	private Shape decoratedShape;
	
	public ShapeDecorator(Shape shape) {
		this.decoratedShape = shape;
	}
	
	@Override
	public void draw() {
		decoratedShape.draw();
	}
}
