package com.java.algo;
//Algo hard KnapSack
//O(MN) time | O(NM) space

import java.util.ArrayList;
import java.util.List;

public class KNAPSackAlgo {

	public static void main(String[] args) {
		//int[][] input = { { 1, 2 }, { 4, 3 }, { 5, 6 }, { 6, 7 } };
		
	    int[][] input = {
	    	      {465, 100},
	    	      {400, 85},
	    	      {255, 55},
	    	      {350, 45},
	    	      {650, 130},
	    	      {1000, 190},
	    	      {455, 100},
	    	      {100, 25},
	    	      {1200, 190},
	    	      {320, 65},
	    	      {750, 100},
	    	      {50, 45},
	    	      {550, 65},
	    	      {100, 50},
	    	      {600, 70},
	    	      {240, 40}
	    	    };

		System.out.println(knapsackProblem(input, 200));
	}

	public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
		// public static int knapsackProblem(int[][] items, int capacity) {
		int[][] matrix = new int[items.length + 1][capacity + 1];
		int numberOfitems = matrix.length;
		int weights = matrix[0].length;
		List<List<Integer>> itemsSelected = new ArrayList<List<Integer>>();
		List<Integer> totalWeight = new ArrayList<Integer>();
		List<Integer> aItem = new ArrayList<Integer>();

		for (int i = 1; i < numberOfitems; i++) {
			for (int j = 1; j < weights; j++) {
				if (j >= items[i - 1][1]) {
					matrix[i][j] = Math.max(matrix[i - 1][j], items[i - 1][0] + matrix[i - 1][j - items[i - 1][1]]);
				} else {
					matrix[i][j] = matrix[i - 1][j];
				}
			}
		}
		// return matrix[items.length][capacity];
		totalWeight.add(matrix[items.length][capacity]);
		

		int row = matrix.length - 1;
		int col = matrix[0].length - 1;

		while (col > 0 && row > 0) {

			while (row > 0 && matrix[row][col] == matrix[row - 1][col]) {
				row--;
			}
			
			if (row <= 0) break;
			//System.out.println(items[row - 1][1]);
			System.out.println(row - 1);

			aItem.add(0,row - 1);
			
			col = col - items[row - 1][1];
			row = row -1;
		}
		itemsSelected.add(0,aItem);
		itemsSelected.add(0,totalWeight);
		return itemsSelected;
	}


}
