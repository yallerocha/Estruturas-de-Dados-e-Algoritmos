package com.orderStatistic_QuickSelect.problems;

import com.util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		
		if(array.length == 0) {
			return null;
		}
		Integer left = 0;                                            
		Integer rigth = array.length - 1;
		
		quickSort(array, left, rigth);
		int resultado = busca(array, left, rigth, x, -1);         
		
		if(resultado == -1) {
			return null;
		} else {
			return array[resultado];
		}
	}

	private Integer busca(Integer array[], Integer left, Integer rigth, Integer x, Integer floor) {
        if (rigth >= left) {
        	
            Integer meio = left + (rigth - left) / 2;
            
            if(array[meio] <= x && array[meio] > floor) {
            	floor = meio;
            }
 
            if (array[meio] == x) {
            	return meio;
            	
            } else if (array[meio] > x) {
            	return busca(array, left, meio - 1, x, floor);
            } else {
            	return busca(array, meio + 1, rigth, x, floor);
            }
        }
        return floor;
    }
	
	private void quickSort(Integer[] array, int left, int rigth) {
        if (left < rigth) {
  
            int pivot = partition(array, left, rigth);
  
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, rigth);
        }
    }
	
	private int partition(Integer[] array, int left, int right) {
		Integer pivot = array[left];                                    
		                     									 
		int i = left;                                            
		for(int j = left + 1; j <= right ; j++) {                   
			if(array[j].compareTo(pivot) <= 0) {                 
				i++;                                             
				Util.swap(array, i, j);
			}
		} 
		Util.swap(array, i, left);
		
		return i;
	}
}
