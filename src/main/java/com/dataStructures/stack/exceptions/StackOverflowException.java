package com.dataStructures.stack.exceptions;

public class StackOverflowException extends Exception {

	public StackOverflowException() {
		super("Stack is full");
	}

}
