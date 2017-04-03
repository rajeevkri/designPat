package com.test.iterator;

public class IteratorPatternDemo {
	public static void main(String[] args) {
		NameRepository nameRepository = new NameRepository();
		Iterator it = nameRepository.getIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
