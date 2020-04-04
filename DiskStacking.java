package com.java.algo;

//Algo Hard Disk Stacking
//O(MN) time | O(N) space

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiskStacking {
	
	public static void main(String[] args) {
		
		   List<Integer[]> input = new ArrayList<Integer[]>();
		    input.add(new Integer[] {2, 1, 2});
		    input.add(new Integer[] {3, 2, 3});
		    List<Integer[]> output = diskStacking(input);
		    for (Integer[] item : output) {
		    	 System.out.println(Arrays.toString(item)); 
		    }
		    
		   
	}

	public static List<Integer[]> diskStacking(List<Integer[]> disks) {

		disks.sort((disk1, disk2) -> disk1[2].compareTo(disk2[2]));
		int[] heights = new int[disks.size()];
		int[] indices = new int[disks.size()];
		Integer[] currentDisk;
		int currHeight;
		int maxHeightIdx = 0;
		Integer[] shortDisk;
		List<Integer[]> stackedDisks = new ArrayList<Integer[]>();

		for (int i = 0; i < heights.length; i++)
			heights[i] = disks.get(i)[2];
		for (int i = 0; i < indices.length; i++)
			indices[i] = -1;

		for (int i = 1; i < disks.size(); i++) {
			currentDisk = disks.get(i);
			currHeight = currentDisk[2];
			for (int j = 0; j < i; j++) {
				shortDisk = disks.get(j);
				if (validDiamentions(currentDisk, shortDisk)) {
					if (heights[i] <= heights[j] + currHeight) {
						heights[i] = heights[j] + currHeight;
						indices[i] = j;
					}
				}
			}

			if (heights[i] > heights[maxHeightIdx]) {
				maxHeightIdx = i;
			}

		}

		do {
			stackedDisks.add(0, disks.get(maxHeightIdx));
			maxHeightIdx = indices[maxHeightIdx];
		} while (maxHeightIdx != -1);

		return stackedDisks;

	}

	static boolean validDiamentions(Integer[] currDisk, Integer[] shortDisk) {
		return currDisk[0] > shortDisk[0] && currDisk[1] > shortDisk[1] && currDisk[2] > shortDisk[2];
	}

}
