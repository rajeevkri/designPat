package com.test.strategy;

public class StrategyPatternDemo {
	public static void main(String[] args) {
		Context context1 = new Context(new OperationAdd());
		Context context2 = new Context(new OperationSubstract());
		Context context3 = new Context(new OperationMultiply());

		System.out.println("10 + 5 = " + context1.executeStrategy(10, 5));
		System.out.println("10 - 5 = " + context2.executeStrategy(10, 5));
		System.out.println("10 * 5 = " + context3.executeStrategy(10, 5));
	}
}
