package com.java.algo;

//Algo Hard #5
//ZigZag Traverse
//O(N) time | O(N) space 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagTraverse {

	public static void main(String[] args) {

		List<List<Integer>> test = new ArrayList<List<Integer>>();
		test.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
		test.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
		test.add(new ArrayList<Integer>(Arrays.asList(5, 7)));
		test.add(new ArrayList<Integer>(Arrays.asList(6, 8)));
		test.add(new ArrayList<Integer>(Arrays.asList(9, 10)));

		System.out.println(zigzagTraverse(test));

	}

	public static List<Integer> zigzagTraverse(List<List<Integer>> array) {

		List<Integer> oneList = new ArrayList<Integer>();

		if (array == null || array.get(0) == null || array.get(0).size() == 0)
			return oneList;

		oneList.add(array.get(0).get(0));

		int i = 0, j = 0;

		while (i < array.size() - 1 || j < array.get(0).size() - 1) {
			if (i < array.size() - 1) {
				i = i + 1;
				oneList.add(array.get(i).get(j));
			} else if (j < array.get(0).size() - 1) {
				j = j + 1;
				oneList.add(array.get(i).get(j));
			}

			while (i > 0 && j < array.get(0).size() - 1) {
				i = i - 1;
				j = j + 1;
				oneList.add(array.get(i).get(j));
			}

			if (j < array.get(0).size() - 1) {
				j = j + 1;
				oneList.add(array.get(i).get(j));
			} else if (i < array.size() - 1) {
				i = i + 1;
				oneList.add(array.get(i).get(j));
			}

			while (i < array.size() - 1 && j > 0) {
				i = i + 1;
				j = j - 1;
				oneList.add(array.get(i).get(j));
			}
		}

		return oneList;

	}

}
