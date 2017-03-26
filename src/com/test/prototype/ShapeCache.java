package com.test.prototype;

import java.util.Hashtable;

public class ShapeCache {

	private ShapeCache() {

	}

	private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

	/**
	 * cache will populated mostly from DB or some third party service which can
	 * be used repetitively
	 */
	public static void populateCache() {
		Circle circle = new Circle();
		circle.setId("1");
		circle.setType();
		shapeMap.put(circle.getId(), circle);

		Square square = new Square();
		square.setId("2");
		square.setType();
		shapeMap.put(square.getId(), square);

		Triangle triangle = new Triangle();
		triangle.setId("3");
		triangle.setType();
		shapeMap.put(triangle.getId(), triangle);
	}

	public static Shape getShape(String shapeId) {
		Shape cachedShape = shapeMap.get(shapeId);
		return (Shape) cachedShape.clone();
	}
}
