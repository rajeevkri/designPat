package com.vending;

public class NotAvailableException extends RuntimeException
{
	private String message;

	public NotAvailableException(String string) { this.message = string; }

	@Override
	public String getMessage() {
		return message;
	}

}
