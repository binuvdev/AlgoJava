package com.java.algo;

//Algo Easy #9

public class ThreeLargestNumbers {

public static int[] findThreeLargestNumbers(int[] array) {
		//Easy Solution
		//Arrays.sort(array);
		//return new int[] {array[array.length - 3],array[array.length - 2],array[array.length - 1]};
		int retArray[] = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
		int j;
		for(int i : array) {
			for (j = 2; j >= 0; j--) {
				if (i >= retArray[j]) {
					break;
				}
			}
			if (j>=0) {
				shiftElements(retArray, i, j);
			}
		}
		return retArray;
  }
	static void shiftElements(int[] retArray, int newElement, int pos) {
		for (int i=0; i <pos; i++) {
			retArray[i] = retArray[i+1];
		}	
			retArray[pos] = newElement;
	}
	
}
