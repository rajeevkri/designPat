package com.test.factory;

public class FactoryProducer {

	public AbstractFactory getFactory(FactoryType type) {
		AbstractFactory factory = null;
		
		switch (type) {
		case COLOR:
			factory = new ColorFactory();
			break;

		case SHAPE:
			factory = new ShapeFactory();
			break;

		default:
			break;
		}
		return factory;
	}
}
