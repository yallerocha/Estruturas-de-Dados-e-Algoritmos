package com.linkedList.stack;

public class StackOverflowException extends Exception {

	public StackOverflowException() {
		super("Stack is full");
	}

}
