package com.java.algo;

import java.util.Arrays;

public class LargestRange {
	
	public static void main (String[] args) {
		int[] result = largestRange(new int[] {19, -1, 18, 17, 2, 10, 3, 12, 5, 16, 4, 11, 8, 7, 6, 15, 12, 12, 2, 1, 6, 13, 14});
		System.out.println(result[0]);
		System.out.println (result[1]);
	}

	public static int[] largestRange(int[] array) {
		if (array == null || array.length == 0)
			return new int[] {};
		int maxStart = 0;
		int maxEnd = 0;
		Arrays.sort(array);
		int start = 0;
		int end = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] == array[i - 1] + 1) {
				end = i;
			} else if (((end) - start) > (maxEnd - maxStart)) {
				maxStart = start;
				maxEnd = end;
				start = i;
				end = i;
			} else {
				start = i;
				end = i;
			}

		}
		if ((end - start) > (maxEnd - maxStart)) {
			maxStart = start;
			maxEnd = end;
		}
		return new int[] { array[maxStart], array[maxEnd] };
	}
}
