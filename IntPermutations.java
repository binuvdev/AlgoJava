package com.java.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Algo Medium #19

// Solution 1: O(N*N!) time | O(N*N!) space

public class IntPermutations {

	public static void main(String[] args) {

		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(1);
		aList.add(2);
		aList.add(3);

		System.out.println(getPermutations(aList).stream().collect(Collectors.toList()));

	}

	public static List<List<Integer>> getPermutations(List<Integer> aList) {
		List<List<Integer>> retList = new ArrayList<List<Integer>>();
		if (aList == null || aList.size() == 0)
			return retList;

		getPermutations(0, aList, retList);

		return retList;
	}

	static void getPermutations(int start, List<Integer> aList, List<List<Integer>> retList) {

		if (start == aList.size() - 1) {
			retList.add(new ArrayList<Integer>(aList));
		} else {
			for (int i = start; i < aList.size(); i++) {
				swap(aList, start, i);
				getPermutations(start + 1, aList, retList);
				swap(aList, start, i);
			}
		}
	}

	static void swap(List<Integer> aList, int i, int j) {
		int temp = aList.get(i);
		aList.set(i, aList.get(j));
		aList.set(j, temp);
	}

}
