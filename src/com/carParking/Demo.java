package com.carParking;

import java.util.List;

import org.junit.Test;

public class Demo {
	@Test
	public void testContext1() {
		ParkingContext context = new ParkingContext(new ParkingStrategyFillFirst());

		context.addParking(new ParkingSpace(1), "A");
		context.addParking(new ParkingSpace(2), "A");
		context.addParking(new ParkingSpace(3), "A");
		context.addParking(new ParkingSpace(4), "A");
		Car car1 = new Car("Red", "KA01 123");
		Integer bookCarParking1 = context.bookCarParking(car1);
		System.out.println("car no - " + car1.getCarNo() + " : and with color - " + car1.getColor()
				+ " is parked in parking no" + bookCarParking1);
		Car car2 = new Car("Blue", "KA01 1234");
		Integer bookCarParking2 = context.bookCarParking(car2);
		System.out.println("car no - " + car2.getCarNo() + " : and with color - " + car2.getColor()
				+ " is parked in parking no" + bookCarParking2);
		Car car3 = new Car("Green", "KA01 1235");
		Integer bookCarParking3 = context.bookCarParking(car3);
		System.out.println("car no - " + car3.getCarNo() + " : and with color - " + car3.getColor()
				+ " is parked in parking no" + bookCarParking3);
		Car car4 = new Car("Red", "KA01 1263");
		Integer bookCarParking4 = context.bookCarParking(car4);
		System.out.println("car no - " + car4.getCarNo() + " : and with color - " + car4.getColor()
				+ " is parked in parking no" + bookCarParking4);
		
		List<ParkingSpace> bookedParkingSpaces = context.getBookedParkingSpaces();
		System.out.println("Booked parkings are -- ");
		bookedParkingSpaces.forEach(bookedCarPark -> {
			System.out.print(bookedCarPark.getParkingNo() + " ");
		});
		
		Car car5 = new Car("Green", "KA01 1235");
		context.removeCarFromParking(car5);
		
		bookedParkingSpaces = context.getBookedParkingSpaces();
		System.out.println("Booked parkings are -- ");
		bookedParkingSpaces.forEach(bookedCarPark -> {
			System.out.print(bookedCarPark.getParkingNo() + " ");
		});
	}

	@Test
	public void testContext2() {
		ParkingContext context = new ParkingContext(new ParkingStrategyRandomAssignment());

		context.addParking(new ParkingSpace(1), "A");
		context.addParking(new ParkingSpace(2), "A");
		context.addParking(new ParkingSpace(3), "A");
		context.addParking(new ParkingSpace(4), "A");
		Car car1 = new Car("Red", "KA01 123");
		Integer bookCarParking1 = context.bookCarParking(car1);
		System.out.println("car no - " + car1.getCarNo() + " : and with color - " + car1.getColor()
				+ " is parked in parking no" + bookCarParking1);
		Car car2 = new Car("Blue", "KA01 1234");
		Integer bookCarParking2 = context.bookCarParking(car2);
		System.out.println("car no - " + car2.getCarNo() + " : and with color - " + car2.getColor()
				+ " is parked in parking no" + bookCarParking2);
		Car car3 = new Car("Green", "KA01 1235");
		Integer bookCarParking3 = context.bookCarParking(car3);
		System.out.println("car no - " + car3.getCarNo() + " : and with color - " + car3.getColor()
				+ " is parked in parking no" + bookCarParking3);
		Car car4 = new Car("Red", "KA01 1263");
		Integer bookCarParking4 = context.bookCarParking(car4);
		System.out.println("car no - " + car4.getCarNo() + " : and with color - " + car4.getColor()
				+ " is parked in parking no" + bookCarParking4);

		List<ParkingSpace> bookedParkingSpaces = context.getBookedParkingSpaces();
		System.out.println("Booked parkings are -- ");
		bookedParkingSpaces.forEach(bookedCarPark -> {
			System.out.print(bookedCarPark.getParkingNo() + " ");
		});
		
		Car car5 = new Car("Red", "KA01 1263");
		context.removeCarFromParking(car5);
		
		bookedParkingSpaces = context.getBookedParkingSpaces();
		System.out.println("Booked parkings are -- ");
		bookedParkingSpaces.forEach(bookedCarPark -> {
			System.out.print(bookedCarPark.getParkingNo() + " ");
		});
	}
}
