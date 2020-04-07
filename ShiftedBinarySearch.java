package com.java.algo;

public class ShiftedBinarySearch {

//algo Hard 
//Shifted Binary Search:  In this case, one side is always ordered.  First find out that based on mid. 	
//O(log(N) time | O(log(N)) space	- because of recursion

	
	public static void main(String[] args) {

		int[] input = { 5, 23, 111, 1 };

		int target = 111;

		System.out.println(shiftedBinarySearch(input, target));

	}

	static int shiftedBinarySearch(int[] array, int target) {
		return shiftedBinarySearch(array, target, 0, array.length - 1);
	}

	//If left is less than mid, then left side is ordered. Otherwise right side is ordered.  Basically, in normal binary search, there are only two condition;
	//In shifted binary search, there are four conditions.
	
	static int shiftedBinarySearch(int[] array, int target, int left, int right) {

		if (right < left)
			return -1;

		int mid = (left + right) / 2;

		if (array[mid] == target)
			return mid;

		if (array[left] <= array[mid]) {
			if (target <= array[mid] && target >= array[left]) {
				return shiftedBinarySearch(array, target, left, mid);
			} else {
				return shiftedBinarySearch(array, target, mid + 1, right);
			}

		} else {
			if (target > array[mid] && target <= array[right]) {
				return shiftedBinarySearch(array, target, mid + 1, right);
			} else {
				return shiftedBinarySearch(array, target, left, mid);
			}
		}
	}
	
	static int shiftedBinarySearchIterative(int[] array, int target, int left, int right) {

		while(left<=right) {
	
			int mid = (left + right) / 2;
	
			if (array[mid] == target)
				return mid;
	
			if (array[left] <= array[mid]) {
				if (target < array[mid] && target >= array[left]) {
					right = mid -1;
				} else {
					left = mid + 1;
				}
	
			} else {
				if (target > array[mid] && target <= array[right]) {
					left =  mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		
		return -1;
	}	

}
