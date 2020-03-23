package com.java.algo;

//Algo Easy #13

// O(N) time | O(1) space

public class Palindrome {

	public static boolean isPalindrome(String str) {
		if (str == null || str.length() == 0)
			return true;
		int i = 0;
		int j = str.length() - 1;

		while (i <= j) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
