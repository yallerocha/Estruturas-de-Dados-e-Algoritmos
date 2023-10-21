package com.countingSort.linearSorting;

import com.countingSort.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {
	
	@Override
	public void sort(Integer[] A, int leftIndex, int rightIndex) {
	    if (leftIndex < rightIndex) {
	        int k = getHighestValue(A, leftIndex, rightIndex);

	        int[] C = new int[k + 1];
	        Integer[] B = new Integer[rightIndex - leftIndex + 1];
	        
	        for (int j = leftIndex; j <= rightIndex; j++) {
	            C[A[j]]++;
	        }
	        for (int i = 1; i < C.length; i++) {
	            C[i] = C[i] + C[i - 1];
	        }
	        for (int j = rightIndex; j >= leftIndex; j--) {
	            B[C[A[j]] - 1] = A[j];
	            C[A[j]] = C[A[j]] - 1;
	        }
	        for (int i = leftIndex; i <= rightIndex; i++) {
	            A[i] = B[i - leftIndex];
	        }
	    }
	}
	
	private int getHighestValue(Integer[] A, int leftIndex, int rightIndex) {
		int k = A[leftIndex];
		for(int i = leftIndex; i <= rightIndex; i++) {
			if(A[i] > k) {
				k = A[i];
			}
		}
		return k;
	}
}
