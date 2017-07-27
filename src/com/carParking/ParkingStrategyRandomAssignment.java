package com.carParking;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class ParkingStrategyRandomAssignment implements ParkingStrategy {

	private List<ParkingSpace> bookedParkingSpaces= new ArrayList<>();
	private Map<Car, ParkingDetails> detailsMap =  new HashMap<>();
	
	private List <ParkingDetails> parkingHistory = new ArrayList<>();

	private List<ParkingSpace> parkingSpaces = new ArrayList<>();
	private List<ParkingSpace> availableParkingSpaces = new ArrayList<>();
	
	
	//Admin to add all available parking
	public void addParking(ParkingSpace parkingSpace, String parkingGroupName){
		parkingSpaces.add(parkingSpace);
		availableParkingSpaces.add(parkingSpace);
	}
	
	public Integer bookCarParking(Car car) {
		int size = availableParkingSpaces.size();
		if(size > 0){
			ParkingSpace availableParking = availableParkingSpaces.get(0);
			ParkingDetails detail = new ParkingDetails(car, availableParking,new Date());
			detailsMap.put(car, detail);
			bookedParkingSpaces.add(availableParking);
			availableParkingSpaces.remove(availableParking);
			return availableParking.getParkingNo();
		} else {
			System.out.println("parking space not available...... wait");
			return null;
		}
	}
	
	public void removeCarFromParking(Car car) {
		ParkingDetails parkingDetails = detailsMap.get(car);
		if(parkingDetails != null) {
			parkingDetails.setToTime(new Date());
			ParkingSpace parkingSpace = parkingDetails.getParkingSpace();
			bookedParkingSpaces.remove(parkingSpace);
			availableParkingSpaces.add(parkingSpace);
			parkingHistory.add(parkingDetails);
		} else {
			System.out.println("malformed car");
		}
	}

	public List<ParkingSpace> getBookedParkingSpaces() {
		return bookedParkingSpaces;
	}

	public List<ParkingSpace> getParkingSpaces() {
		return parkingSpaces;
	}

}
