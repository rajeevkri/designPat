package com.test.factory;

public abstract class AbstractFactory {

	public abstract Color getColor(ColorType colorType);
	public abstract Shape getShape(ShapeType shapeType);
}
