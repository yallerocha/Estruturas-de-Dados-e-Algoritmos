package com.mergeSort_QuickSort.divideAndConquer.quicksort3;

import com.mergeSort_QuickSort.AbstractSorting;
import com.util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int pivot = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivot - 1);
			sort(array, pivot + 1, rightIndex);
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		T pivot = medianOfThree(array, leftIndex, rightIndex);
		
		int i = rightIndex - 1;
		for(int j = i - 1; j >= leftIndex; j--) {
			if(array[j].compareTo(pivot) >= 0) {
				i--;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, rightIndex - 1, i);
		
		return i; 
	}
	
	private T medianOfThree(T[] array, int leftIndex, int rightIndex) {
		int intermediaryIndex = (leftIndex + rightIndex) / 2;
		
		if(array[leftIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, leftIndex, rightIndex);
		}
		if (array[intermediaryIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, intermediaryIndex, rightIndex);
		}
		if (array[leftIndex].compareTo(array[intermediaryIndex]) > 0) {
			Util.swap(array, leftIndex, intermediaryIndex);
		}
		Util.swap(array, intermediaryIndex, rightIndex - 1);
		
		T pivot = array[rightIndex - 1];
		
		return pivot;
	}
}