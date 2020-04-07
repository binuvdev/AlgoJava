package com.java.algo;

//Algo Hard 
//Quick Sort
//O(nlog(n)) time | o(log(n) space

public class QuickSort {
	public static void main(String[] args) {
		int[] input = { -4, 5, 10, 8, -10, -6, -4, -2, -5, 3, 5, -4, -5, -1, 1,
				6, -7, -6, -7, 8 };// {8, 3, 2, 5, 1, 7, 4, 6};
		doQuickSort(input, 0, input.length - 1);
		for (int i : input) {
			System.out.print(i + " ");
		}

	}

	public static int[] quickSort(int[] array) {
		doQuickSort(array, 0, array.length - 1);
		return array;
	}

	static void doQuickSort(int[] array, int start, int end) {
		//System.out.println("i=" + start + " j=" + end);
		if (start >= end)
			return;
		int pivot = array[start];
		int i = start + 1;
		int j = end;
		while (j >= i) {
			if (array[i] > pivot && array[j] < pivot) {
				swap(array, i, j);
			}

			if (array[i] <= pivot)
				i++;

			if (array[j] >= pivot)
				j--;
		}

		swap(array, start, j);
		if (j - start <= end - j) {
			doQuickSort(array, start, j - 1);
			doQuickSort(array, j + 1, end);
		} else {
			doQuickSort(array, j + 1, end);
			doQuickSort(array, start, j - 1);
		}

	}

	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
