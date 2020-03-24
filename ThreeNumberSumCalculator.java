package com.java.algo;

//Algo Medium #1

// O(N^2) time | O(N) space

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSumCalculator {
	
	public static void main(String[] args) {
		
		int[] input = {12,3,1,2,-6,5,-8,6};
		List<Integer[]> aList = threeNumberSum(input,0);
		System.out.println(aList);
		 
		
	}
	
	public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		if(array == null || array.length < 3) return new ArrayList<Integer[]>();
		Arrays.sort(array);
		ArrayList<Integer[]> retList = new ArrayList<Integer[]>();
		for(int i=0; i<array.length-2; i++) {
			int left = i+1;
			int right = array.length-1;
			while (right>left) {
				int curSum = array[i]+array[left]+array[right];
				if (curSum==targetSum) {
					retList.add(new Integer[] {array[i],array[left],array[right]});
					left +=1;
					right -=1;
				}
				if (curSum<targetSum) left +=1;
				if (curSum>targetSum) right -=1;
			}
		}
		return retList;
	}

}
