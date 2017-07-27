package com.carParking;

import java.util.List;

public class ParkingContext {

	private ParkingStrategy parkingStrategy;

	public ParkingContext(ParkingStrategy parkingStrategy) {
		this.parkingStrategy = parkingStrategy;
	}

	public void addParking(ParkingSpace parkingSpace, String parkingGroupName) {
		parkingStrategy.addParking(parkingSpace, parkingGroupName);
	}

	public Integer bookCarParking(Car car) {
		return parkingStrategy.bookCarParking(car);
	}

	public void removeCarFromParking(Car car) {
		parkingStrategy.removeCarFromParking(car);
	}

	public List<ParkingSpace> getBookedParkingSpaces() {
		return parkingStrategy.getBookedParkingSpaces();
	}
}
