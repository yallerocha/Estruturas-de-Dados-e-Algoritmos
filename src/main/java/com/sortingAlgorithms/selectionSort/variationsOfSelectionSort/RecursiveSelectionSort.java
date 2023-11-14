package com.sortingAlgorithms.selectionSort.variationsOfSelectionSort;

import com.sortingAlgorithms.AbstractSorting;
import com.util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int menor = leftIndex;
			
			for(int i = menor; i <= rightIndex; i++) {
				if(array[i].compareTo(array[menor]) < 0) {
					menor = i;
				}
			}
			if(array[leftIndex] != array[menor]) {
				Util.swap(array, leftIndex, menor);
			}
			leftIndex = leftIndex + 1;
			sort(array, leftIndex, rightIndex);
		}
	}
}