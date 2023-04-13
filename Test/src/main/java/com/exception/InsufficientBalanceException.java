package com.exception;

public class InsufficientBalanceException extends Exception {
private String message;

/**
 * @param message
 */
public InsufficientBalanceException(String message) {
	this.message = message;
}

}
