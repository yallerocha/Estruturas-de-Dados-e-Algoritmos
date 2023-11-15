package com.dataStructures.linkedList.doubleLinkedList;

import com.dataStructures.linkedList.singleLinkedList.SingleLinkedListImpl;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	public DoubleLinkedListImpl() {
		super(new DoubleLinkedListNode<T>()); 
		last = (DoubleLinkedListNode<T>) head;
	}   

	@Override 
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, null, null);
		newHead.setNext((DoubleLinkedListNode<T>) head);
		newHead.previous = new DoubleLinkedListNode<T>();
		((DoubleLinkedListNode<T>) head).previous = newHead; 
		if(head.isNIL()) { 
			last = newHead; 
		}
		head = newHead;
	} 
 
	@Override
	public void removeFirst() { 
		if(!head.isNIL()) {
			head = head.getNext();
			if (head.isNIL()) {
				last = (DoubleLinkedListNode<T>) head;
			} else {
			((DoubleLinkedListNode<T>) head).previous = new DoubleLinkedListNode<T>();
			}	
		}
	}

	@Override
	public void removeLast() {
		if(!last.isNIL()) {
			last = last.previous;
			if (last.isNIL()) {
				head = last;
			} else {
			last.setNext(new DoubleLinkedListNode<T>());
			}	
		}
	}

	@Override
	public void insert(T element) {
		DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<T>(element, null, null);
		newLast.previous = last;
		newLast.setNext(new DoubleLinkedListNode<T>(null, null, null));
		last.setNext(newLast);
		if(last.isNIL()) {
			head = newLast;
		}
		last = newLast;
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
