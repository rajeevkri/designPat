package com.test.decorator;

public class RedShapeDecorator extends ShapeDecorator {

	
	public RedShapeDecorator(Shape shape) {
		super(shape);
	}

	@Override
	public void draw() {
		super.draw();
		setBorder(decoratedShape);
	}

	private void setBorder(Shape decoratedShape) {
		System.out.println("Shape is decorated in red");
	}

}
