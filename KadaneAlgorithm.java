package com.java.algo;

//Algo Medium #12
//O(N) time | O(1) space

public class KadaneAlgorithm {
	public static int kadanesAlgorithm(int[] array) {
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;
		for (int i = 0; i < array.length; i++) {
			currSum += array[i];
			if (currSum > maxSum)
				maxSum = currSum;
			if (currSum < 0)
				currSum = 0;
		}
		return maxSum;
	}

}
