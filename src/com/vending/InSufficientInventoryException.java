package com.vending;

public class InSufficientInventoryException extends RuntimeException
{
	private String message;

	public InSufficientInventoryException(String string) { this.message = string; }

	@Override
	public String getMessage() {
		return message;
	}

}
