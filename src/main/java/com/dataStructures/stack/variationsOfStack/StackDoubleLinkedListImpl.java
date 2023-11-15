package com.dataStructures.stack.variationsOfStack;

import com.dataStructures.linkedList.doubleLinkedList.DoubleLinkedListImpl;
import com.dataStructures.stack.Stack;
import com.dataStructures.stack.exceptions.StackOverflowException;
import com.dataStructures.stack.exceptions.StackUnderflowException;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedListImpl<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(!isFull()) {
			top.insert(element);
		} else {
			throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(!isEmpty()) {
			T removedElement = (T) top.getLast().getData();
			top.removeLast();
			return removedElement;
		} else {
			throw new StackUnderflowException();
		}
	}

	@Override
	public T top() {
		return top.getLast().getData();
	}

	@Override
	public boolean isEmpty() {
		return top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return size == top.size();
	}
}
