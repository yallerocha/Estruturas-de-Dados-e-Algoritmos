package com.dataStructures.stack_queue.stack;

public class StackOverflowException extends Exception {

	public StackOverflowException() {
		super("Stack is full");
	}

}
