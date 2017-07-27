package com.carParking;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class ParkingStrategyFillFirst implements ParkingStrategy {

	private List<ParkingSpace> bookedParkingSpaces= new ArrayList<>();
	private Map<Car, ParkingDetails> detailsMap =  new HashMap<>();
	
	private List <ParkingDetails> parkingHistory = new ArrayList<>();

	private List<ParkingSpace> parkingSpaces = new ArrayList<>();
	private TreeSet<ParkingSpace> availableParkingSpaces = new TreeSet<>();
	
	
	//Admin to add all available parking
	public void addParking(ParkingSpace parkingSpace, String parkingGroupName){
		parkingSpaces.add(parkingSpace);
		availableParkingSpaces.add(parkingSpace);
	}
	
	public Integer bookCarParking(Car car) {
		try{
			ParkingSpace firstAvailableParking = availableParkingSpaces.first();
			ParkingDetails detail = new ParkingDetails(car, firstAvailableParking,new Date());
			detailsMap.put(car, detail);
			bookedParkingSpaces.add(firstAvailableParking);
			availableParkingSpaces.remove(firstAvailableParking);
			return firstAvailableParking.getParkingNo();
		}catch(NoSuchElementException nse) {
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
