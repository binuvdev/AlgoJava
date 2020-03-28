package com.java.algo;

public class RemoveKthNodeFromEnd {
	
	// Algo Medium #18

	// Solution 1: O(N) time | O(1) space
	
	public static void removeKthNodeFromEnd(LinkedList head, int k) {
		LinkedList currentPtr = head;
		LinkedList runner = head;
		int counter = 1;
		while (counter <= k) {
			runner = runner.next;
			counter = counter + 1;
		}
		if (runner == null) {
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}

		while (runner.next != null) {
			currentPtr = currentPtr.next;
			runner = runner.next;
		}

		currentPtr.next = currentPtr.next.next;
		return;
	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}

}
