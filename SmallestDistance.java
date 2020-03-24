package com.java.algo;
//Algo Medium #2

import java.util.Arrays;

public class SmallestDistance {

	public static void main(String[] args) {

		int[] arrayOne = {-1,5,10,20,28,3};//{-1,5,10,20,3};
		int[] arrayTwo = {26,134,135,15,17};//{26,134,135,15,17};
		int[] returnArray = smallestDifference(arrayOne, arrayTwo);

		System.out.println(returnArray[0] + "," + returnArray[1]);
		
		returnArray = smallestDifferenceOpt(arrayOne, arrayTwo);

		System.out.println(returnArray[0] + "," + returnArray[1]);

	}

	//My solution; This runs O(N^2)
	
	public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
		int[] returnArray = { 0, 0 };
		int currDiff = Integer.MAX_VALUE;
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int i = 0;
		while (i < arrayOne.length) {
			int j = 0;
			while (j < arrayTwo.length) {
				if (Math.abs(arrayOne[i] - arrayTwo[j]) < currDiff) {
					currDiff = Math.abs(arrayOne[i] - arrayTwo[j]);
					returnArray[0] = arrayOne[i];
					returnArray[1] = arrayTwo[j];
					j++;
				} else {
					j++;
				}
			}
			i++;
		}
		return returnArray;
	}
	
	//Solution based on explanation:  This runs in O(NlogN + MlogM) time | O(1) space;  Time complexity is for sorting the arrays.
	
	
	public static int[] smallestDifferenceOpt(int[] arrayOne, int[] arrayTwo) {
		int[] returnArray = { 0, 0 };
		long smallestDiff = Long.MAX_VALUE;
		long currDiff = Long.MAX_VALUE;
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int indexOne = 0;
		int indexTwo = 0;
		while (indexOne<arrayOne.length && indexTwo<arrayTwo.length) {
			currDiff = Math.abs(arrayOne[indexOne] - arrayTwo[indexTwo]);
			if (currDiff < smallestDiff) {
				smallestDiff = currDiff;
				returnArray[0] = arrayOne[indexOne];
				returnArray[1] = arrayTwo[indexTwo];
			}

			if (arrayOne[indexOne] < arrayTwo[indexTwo]) {
				indexOne++;
			} else if (arrayTwo[indexTwo] < arrayOne[indexOne]) {
				indexTwo++;
			} else {
				return returnArray;
			}
			
		}
		
		return returnArray;
			
	}	
}















