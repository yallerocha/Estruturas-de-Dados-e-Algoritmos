package com.sortingAlgorithms.bubbleSort.variationsOfBubbleSort;

import com.sortingAlgorithms.AbstractSorting;
import com.util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			Boolean swapped = true;
		    
			while(swapped) {
				swapped = false;
				for(int i = leftIndex; i < rightIndex; i++) {
					if(array[i].compareTo(array[i + 1]) > 0) {
						Util.swap(array, i, i + 1);
						swapped = true; 
					}
				}
				if(swapped != false) {
					rightIndex = rightIndex - 1;
					swapped = false;
					
					for (int i = rightIndex - 1; i >= leftIndex; i--) {
		                if (array[i].compareTo(array[i + 1]) > 0) {
		                    Util.swap(array,i, i + 1);
		                    swapped = true;
		                }
		            }
					leftIndex = leftIndex + 1;
				} 			
			}
		}
	} 
}