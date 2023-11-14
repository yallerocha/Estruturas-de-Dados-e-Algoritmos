package com.dataStructures.hashtable.open;

import com.dataStructures.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import com.dataStructures.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		int probe = 0;

		while(probe < table.length - 1) {
			int key = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
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
			int key = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
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
			int key = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
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
			int key = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
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