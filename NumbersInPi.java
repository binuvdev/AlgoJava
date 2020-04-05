package com.java.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NumbersInPi {

	public static void main(String[] args) {
		String PI = "3141592653589793238462643383279";
		String[] numbers = new String[] { "314159265358979323846264338327", "9" };
		System.out.println(numbersInPi(PI, numbers));

	}

	public static int numbersInPi(String pi, String[] numbers) {

		HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
		List<String> numberList = new ArrayList<String>();
		for (String s : numbers)
			numberList.add(s);

		int minSpaces = numbersInPi(pi, numberList, cache, 0);

		return minSpaces == Integer.MAX_VALUE ? -1 : minSpaces;

	}

	public static int numbersInPi(String pi, List<String> numberList, HashMap<Integer, Integer> cache, int start) {
		if (start == pi.length())
			return -1;

		if (cache.containsKey(start))
			return cache.get(start);

		int minSpaces = Integer.MAX_VALUE;

		for (int i = start; i < pi.length(); i++) {
			String prefix = pi.substring(start, i + 1);
			if (numberList.contains(prefix)) {
				int minSpaceForCurrSuffix = numbersInPi(pi, numberList, cache, i + 1);
				if (minSpaceForCurrSuffix == Integer.MAX_VALUE) {
					minSpaces = Math.min(minSpaceForCurrSuffix, minSpaces);
				} else {
					minSpaces = Math.min(minSpaceForCurrSuffix + 1, minSpaces);
				}
			}
		}

		cache.put(start, minSpaces);
		return minSpaces;
	}

}
