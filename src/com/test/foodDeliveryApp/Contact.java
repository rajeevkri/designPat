package com.test.foodDeliveryApp;

public class Contact {

	private String id;

	private String contactNumber;

	private String address;

	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void sendNotification(String msg) {
		System.out.println(
				"sending notification to contactNumber " + contactNumber 
				+ " email = " + email + " ---> " + msg);
	}
}
