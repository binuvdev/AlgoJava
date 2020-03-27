package com.java.algo;

//Algo Medium #13
//O(N) time | O(N) space ; O(1) space solution is possible

import java.util.HashSet;

public class SingleCycle {

	public static void main(String[] args) {
		int[] array = { 1, 1, 1, 1, 2 };
		System.out.println(hasSingleCycle(array));
	}

	public static boolean hasSingleCycle(int[] array) {
		HashSet<Integer> aSet = new HashSet<Integer>();
		int index = 0;

		for (int i = 0; i < array.length; i++)
			aSet.add(i);
		while (!aSet.isEmpty()) {
			index = index + array[index];
			if (index < 0)
				while (index < 0)
					index = array.length + index;
			if (index > array.length - 1)
				while (index > array.length - 1)
					index = index - array.length;
			if (aSet.contains(index)) {
				aSet.remove(index);
			} else {
				break;
			}
		}
		return aSet.isEmpty();
	}


}
