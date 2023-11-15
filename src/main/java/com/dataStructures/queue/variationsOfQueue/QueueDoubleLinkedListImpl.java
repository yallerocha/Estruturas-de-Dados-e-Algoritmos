package com.dataStructures.queue.variationsOfQueue;

import com.dataStructures.linkedList.doubleLinkedList.DoubleLinkedListImpl;
import com.dataStructures.queue.Queue;
import com.dataStructures.queue.exceptions.QueueOverflowException;
import com.dataStructures.queue.exceptions.QueueUnderflowException;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedListImpl<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
	    if (!isFull()) {
	    	list.insert(element);
	    } else {
	    	throw new QueueOverflowException();
	    }
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
	    if (!isEmpty()) {
	    	T removedElement = (T) list.getHead().getData();
	    	list.removeFirst();
	    	return removedElement;
	    } else {
	    	throw new QueueUnderflowException();
	    }
	}

	@Override
	public T head() {
	    if (!isEmpty()) {
	    	return (T) list.getHead().getData();
	    } else {
	    	return null;
	    }
	}

	@Override
	public boolean isEmpty() {
	    return list.isEmpty();
	}

	@Override
	public boolean isFull() {
	    return list.size() == size;
	}

}
