package com.dataStructures.heap.orderStatistic.floorCeil;

import java.util.Comparator;

import com.dataStructures.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer floor = null;
		
		for (Integer element: array) {
			insert(element);
			if (element <= numero && (floor == null || element > floor)) {
				floor = element;
			}
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer ceil = null;
		
		for (Integer element: array) {
			insert(element);
			if (element >= numero && (ceil == null || element < ceil)) {
				ceil = element;
			}
		}
		return ceil;
	}

}
