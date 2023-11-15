package com.sortingAlgorithms.orderStatistic.floor;

import com.util.Util;

public class FloorBinarySearchImpl implements Floor {

    @Override
    public Integer floor(Integer[] array, Integer x) {

        if (array.length == 0) {
            return null;
        }

        Integer left = 0;
        Integer right = array.length - 1;

        // Use an in-place sorting algorithm (e.g., quickSortInPlace) instead of quickSort
        quickSortInPlace(array, left, right);

        int resultIndex = binarySearch(array, left, right, x);
        if (resultIndex == -1) {
            return null;
        } else {
            return array[resultIndex];
        }
    }

    private int binarySearch(Integer array[], Integer left, Integer right, Integer x) {
        int floor = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] <= x) {
                floor = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return floor;
    }

    private void quickSortInPlace(Integer[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);

            quickSortInPlace(array, left, pivot - 1);
            quickSortInPlace(array, pivot + 1, right);
        }
    }

    private int partition(Integer[] array, int left, int right) {
        Integer pivot = array[left];
        int i = left;

        for (int j = left + 1; j <= right; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                Util.swap(array, i, j);
            }
        }

        Util.swap(array, i, left);

        return i;
    }
}
