package com.java.algo;

//Algo Medium #11

//O(M*N) time | O(M*N) space ; M and N are the lengths of the strings
//We can do this with O(min(M,N)) Space because at a time we are using only two rows of the array 


public class LevenshteinDistance {

	public static void main(String[] args) {

		System.out.println(levenshteinDistance("biting", "mitten"));

	}

	public static int levenshteinDistance(String str1, String str2) {
		if (str1.equalsIgnoreCase(str2))
			return 0;

		int[][] turns = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i < turns.length; i++)
			turns[i][0] = i;
		for (int i = 0; i < turns[0].length; i++)
			turns[0][i] = i;

		for (int i = 1; i < turns.length; i++) {
			for (int j = 1; j < turns[0].length; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					turns[i][j] = turns[i - 1][j - 1];
				} else {
					turns[i][j] = Math.min(Math.min(turns[i - 1][j], turns[i - 1][j - 1]), turns[i][j - 1]) + 1;
				}
			}
		}

		return turns[turns.length - 1][turns[0].length - 1];

	}
}
