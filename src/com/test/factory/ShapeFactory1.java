package com.test.factory;

public class ShapeFactory1 {
	// use getShape method to get object of type shape
	public Shape getShape(ShapeType shapeType) {
		Shape shape = null;
		switch (shapeType) {
			case CIRCLE:
				shape =  new Circle();
				break;
			case TRIANGLE:
				shape = new Triangle();
				break;
			case SQUARE:
				shape = new Square();
				break;
			default:
				break;
		}
		return shape;
	}
}
