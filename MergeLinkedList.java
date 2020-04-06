package com.java.algo;

//Algo Hard
//O(N+M) time | O(1) space

public class MergeLinkedList {

	public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {

		LinkedList onePtr = headOne;
		LinkedList twoPtr = headTwo;
		if (onePtr == null)
			return headTwo;
		if (headTwo == null)
			return onePtr;
		LinkedList mergedList = onePtr.value < headTwo.value ? onePtr : headTwo;

		while (onePtr != null && twoPtr != null) {

			if (onePtr.value < twoPtr.value) {
				while (onePtr.next != null && onePtr.next.value < twoPtr.value) {
					onePtr = onePtr.next;
				}

				if (onePtr.next == null) {
					onePtr.next = twoPtr;
					onePtr = null;
				} else {
					LinkedList tempOne = onePtr.next;
					onePtr.next = twoPtr;
					onePtr = tempOne;
				}
			} else {

				while (twoPtr.next != null && twoPtr.next.value <= onePtr.value) {
					twoPtr = twoPtr.next;
				}
				if (twoPtr.next == null) {
					twoPtr.next = onePtr;
					twoPtr = null;
				} else {
					LinkedList tempTwo = twoPtr.next;
					twoPtr.next = onePtr;
					twoPtr = tempTwo;
				}

			}

		}

		return mergedList;

	}
	
	static class LinkedList {
		int value;
		LinkedList next;
		
		LinkedList(int value){
			this.value = value;
		}
		
	}

}
