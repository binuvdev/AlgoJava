package com.java.algo;

//Algo Easy #11
//O(N^2) time | O(1) space

public class InsertionSort {

	public static int[] insertionSort(int[] array) {
		if (array == null || array.length < 2)
			return array;

		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					swap(j, j - 1, array);
				} else {
					break;
				}
			}
		}
		return array;
	}

	static void swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
