package com.java.algo;
//Algo Medium
//Longest Peak
//O(N) time | O(1) space 
//Algo has a different solution
public class LongestPeak {
	
	public static void main(String[] args) {
		int[] array = {1,3,2};
		System.out.println(longestPeak(array));
	}
	
	public static int longestPeak(int[] array) {
		int maxPeak = 0;
		int currPeak = 0;
		int direction = 0; // 0: flat; 1: increasing; -1: decreasing
		if (array.length < 3)
			return maxPeak;

		int i = 1;
		while (i < array.length) {
			while (i < array.length && array[i] <= array[i - 1]) {
				i++;
			}
			currPeak = 2;
			while (i < array.length && array[i] > array[i - 1]) {
				direction = 1;
				i++;
				currPeak++;
			}
			
			while (i < array.length && array[i] < array[i - 1]) {
				direction = -1;
				i++;
				currPeak++;
			}
			if (direction == -1) {
				maxPeak = Math.max(currPeak-1, maxPeak);
				currPeak = 2;
				direction = 0;
			}
		}
		return maxPeak;
	}

}
