package com.java.algo;
//Algo Hard #9
//O(MN) time | O(MN) space
//This is a clean solution
import java.util.ArrayList;
import java.util.List;

public class LogestCommonSubsequence {

	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
				"CCCDDEGDHAGKGLWAJWKJAWGKGWJAKLGGWAFWLFFWAGJWKAG"));
		// System.out.println(longestCommonSubsequence("clement", "antoine"));
	}

	public static List<Character> longestCommonSubsequence(String str1, String str2) {
		List<Character> listOfChars = new ArrayList<Character>();
		int[][] matrix = new int[str1.length() + 1][str2.length() + 1];

		char[] str1Char = str1.toCharArray();
		char[] str2Char = str2.toCharArray();
		int row = 0;
		int col = 0;
		for (int i = 0; i < str1Char.length; i++) {
			row++;
			col = 0;
			for (int j = 0; j < str2Char.length; j++) {
				col++;
				if (str1Char[i] != str2Char[j]) {
					matrix[row][col] = Math.max(matrix[row][col - 1], matrix[row - 1][col]);
				} else {					
					matrix[row][col] = Math.max(matrix[row - 1][col - 1] + 1,Math.max(matrix[row][col - 1], matrix[row - 1][col]));
				}
			}
		}

		row = matrix.length - 1;
		col = matrix[0].length - 1;

		while (row > 0 && col > 0) {
			while (row > 0 && matrix[row][col] == matrix[row - 1][col]) {
				row--;
			}

			while (col > 0 && row > 0 && matrix[row][col] == matrix[row][col - 1]) {
				col--;
			}

			if (col > 0) {
				listOfChars.add(0, str2Char[col - 1]);
			}
			row--;

			if (matrix[row][col] == 0)
				break;

		}

		return listOfChars;
	}

}
