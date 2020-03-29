package com.java.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PowerSet {



// Algo Medium #20

// Solution 1: O(N*2^N) time | O(N*2^N) space


	public static void main(String[] args) {

		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(1);
		aList.add(2);
		aList.add(3);
		//aList.add(4);

		System.out.println(powerset(aList).stream().collect(Collectors.toList()));

	}

	public static List<List<Integer>> powerset(List<Integer> aList) {
		List<List<Integer>> retList = new ArrayList<List<Integer>>();
		retList.add(new ArrayList<Integer>());
		
		for(int i=0; i<aList.size();i++) {
			List<List<Integer>> moreEntries = new ArrayList<List<Integer>>();
			for(int j=0; j<retList.size();j++) {
				ArrayList<Integer> newEntry = new ArrayList<Integer>();
				newEntry.addAll(retList.get(j));
				newEntry.add(aList.get(i));
				moreEntries.add(newEntry);
			}
			retList.addAll(moreEntries);
		}
		return retList;
	}
	

}
