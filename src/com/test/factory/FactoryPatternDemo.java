package com.test.factory;

public class FactoryPatternDemo {
	public static void main(String[] args) {
		ShapeFactory1 shapeFactory = new ShapeFactory1();
		
		Shape shape1 = shapeFactory.getShape(ShapeType.CIRCLE);
		System.out.println(shape1.getName() + " " + shape1.getAreaCalculationFormula());
		Shape shape2 = shapeFactory.getShape(ShapeType.TRIANGLE);
		System.out.println(shape2.getName() + " " + shape2.getAreaCalculationFormula());
		Shape shape3 = shapeFactory.getShape(ShapeType.SQUARE);
		System.out.println(shape3.getName() + " " + shape3.getAreaCalculationFormula());
	}
}
