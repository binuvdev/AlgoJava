package com.java.algo;

//Algo Medium #21

//Solution 1: O(M+N) time | O(1) space

public class SearchSortedMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 4, 7, 12, 15, 1000 }, 
						   { 2, 5, 19, 31, 32, 1001 }, 
						   { 3, 8, 24, 33, 35, 1002 },
						   { 40, 41, 42, 44, 45, 1003 },
						   { 99, 100, 103, 106, 128, 1004 }, };

		System.out.println(searchInSortedMatrix(matrix, 99));

	}

	// Solution 1: O(M*N) time | O(1) space
	public static int[] searchInSortedMatrixTrivial(int[][] matrix, int target) {
		int[] position = { -1, -1 };
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == target) {
					position[0] = i;
					position[1] = j;
					return position;
				}
			}
		}
		return position;
	}

	// Solution 1: O(M+N) time | O(1) space
	public static int[] searchInSortedMatrix(int[][] matrix, int target) {

		int[] position = { -1, -1 };
		if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1])
			return position;
		int i = 0;
		int j = matrix[0].length - 1;

		while (i <= matrix.length - 1 && j >= 0) {
			if (matrix[i][j] == target) {
				position[0] = i;
				position[1] = j;
				return position;
			} else if (matrix[i][j] > target) {
				j--;
			} else {
				i++;
			}
		}

		return position;

	}

}
