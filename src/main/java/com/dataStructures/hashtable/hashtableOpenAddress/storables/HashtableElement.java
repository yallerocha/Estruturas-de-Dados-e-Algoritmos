package com.dataStructures.hashtable.hashtableOpenAddress.storables;

public class HashtableElement implements Storable {

	private Integer key;

	public HashtableElement(int key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		return this.key.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}

}
