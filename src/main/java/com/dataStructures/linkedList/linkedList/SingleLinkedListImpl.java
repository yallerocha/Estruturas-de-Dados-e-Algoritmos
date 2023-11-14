package com.dataStructures.linkedList.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {
	
	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}
	
	public SingleLinkedListImpl(DoubleLinkedListNode<T> head) {
		this.head = head;
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> auxHead = this.head;
		while(!auxHead.isNIL()) {
			size++;
			auxHead = auxHead.next;
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxHead = this.head;
		while(!auxHead.isNIL() && auxHead.data != element) {
			auxHead = auxHead.next;
		}
		return auxHead.data;
	}
 
	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> auxHead = this.head;
		if(head.isNIL()) {
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T> (element, null);
			newHead.next = this.head;
			this.head = newHead;
		} else {
			while(!auxHead.isNIL()) {
				auxHead = auxHead.next; 
			}
			auxHead.data = element;
			auxHead.next = new SingleLinkedListNode<T>();
		}	
	}

	@Override
	public void remove(T element) {
		if(this.head.data == element) {
			this.head = this.head.next;
		} else {
			SingleLinkedListNode<T> auxHead = this.head;
			while(!auxHead.isNIL() && auxHead.data != element) {
				auxHead = auxHead.next;
			}
			if(!auxHead.isNIL()) {
				auxHead.data = auxHead.next.data;
				auxHead.next = auxHead.next.next;
			}
		}
	}

	@Override 
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[size()];
		SingleLinkedListNode<T> auxHead = this.head;
		int index = 0;
		
		while(!auxHead.isNIL()) {
			array[index] = auxHead.data;
			auxHead = auxHead.next;
			index++;
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(DoubleLinkedListNode<T> head) {
		this.head = head;
	}

}
