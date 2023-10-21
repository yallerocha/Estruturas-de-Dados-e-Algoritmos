package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	 @Override
	    public void sort(Integer[] A, int leftIndex, int rightIndex) {

	        if (leftIndex < rightIndex) {
	            int min = getMinValue(A, leftIndex, rightIndex);
	            int max = getMaxValue(A, leftIndex, rightIndex);

	            int range = max - min + 1;
	            int[] C = new int[range];
	            Integer[] B = new Integer[rightIndex - leftIndex + 1];

	            for (int j = leftIndex; j <= rightIndex; j++) {
	                C[A[j] - min]++; 
	            }
	            for (int i = 1; i < C.length; i++) {
	                C[i] += C[i - 1];
	            }
	            for (int j = rightIndex; j >= leftIndex; j--) {
	                B[C[A[j] - min] - 1] = A[j];
	                C[A[j] - min]--;
	            }
	            for (int i = leftIndex; i <= rightIndex; i++) {
	                A[i] = B[i - leftIndex];
	            }
	        }
	    }

	    private int getMinValue(Integer[] A, int leftIndex, int rightIndex) {
	        int min = A[leftIndex];
	        for (int i = leftIndex + 1; i <= rightIndex; i++) {
	            if (A[i] < min) {
	                min = A[i];
	            }
	        }
	        return min;
	    }

	    private int getMaxValue(Integer[] A, int leftIndex, int rightIndex) {
	        int max = A[leftIndex];
	        for (int i = leftIndex + 1; i <= rightIndex; i++) {
	            if (A[i] > max) {
	                max = A[i];
	            }
	        }
	        return max;
	    }
}
