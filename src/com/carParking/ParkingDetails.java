package com.carParking;

import java.util.Date;

public class ParkingDetails {
	
	public ParkingDetails(Vehicle vehicle, ParkingSpace parkingSpace, Date fromTime) {
		super();
		this.vehicle = vehicle;
		this.parkingSpace = parkingSpace;
		this.fromTime = fromTime;
		this.toTime = null;
	}

	private Vehicle vehicle;
	
	private ParkingSpace parkingSpace;
	
	private Date fromTime;
	
	private Date toTime;

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public Date getFromTime() {
		return fromTime;
	}

	public void setFromTime(Date fromTime) {
		this.fromTime = fromTime;
	}

	public Date getToTime() {
		return toTime;
	}

	public void setToTime(Date toTime) {
		this.toTime = toTime;
	}
	
}
