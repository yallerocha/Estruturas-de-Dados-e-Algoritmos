package com.dataStructures.queue.variationsOfQueue;

import com.dataStructures.queue.Queue;
import com.dataStructures.queue.exceptions.QueueOverflowException;
import com.dataStructures.queue.exceptions.QueueUnderflowException;
import com.dataStructures.stack.Stack;
import com.dataStructures.stack.StackImpl;
import com.dataStructures.stack.exceptions.StackOverflowException;
import com.dataStructures.stack.exceptions.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		try {
			stack1.push(element);
		} catch (StackOverflowException error) {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		while (!stack1.isEmpty()) {
			try {
				stack2.push(stack1.pop());
			} catch (StackOverflowException | StackUnderflowException error) {
				throw new QueueUnderflowException();
			}
		}
		T element;
		
		try {
			element = stack2.pop();
		} catch (StackUnderflowException error) {
			throw new QueueUnderflowException();
		}
		while (!stack2.isEmpty()) {
			try {
				stack1.push(stack2.pop());
			} catch (StackOverflowException | StackUnderflowException error) {
				throw new QueueUnderflowException();
			}
		}
		return element;
	}

	@Override
	public T head() {
		while (!stack1.isEmpty()) {
			try {
				stack2.push(stack1.pop());
			} catch (StackOverflowException | StackUnderflowException error) {
				error.printStackTrace();
			}
		}
		T head = stack2.top();
		
		while (!stack2.isEmpty()) {
			try {
				stack1.push(stack2.pop());
			} catch (StackOverflowException | StackUnderflowException error) {
				error.printStackTrace();
			}
		}
		return head;
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack1.isFull();
	}

}
