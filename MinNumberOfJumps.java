package com.java.algo;

//Algo Hard #10
//O(N^2) time | O(N) space
public class MinNumberOfJumps {

	public static int minNumberOfJumps(int[] array) {
		int[] jumps = new int[array.length];
		for (int i = 1; i < jumps.length; i++)
			jumps[i] = Integer.MAX_VALUE;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] + j >= i) {
					jumps[i] = Math.min(jumps[j] + 1, jumps[i]);
				}
			}
		}

		return jumps[jumps.length - 1];
	}

}
