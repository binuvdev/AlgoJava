package com.java.algo;

//Algo Hard #11
//O(N) time | O(N) space
//We don't need water array.  We can do this in one array and two for loop.  This will not change time and space complexity.

public class WaterAreaCalcuator {

	static int waterArea(int[] pillars) {
		int[] leftMax = new int[pillars.length];
		int[] rightMax = new int[pillars.length];
		int[] water = new int[pillars.length];
		int currentMax = 0;
		int minHeight = 0;
		int totalWater = 0;

		// find Left Max
		for (int i = 0; i < pillars.length; i++) {
			leftMax[i] = currentMax;
			if (pillars[i] > currentMax) {
				currentMax = pillars[i];
			}
		}

		// find right Max
		currentMax = 0;
		for (int i = pillars.length - 1; i >= 0; i--) {
			rightMax[i] = currentMax;
			if (pillars[i] > currentMax) {
				currentMax = pillars[i];
			}
		}

		for (int i = 0; i < pillars.length; i++) {
			minHeight = Math.min(leftMax[i], rightMax[i]);
			if (minHeight > pillars[i]) {
				totalWater = totalWater + (minHeight - pillars[i]);
				water[i] = minHeight - pillars[i];
			} else {
				water[i] = 0;
			}
		}

		return totalWater;
	}

}
