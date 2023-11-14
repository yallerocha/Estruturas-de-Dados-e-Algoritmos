package com.sortingAlgorithms.mergeSort;

import java.util.Arrays;

import com.sortingAlgorithms.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int meio = (rightIndex + leftIndex) / 2;
		
			sort(array, leftIndex, meio);
			sort(array, meio + 1, rightIndex);
			merge(array, leftIndex, meio, rightIndex);
		}
	}

	private void merge(T[] array, int leftIndex, int meio, int rightIndex) {
		T[] left = Arrays.copyOfRange(array, leftIndex, meio + 1);
		T[] rigth = Arrays.copyOfRange(array, meio + 1, rightIndex + 1);
		
		int left_top = 0;
		int rigth_top = 0;
		
		for(int k = leftIndex; k <= rightIndex; k++) {
			if(left_top >= left.length) {
				array[k] = rigth[rigth_top];
				rigth_top++;
			} else if(rigth_top >= rigth.length) {
				array[k] = left[left_top];
				left_top++;
			} else if(left[left_top].compareTo(rigth[rigth_top]) < 0) {
				array[k] = left[left_top];
				left_top++;
			} else {
				array[k] = rigth[rigth_top];
				rigth_top++;
			}
		}
	}
}
