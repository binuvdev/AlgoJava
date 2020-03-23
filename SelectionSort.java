package com.java.algo;
//Algo Easy #12

// O(N^2) time | O(1) space

public class SelectionSort {

	public static int[] selectionSort(int[] array) {
		if (array == null || array.length < 2)
			return array;
		for (int i = 0; i < array.length - 1; i++) {
			int swapIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[swapIndex])
					swapIndex = j;
			}
			if (swapIndex != i)
				swap(array, i, swapIndex);
		}
		return array;
	}

	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
