package com.java.algo;

import java.util.*;

public class ReverSizeCalculator {
	
	//Algo Medium #15
	//O(WH) time | O(WH) space : W - width, H - Height

	public static List<Integer> riverSizes(int[][] matrix) {
		boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
		int currSize = 0;
		List<Integer> reverSizes = new ArrayList<Integer>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				currSize = riverSizes(matrix, isVisited, i, j);
				if (currSize > 0) {
					reverSizes.add(currSize);
				}
			}
		}
		return reverSizes;
	}

	public static int riverSizes(int[][] matrix, boolean[][] isVisited, int i, int j) {
		if (isVisited[i][j])
			return 0;
		isVisited[i][j] = true;
		if (matrix[i][j] == 0)
			return 0;
		int size = 1;
		if (i + 1 < matrix.length) {
			size += riverSizes(matrix, isVisited, i + 1, j);
		}
		if (j + 1 < matrix[0].length) {
			size += riverSizes(matrix, isVisited, i, j + 1);
		}
		if (i - 1 >= 0) {
			size += riverSizes(matrix, isVisited, i - 1, j);
		}
		if (j - 1 >= 0) {
			size += riverSizes(matrix, isVisited, i, j - 1);
		}
		return size;
	}

}
