package com.test.factory;

public class AbstractFactoryPatternDemo {

	public static void main(String[] args) {
		FactoryProducer producer = new FactoryProducer();
		AbstractFactory shapeFactory = producer.getFactory(FactoryType.SHAPE);

		Shape shape1 = shapeFactory.getShape(ShapeType.CIRCLE);
		System.out.println(shape1.getName() + " " + shape1.getAreaCalculationFormula());
		Shape shape2 = shapeFactory.getShape(ShapeType.TRIANGLE);
		System.out.println(shape2.getName() + " " + shape2.getAreaCalculationFormula());
		Shape shape3 = shapeFactory.getShape(ShapeType.SQUARE);
		System.out.println(shape3.getName() + " " + shape3.getAreaCalculationFormula());
		
		
		AbstractFactory colorFactory = producer.getFactory(FactoryType.COLOR);
		
		Color color1 = colorFactory.getColor(ColorType.BLUE);
		color1.fill();
		
		Color color2 = colorFactory.getColor(ColorType.GREEN);
		color2.fill();
		
		Color color3 = colorFactory.getColor(ColorType.RED);
		color3.fill();
	}
}
