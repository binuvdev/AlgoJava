package com.java.algo;

//Algo Hard 
// Search for range
//O(log(N) time | O(1) space

public class SearchForRange {

	public static int[] searchForRange(int[] array, int target) {
		int start = 0;
		int end = array.length - 1;
		int mid;
		int[] retIdx = { -1, -1 };

		while (start <= end) {
			mid = (start + end) / 2;
			if (array[mid] == target) {
				if (mid == 0 || array[mid - 1] != target) {
					retIdx[0] = mid;
					break;
				}
			}

			if (target <= array[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		start = 0;
		end = array.length - 1;

		while (start <= end) {
			mid = (start + end) / 2;
			if (array[mid] == target) {
				if (mid == array.length - 1 || array[mid + 1] != target) {
					retIdx[1] = mid;
					break;
				}
			}

			if (target >= array[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return retIdx;

	}
}
