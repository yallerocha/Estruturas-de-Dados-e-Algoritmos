package com.dataStructures.stack_queue.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	@SuppressWarnings("unchecked")
	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (!isFull()) {
			if (isEmpty()) {
				head = 0;
			}
			tail++;
			array[tail] = element;
			elements++;

		} else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (!isEmpty()) {
			T removedElement = array[head];
			
			array[head] = null;
			head++;
			elements--;

			if (isEmpty()) {
				head = -1;
				tail = -1;
			}
			return removedElement;
			
		} else {
			throw new QueueUnderflowException();
		}
	}

	@Override
	public T head() {
		if(head != -1) {
			return array[head];
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}

	@Override
	public boolean isFull() {
		return elements == array.length;
	}
}