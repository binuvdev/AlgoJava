package com.java.algo;

//Algo Medium #10

//O(N*d) time | O(N) space ; N is the target amount + d is the number of denominators

public class MinNumberOfCoins {

	public static void main(String[] args) {

		int[] denoms = { 4 };
		System.out.println(minNumberOfCoinsForChange(5, denoms));

	}

	public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		int[] NumberOfcoins = new int[n + 1]; // coins[0] is already initialized to 0. This means that to make a target
												// of $0, number of coins is always 0
		int coinsWithCurrDenom = 0;
		for (int i = 1; i < NumberOfcoins.length; i++) {
			NumberOfcoins[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < denoms.length; i++) {
			for (int j = 1; j < NumberOfcoins.length; j++) { //We can start j = denoms[i] as well
				if (j >= denoms[i]) { // current target sum (j) is getter than or equal to current denoms (denoms[i])
					// Set current number of coins = Number of coins with out using this denominator
					// or Number of coins using this denominator, whichever is smaller
					if (NumberOfcoins[j - denoms[i]] == Integer.MAX_VALUE) {
						coinsWithCurrDenom = Integer.MAX_VALUE;
					} else {
						coinsWithCurrDenom = NumberOfcoins[j - denoms[i]] + 1;
					}

					NumberOfcoins[j] = Math.min(NumberOfcoins[j], coinsWithCurrDenom);
				}
			}
		}
		return NumberOfcoins[n] == Integer.MAX_VALUE ? -1 : NumberOfcoins[n];
	}
}
