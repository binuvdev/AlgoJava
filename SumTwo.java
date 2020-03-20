package com.java.algo;
import java.util.HashSet;

//Algo Easy Question 1
//

public class SumTwo {
  public static int[] twoNumberSum(int[] array, int targetSum) {
		if (array == null) return new int[] {};
		
		if (array.length < 2) return new int[] {};
		HashSet<Integer> aSet = new HashSet<Integer>();
		for(int i : array) {
			if (aSet.contains(targetSum - i)) {
				return new int[] {i,targetSum - i};
			} else {
				aSet.add(i);
			}
		}
    return new int[] {};
  }
}
