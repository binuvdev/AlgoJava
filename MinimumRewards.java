package com.java.algo;
//Algo Hard

public class MinimumRewards {

	public static void main(String[] args) {
		// System.out.println(minRewards(new int[] {800, 400, 20, 10, 30, 61, 70, 90,
		// 17, 21, 22, 13, 12, 11, 8, 4, 2, 1, 3, 6, 7, 9,
		// 0, 68, 55, 67, 57, 60, 51, 661, 50, 65, 53}));

		System.out.println(minRewards(new int[] { 8, 4, 2, 1, 3, 6, 7, 9, 5 }));
	}

	public static int minRewards(int[] scores) {
		int total = 1;
		int prevIncIndex = -1;
		int prevReward = 1;
		int[] rewards = new int[scores.length];
		rewards[0] = 1;
		for (int i = 1; i < scores.length; i++) {
			System.out.println(total);
			total = total + 1;
			rewards[i] = 1;
			if (scores[i] > scores[i - 1]) {
				prevIncIndex = i;

				rewards[i] = rewards[i] + prevReward;
				total = total + prevReward;
				prevReward = prevReward + 1;
			} else {
				// if (prevReward == 1) {
				// total++;
				// rewards[i-1] = rewards[i-1] + 1;
				// }
				total = total + (i - 1) - prevIncIndex + 1;
				for (int j = i - 1; j > prevIncIndex; j--) {
					rewards[j] = rewards[j] + 1;
				}
				if (prevIncIndex >= 0 && rewards[prevIncIndex + 1] >= rewards[prevIncIndex]) {
					rewards[prevIncIndex] = rewards[prevIncIndex + 1] + 1;
				}
				prevReward = 1;
			}

		}
		total = 0;
		for (int i : rewards) {
			System.out.print(i + ",");
			total = total + i;
		}

		return total;
	}
}
