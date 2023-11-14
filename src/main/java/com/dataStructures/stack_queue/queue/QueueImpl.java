package com.dataStructures.stack_queue.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		return array[0];
	}

	@Override
	public boolean isEmpty() {
		if(tail == -1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(tail == array.length -1) {
			return true;
		}
		return false;
	}

	private void shiftLeft() {
		for(int i = 0; i < tail; i++) {
			array[i] = array[i + 1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(!this.isFull()) {
			tail++;
			array[tail] = element;
		} else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(!this.isEmpty()) {
			T result = array[0];
			shiftLeft();
			tail--;
			return result;
		} else {
			throw new QueueUnderflowException();
		}
	}

}
