package com.bubbleSort_InsertionSort_SelectionSort.simpleSorting;

import com.bubbleSort_InsertionSort_SelectionSort.AbstractSorting;

import com.util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			for(int i = leftIndex; i < rightIndex; i++) {
				int menor = i;
				for(int j = i + 1; j <= rightIndex; j++) {
					if(array[j].compareTo(array[menor]) < 0) {
						menor = j;
					}
				}
				Util.swap(array, i, menor);
			}
		}
	} 
}
