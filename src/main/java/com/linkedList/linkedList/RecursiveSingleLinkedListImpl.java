package com.linkedList.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		if(isEmpty()) {
			return 0;
		} else {
			return 1 + next.size();
		}
	}

	@Override
	public T search(T element) {
		if (!isEmpty()) {
			if (this.data == element) {
				return element;
			} else {
				return next.search(element);
			} 
		}
		return null;
	}

	@Override
	public void insert(T element) {
		if(isEmpty()) {
			this.data = element;
			this.next = new RecursiveSingleLinkedListImpl<T>();
		} else {
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if(!isEmpty()) {
			if (this.data == element) {
				this.data = next.data;
				this.next = next.next;
			} else {
				next.remove(element);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public T[] toArray() {
		java.util.LinkedList<T> result = new java.util.LinkedList<T>();
		toListArray(result, this);
		return (T[]) result.toArray();
	}
	
	public void toListArray(java.util.LinkedList<T> list, RecursiveSingleLinkedListImpl<T> node) {
		if(!node.isEmpty()){
			list.add(node.data);
			toListArray(list, node.next);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
