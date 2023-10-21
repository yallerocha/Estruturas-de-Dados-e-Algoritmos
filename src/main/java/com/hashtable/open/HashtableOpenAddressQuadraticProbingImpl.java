package com.hashtable.open;

import com.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import com.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		int probe = 0;

		while(probe < table.length - 1) {
			int key = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, probe);
			if(table[key] == null || table[key].equals(new DELETED())) {
				table[key] = element;
				elements++;
				return;
			} else {
				COLLISIONS++;
				probe++;
			}
		}
		throw new HashtableOverflowException();
	}

	@Override
	public void remove(T element) {
		int probe = 0;

		while(probe < table.length - 1) {
			int key = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, probe);
			if(table[key] == null) {
				return;
			}
			if(table[key].equals(element)) {
				table[key] = new DELETED();
				elements--;
				return;
			} else {
				probe++;
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T search(T element) {
		int probe = 0;

		while(probe < table.length - 1) {
			int key = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, probe);
			if(table[key] == null || table[key].equals(element) ) {
				return (T) table[key];
			} else {
				probe++;
			}
		}
		return null;
	}

	@Override
	public int indexOf(T element) {
		int probe = 0;

		while(probe < table.length - 1) {
			int key = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, probe);
			if (table[key] == null) {
				return -1;
			} else if (table[key].equals(element)) {
				return key;
			} else {
				probe++;
			}
		}
		return -1;
	}
}