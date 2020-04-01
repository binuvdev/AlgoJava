package com.java.algo;
//Algo Hard #1
//Four Number Sum
//O(N^2) time | O(N^2) space

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FourNumSum {
	
	public static void main(String[] args) {
		
		System.out.println(fourNumberSum(new int[] {1, 2, 3, 4, 5, 6, 7}, 10));
	}

	public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {

		if (array.length < 4)
			return null;

		List<Integer[]> quadruplets = new ArrayList<Integer[]>();
		HashMap<Integer, ArrayList<Integer[]>> sums = new HashMap<Integer, ArrayList<Integer[]>>();
		int currTarget;

		for (int i = 1; i < array.length-1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				currTarget = targetSum - (array[i] + array[j]);
				if (sums.containsKey(currTarget)) {
					ArrayList<Integer[]> currPairs = sums.get(currTarget);
					for (Integer[] aPair : currPairs) {
						quadruplets.add(new Integer[] { aPair[0], aPair[1], array[i], array[j] });
					}
				}
			}

			for (int j = 0; j < i; j++) {
				currTarget = array[i] + array[j];
				if (sums.containsKey(currTarget)) {
					ArrayList<Integer[]> currPairs = sums.get(currTarget);
					currPairs.add(new Integer[] { array[i], array[j] });
					sums.put(currTarget, currPairs);
				} else {
					ArrayList<Integer[]> currPairs = new ArrayList<Integer[]>();
					Integer[] aPair = { array[i], array[j] };
					currPairs.add(aPair);
					sums.put(currTarget, currPairs);
				}
			}
		}

		return quadruplets;
	}

}
