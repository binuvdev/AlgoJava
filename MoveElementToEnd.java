package com.java.algo;

//ALgo Medium #3

// O(N) time | O(1) space
import java.util.*;

class Program {
	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		if (array == null || array.size() == 0) return array;	
		int startIdx = 0;
		int endIdx = array.size() - 1;
		
		while(endIdx>startIdx) {
			while (endIdx>startIdx && array.get(endIdx) == toMove) endIdx--;
			if (array.get(startIdx) == toMove) {
				swap(array,startIdx,endIdx);
			}
			startIdx++;
		}
		return array;
	}

	static void swap(List<Integer> array, int i, int j) {
		int temp = array.get(i);
		array.set(i,array.get(j));
		array.set(j,temp);

	}
}
