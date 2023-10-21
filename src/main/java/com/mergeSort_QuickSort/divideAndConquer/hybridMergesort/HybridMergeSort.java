package com.mergeSort_QuickSort.divideAndConquer.hybridMergesort;

import java.util.Arrays;

import com.mergeSort_QuickSort.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementa��o de uma varia��o do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo hibrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementa��o hibrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informa��o possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores s�o resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS;
	protected static int INSERTIONSORT_APPLICATIONS;
	
	public void sort(T[] array, int leftIndex, int rightIndex) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		if(rightIndex > leftIndex) {
			hybridMergeSort(array, leftIndex, rightIndex);
		}
	}
	
	public void hybridMergeSort(T[] array, int leftIndex, int rightIndex) {
		if(rightIndex - leftIndex + 1 <= SIZE_LIMIT) {
			insertionSort(array, leftIndex, rightIndex);
			INSERTIONSORT_APPLICATIONS++;
		} else {
			int meio = (rightIndex + leftIndex) / 2;
			
			hybridMergeSort(array, leftIndex, meio);
			hybridMergeSort(array, meio + 1, rightIndex);
			merge(array, leftIndex, meio, rightIndex);
			MERGESORT_APPLICATIONS++;
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
	
	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		for(int i = leftIndex + 1; i <= rightIndex; i++) {
			int j = i - 1;
			T chave = array[i]; 

			while(j >= leftIndex && array[j].compareTo(chave) > 0) {
				array[j + 1] = array[j];
				j = j - 1;
			} 
			array[j + 1] = chave;
		}
	}
	
	public int getMergeSortApplications() {
		return MERGESORT_APPLICATIONS;
	}
	
	public int getInsertionSortApplications() {
		return INSERTIONSORT_APPLICATIONS;
	}
}

