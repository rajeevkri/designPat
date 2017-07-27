package com.carParking;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingStrategyUniformAssignmentInGroup implements ParkingStrategy {
	Map<String, ParkingGroup> parkingGroups = new HashMap<>();
	private List<ParkingSpace> bookedParkingSpaces;
	private List <ParkingDetails> parkingHistory = new ArrayList<>();

	private Map<Car, ParkingDetails> detailsMap = new HashMap<>();

	@Override
	public void addParking(ParkingSpace parkingSpace, String name) {
		ParkingGroup parkingGroup = parkingGroups.get(name);
		if (parkingGroup == null) {
			parkingGroup = new ParkingGroup(name);
			parkingGroups.put(name, parkingGroup);
		}
		List<ParkingSpace> parkingSpaces = parkingGroup.getParkingSpace();
		List<ParkingSpace> availableParkingSpaces = parkingGroup.getAvailableParkingSpace();
		parkingSpaces.add(parkingSpace);
		availableParkingSpaces.add(parkingSpace);
	}

	@Override
	public Integer bookCarParking(Car car) {
		return null;
	}

	public void removeCarFromParking(Car car) {
		ParkingDetails parkingDetails = detailsMap.get(car);
		if (parkingDetails != null) {
			parkingDetails.setToTime(new Date());
			ParkingSpace parkingSpace = parkingDetails.getParkingSpace();
			bookedParkingSpaces.remove(parkingSpace);
			for(String key : parkingGroups.keySet()) {
				ParkingGroup parkingGroup = parkingGroups.get(key);
				List<ParkingSpace> availableParkingSpaces = parkingGroup.getAvailableParkingSpace();
				availableParkingSpaces.add(parkingSpace);
			}
			parkingHistory.add(parkingDetails);
		} else {
			System.out.println("malformed car");
		}
	}

	public List<ParkingSpace> getBookedParkingSpaces() {
		return bookedParkingSpaces;
	}

	public List<ParkingSpace> getParkingSpaces() {
		List<ParkingSpace> parkingSpaces =  new ArrayList<>();
		for(String key : parkingGroups.keySet()) {
			ParkingGroup parkingGroup = parkingGroups.get(key);
			List<ParkingSpace> parkingSpacs = parkingGroup.getParkingSpace();
			parkingSpaces.addAll(parkingSpacs);
		}
		return parkingSpaces;
	}
}
