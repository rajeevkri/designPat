package com.vending;

public class InSufficientChangeException extends RuntimeException
{
	private String message;

	public InSufficientChangeException(String string) { this.message = string; }

	@Override
	public String getMessage() {
		return message;
	}

}
