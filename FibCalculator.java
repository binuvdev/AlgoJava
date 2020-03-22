package com.java.algo;

//Algo Easy #6

public class FibCalculator {

	  public static int getNthFib(int n) {
	    int[] fibArray = new int[n+1];
			fibArray[0] = 0;
			fibArray[1] = 1;
			for (int i=2;i<=n;i++) {
				fibArray[i] = -1;
			}
			return getNthFib(n-1, fibArray);
	  }
		static int getNthFib(int n, int[] fibArray) {
			if (fibArray[n] != -1) return fibArray[n];
			fibArray[n] = getNthFib(n-2, fibArray) + getNthFib(n-1, fibArray);
			return fibArray[n];
		}
		
	}