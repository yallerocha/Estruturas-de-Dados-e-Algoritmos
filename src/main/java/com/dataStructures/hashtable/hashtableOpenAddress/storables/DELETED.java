package com.dataStructures.hashtable.hashtableOpenAddress.storables;

public class DELETED implements Storable {

	public DELETED() {

	}

	@Override
	public boolean equals(Object obj) {
		boolean resp = false;
		if (obj != null) {
			resp = obj instanceof DELETED;
		}
		return resp;
	}

	@Override
	public String toString() {
		return "D";
	}
}
