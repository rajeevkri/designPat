package com.carParking;

public class Car implements Vehicle {
	
	public Car(String color, String carNo) {
		super();
		this.color = color;
		this.carNo = carNo;
	}

	private String color;
	
	private String carNo;

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public String getCarNo() {
		return carNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carNo == null) ? 0 : carNo.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (carNo == null) {
			if (other.carNo != null)
				return false;
		} else if (!carNo.equals(other.carNo))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}

}
