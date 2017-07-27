package com.carParking;

public class ParkingSpace implements Comparable<ParkingSpace>{
	
	public ParkingSpace(Integer parkingNo) {
		super();
		this.parkingNo = parkingNo;
	}

	private Integer parkingNo;

	public Integer getParkingNo() {
		return parkingNo;
	}

	public void setParkingNo(Integer parkingNo) {
		this.parkingNo = parkingNo;
	}

	@Override
	public int compareTo(ParkingSpace parkingSpace) {
		return this.parkingNo.compareTo(parkingSpace.getParkingNo());
	}
	
}
