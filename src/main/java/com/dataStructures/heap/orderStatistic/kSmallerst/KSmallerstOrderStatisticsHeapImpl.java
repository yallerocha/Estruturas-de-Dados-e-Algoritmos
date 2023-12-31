package com.dataStructures.heap.orderStatistic.kSmallerst;

import java.util.PriorityQueue;

public class KSmallerstOrderStatisticsHeapImpl<T extends Comparable<T>> implements KSmallerst<T> {

	/**
	 * Existem diversas formas de se calcular uma estatistica de ordem. 
	 * Voce deve fazer isso usando uma heap restricoes:
	 * - nenhuma copia ou estrutura array auxiliar serah permitida, exceto o uso de
	 *   uma PriorityQueue
	 * - caso a estatistica de ordem procurada nao exista no array o metodo deve retornar null 
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	
	@Override
	public T getOrderStatistics(T[] array, int k) {
		if (array != null && k > 0 && k <= array.length) {
			PriorityQueue<T> heap = new PriorityQueue<>();

			for (T element : array) {
				heap.offer(element);
				if (heap.size() > k) {
					heap.poll();
				}
			}
			return heap.poll();
		}
		return null;
	}
}
