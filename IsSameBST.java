package com.java.algo;

//Algo Hard #6 
//Same BST
//O(N^2) time | O(N^2) space

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsSameBST {

	public static void main(String[] args) {
		List<Integer> arrayOne = new ArrayList<Integer>(Arrays.asList(50, 76, 81, 23, 23, 23, 657, 56, 12, -1, 3));
		List<Integer> arrayTwo = new ArrayList<Integer>(Arrays.asList(50, 23, 76, 23, 23, 12, 56, 81, -1, 3, 657));

		System.out.println(sameBsts(arrayOne, arrayTwo));
	}

	public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
		if (arrayOne.size() != arrayTwo.size())
			return false;

		if (arrayOne.size() == 0 && arrayTwo.size() == 0)
			return true;

		if ((int) arrayOne.get(0) != (int) arrayTwo.get(0))
			return false;

		List<Integer> arrayOneLeft = new ArrayList<Integer>();
		List<Integer> arrayOneRight = new ArrayList<Integer>();
		List<Integer> arrayTwoLeft = new ArrayList<Integer>();
		List<Integer> arrayTwoRight = new ArrayList<Integer>();

		getArrays(arrayOne, arrayOneLeft, arrayOneRight);
		getArrays(arrayTwo, arrayTwoLeft, arrayTwoRight);

		return sameBsts(arrayOneLeft, arrayTwoLeft) && sameBsts(arrayOneRight, arrayTwoRight);

	}

	public static void getArrays(List<Integer> array, List<Integer> arrayLeft, List<Integer> arrayRight) {
		if (array == null || array.size() == 0)
			return;
		int root = array.get(0);
		for (int i = 1; i < array.size(); i++) {
			if (root > array.get(i)) {
				arrayLeft.add(array.get(i));
			} else {
				arrayRight.add(array.get(i));
			}
		}
	}

}
