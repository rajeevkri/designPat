package com.carParking;

import java.util.List;

public interface ParkingStrategy {
	public void addParking(ParkingSpace parkingSpace, String parkingGroupName);
	
	public Integer bookCarParking(Car car);
	
	public void removeCarFromParking(Car car);

	public List<ParkingSpace> getBookedParkingSpaces() ;

	public List<ParkingSpace> getParkingSpaces() ;

}
