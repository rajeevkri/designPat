package com.test.factory;

public class ColorFactory extends AbstractFactory {

	@Override
	public Color getColor(ColorType colorType) {
		Color color = null;
		switch (colorType) {
			case RED:
				color =  new Red();
				break;
			case GREEN:
				color = new Green();
				break;
			case BLUE:
				color = new Blue();
				break;
			default:
				break;
		}
		return color;
	}

	@Override
	public Shape getShape(ShapeType shapeType) {
		return null;
	}

}
