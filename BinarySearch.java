package com.java.algo;

//Algo Easy # 8

public class BinarySearch {
	  public static int binarySearch(int[] array, int target) {
	   return  binarySearch(array,target,0,array.length-1);
	  }
		
		public static int binarySearch(int[] array, int target, int start, int end) {
			int mid = ( start + end ) / 2;
			
			if (end<start) return -1;
			if (array[mid] == target) return mid; 
			
			if (array[mid] < target) {
				return binarySearch (array,target,mid+1,end);
			} else {
				return binarySearch (array,target,start,mid-1);
			}
			
		}	
		
	}
