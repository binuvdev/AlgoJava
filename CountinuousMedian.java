package com.java.algo;

import java.util.ArrayList;
import java.util.Collections;

public class CountinuousMedian {
	
	public static void main(String[] args) {
		
		ContinuousMedianHandler test = new ContinuousMedianHandler();
		test.insert(5);
		System.out.println(test.median);
		test.insert(10);
		System.out.println(test.median);
	}

	static class ContinuousMedianHandler {
		double median = 0;
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		public void insert(int number) {
			numbers.add(number);
			Collections.sort(numbers);
			if (numbers.size() % 2 == 1) {
				this.median = numbers.get(numbers.size() / 2);
			} else {
				this.median = (numbers.get((numbers.size() / 2) - 1) + numbers.get(numbers.size() / 2)) / 2.0;
			}
		}

		public double getMedian() {
			return median;
		}
	}

}
