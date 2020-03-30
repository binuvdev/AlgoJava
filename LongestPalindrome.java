package com.java.algo;

//Algo Medium 
//Find longest Palindrome
//O(N^2) time | O(1) space

// I tried to make the first method better (combining two while loops to one).  The second method is not 100% work.  I missed some edge cases, I guess.
// The First method is good and optimal.

public class LongestPalindrome {
	
	public static void main(String[] args) {
		//System.out.println(longestPalindromicSubstringOpt("abaxyzzyxf"));
		//System.out.println(longestPalindromicSubstringOpt("a"));
		System.out.println(longestPalindromicSubstringOpt("abcdefgfedcbazzzzzzzzzzzzzzzzzzzz"));
	}

	public static String longestPalindromicSubstring(String str) {
		int currMaxIndex = 0;
		int currMaxLength = 1;
		int oddLength = 1;
		int evenLength = -1;
		int currIndex = -1;
		
		if (str == null || str.length() == 0) return str;
		
		for (int i = 0; i < str.length(); i++) {
			oddLength = 1;
			evenLength = 0;
			currIndex = 1;
			while (i - currIndex >= 0 && i + currIndex < str.length()) {
				if (str.charAt(i - currIndex) == str.charAt(i + currIndex)) {
					oddLength += 1;
					currIndex += 1;
				} else {
					break;
				}
			}
			currIndex = 1;
			while (i - (currIndex - 1) >= 0 && i + currIndex < str.length()) {
				if (str.charAt(i - (currIndex - 1)) == str.charAt(i + currIndex)) {
					evenLength += 1;
					currIndex += 1;
				} else {
					break;
				}
			}

			if (oddLength > evenLength) {
				if ((oddLength * 2 ) - 1 > currMaxLength) {
					currMaxLength = (oddLength * 2 ) - 1;
					currMaxIndex = i - (oddLength - 1);
				}
			} else {
				if (evenLength * 2 > currMaxLength) {
					currMaxLength = evenLength * 2;
					currMaxIndex = i - (evenLength - 1);
				}
			}

		}

		return str.substring(currMaxIndex, currMaxIndex + currMaxLength);
	}

	public static String longestPalindromicSubstringOpt(String str) {
		int currMaxIndex = 0;
		int currMaxLength = 1;
		int oddLength = 1;
		int evenLength = -1;
		int currIndex = -1;
		
		if (str == null || str.length() == 0) return str;
		
		for (int i = 0; i < str.length(); i++) {
			oddLength = 1;
			evenLength = 0;
			currIndex = 1;
			while (i - currIndex >= 0 && i + currIndex < str.length()) {
				if (str.charAt(i - currIndex) == str.charAt(i + currIndex)) {
					oddLength += 1;
					currIndex += 1;
				} else {
					break;
				}
			}
			currIndex = 1;
			
			boolean evevCheck = true;
			boolean oddCheck = true;
			
			while (i - (currIndex - 1) >= 0 && i + currIndex < str.length()) {
				if ((str.charAt(i - (currIndex - 1)) == str.charAt(i + currIndex) && evevCheck)) {
					evenLength += 1;
				} else {
					evevCheck = false;
				}
				
				if (i - currIndex >= 0) {
					if ((str.charAt(i - currIndex) == str.charAt(i + currIndex) && oddCheck)) {
						oddLength += 1;
					} else {
						oddCheck = false;
					}
				}
				
				if (!evevCheck && !oddCheck) break;
				currIndex += 1;
			}

			if (oddLength > evenLength) {
				if ((oddLength * 2 ) - 1 > currMaxLength) {
					currMaxLength = (oddLength * 2 ) - 1;
					currMaxIndex = i - (oddLength - 1);
				}
			} else {
				if (evenLength * 2 > currMaxLength) {
					currMaxLength = evenLength * 2;
					currMaxIndex = i - (evenLength - 1);
				}
			}

		}

		return str.substring(currMaxIndex, currMaxIndex + currMaxLength);
	}

	
	
}
