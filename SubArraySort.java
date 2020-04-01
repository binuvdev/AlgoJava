package com.java.algo;
//Algo Hard #2
//SubArray Sort
//O(N^2) time | O(1) space.
//Algo has a solution with O(N) time | O(1) space.

public class SubArraySort {
	public static int[] subarraySort(int[] array) {

		int[] subArrayIndices = { -1, -1 };

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[i]) {
					subArrayIndices[0] = i;
					break;
				}
			}
			if (subArrayIndices[0] != -1)
				break;
		}

		for (int i = array.length - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (array[j] > array[i]) {
					subArrayIndices[1] = i;
					break;
				}
			}
			if (subArrayIndices[1] != -1)
				break;
		}

		return subArrayIndices;

	}
}
