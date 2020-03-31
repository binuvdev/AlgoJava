package com.java.algo;
//Algo Medium
//Monotonic checker
//O(N) time | O(1) space
//Algo has a beautiful algorithm (Solution 2) 
public class Monotonic {

	public static boolean isMonotonic(int[] array) {
		boolean isIncreasing = false;
		int i;
		//Iterate till we find increasing or decreasing
		for (i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				isIncreasing = true;
				break;
			} else if (array[i] < array[i - 1]) {
				isIncreasing = false;
				break;
			}
		}
		if (isIncreasing) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[j - 1])
					return false;
			}
		} else {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] > array[j - 1])
					return false;
			}
		}
		return true;
	}
}
