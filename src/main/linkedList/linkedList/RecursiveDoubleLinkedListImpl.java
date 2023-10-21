package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
	}

	@Override
	public void insertFirst(T element) {
		if(isEmpty()) {
			insert(element);
		} else {
		RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<T>();
		newNode.data = data;
		data = element;
		newNode.next = next;
		next = newNode;
		((RecursiveDoubleLinkedListImpl<T>) next).previous = newNode;
		newNode.previous = this;
		}
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()) {
			if(!next.isEmpty()) {
				data = next.data;
				((RecursiveDoubleLinkedListImpl<T>)next.next).previous = this;
				next = next.next;
			} else {
				data = null;
				next = null;
				previous = null;
			}
		} 
	}

	@Override
	public void removeLast() {
		if(!isEmpty()) {
			if(next.isEmpty()) {
				data = previous.data;
				if(previous.isEmpty()) {
					previous = null;
					next = null;
				} 
			} else {
				((RecursiveDoubleLinkedListImpl<T>) next).removeLast();
			}
		}
	}
	
	@Override
	public void insert(T element) {
		if(isEmpty()) {
			this.data = element;
			this.next = new RecursiveDoubleLinkedListImpl<T>();
			if(previous == null) {
				previous = new RecursiveDoubleLinkedListImpl<T>();
			}
		} else {
			next.insert(element);
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
