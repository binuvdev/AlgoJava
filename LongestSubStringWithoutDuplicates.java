package com.java.algo;

import java.util.HashMap;

//Hard 
//Longest Substring without duplicate characters
//O(N) time | O(min(N,A)) ; N is the length of the input string and A is the number of unique characters in that string.
public class LongestSubStringWithoutDuplicates {

	public static String longestSubstringWithoutDuplication(String str) {
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		int[] subStrIdx = { 0, 1 };
		char[] charArray = str.toCharArray();
		int startIdx = 0;

		for (int i = 0; i < charArray.length; i++) {
			Character letter = charArray[i];

			if (charMap.containsKey(letter)) {
				int pos = charMap.get(letter);
				startIdx = Math.max(startIdx, pos + 1);
			}
			int currLength = subStrIdx[1] - subStrIdx[0];
			int newLength = i - startIdx + 1;
			if (newLength > currLength) {
				subStrIdx[0] = startIdx;
				subStrIdx[1] = i + 1;
			}

			charMap.put(letter, i);

		}

		return str.substring(subStrIdx[0], subStrIdx[1]);
	}

}
