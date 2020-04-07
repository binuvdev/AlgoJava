package com.java.algo;

//Algo Hard 
//Quick Select
//O(n) time | o(log(n)) space
//iterative solution in Algo which will run in O(1) space

public class QuickSelect {
	
	public static void main (String[] args) {
		int[] array = {1};
		System.out.println(quickSelect(array,0,array.length -1,1));
	}
	
	static int quickSelect(int[] array, int start, int end,int target) {
		//System.out.println("i=" + start + " j=" + end);
		int pivot = array[start];
		int i = start + 1;
		int j = end;
		while (j >= i) {
			if (array[i] > pivot && array[j] < pivot) {
				swap(array, i, j);
			}

			if (array[i] <= pivot)
				i++;

			if (array[j] >= pivot)
				j--;
		}
		
		if (j==target-1) return array[start]; 
		swap(array, start, j);
		if (j<target) {
			return quickSelect(array, j + 1, end,target);
		} else {
			return quickSelect(array, start, j - 1,target);
		}
		

	}

	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}

