package com.java.algo;

//Algo Medium #9

//O(N*d) time | O(N) space ; N is the target amount + d is the number of denominators

public class NumberOfWaysToMakeChange {
	public static int numberOfWaysToMakeChange(int n, int[] denoms) {
		int[] ways = new int[n + 1];
		ways[0] = 1; // if the target amount is 0, then we can make that in one way (not selecting
						// any coins)
		for (int i = 0; i < denoms.length; i++) {
			for (int j = 1; j < ways.length; j++) {
				if (j >= denoms[i]) {
					ways[j] = ways[j] + ways[j - denoms[i]];
				}
			}
		}
		return ways[n];
	}
}
