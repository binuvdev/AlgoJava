package com.java.algo;

//Algo Medium #8

//O(N) time | O(1) space 

public class MaxSumSubSetNoAdjacent {

	public static int maxSubsetSumNoAdjacent(int[] array) {
		int withMax = 0; //Maximum Sum with current Value
		int withOutMax = 0; //Maximum Sum with out current Value
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			temp = withMax;
			withMax = Math.max(withMax, withOutMax + array[i]);
			withOutMax = temp;
		}
		return withMax;
	}
}
