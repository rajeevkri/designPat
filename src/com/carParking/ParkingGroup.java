package com.carParking;

import java.util.ArrayList;
import java.util.List;

public class ParkingGroup {
	
	public ParkingGroup(String name) {
		super();
		this.name = name;
	}

	private String name;
	List<ParkingSpace> parkingSpace = new ArrayList<>();
	List<ParkingSpace> availableParkingSpace = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ParkingSpace> getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(List<ParkingSpace> parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public List<ParkingSpace> getAvailableParkingSpace() {
		return availableParkingSpace;
	}

	public void setAvailableParkingSpace(List<ParkingSpace> availableParkingSpace) {
		this.availableParkingSpace = availableParkingSpace;
	}
	
}
