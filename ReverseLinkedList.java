package com.java.algo;

import java.util.ArrayList;
import java.util.List;
//Algo Hard
//O(N) time | O(1) space

public class ReverseLinkedList {

	public static void main(String[] args) {
		ReverseLinkedList.LinkedList test = newLinkedList(new int[] {0, 1});
		//List<Integer> result = toArrayList(ReverseLinkedList.reverseLinkedList(test));
		
		LinkedList result = reverseLinkedList(test);
		while(result != null) {
			System.out.println(result.value);
			result = result.next;
		}	

	}

	public static LinkedList reverseLinkedList(LinkedList head) {
		LinkedList first = head;
		if (first == null)
			return head;

		LinkedList second = first.next;
		first.next = null;

		while (second != null) {
			LinkedList third = second.next;
			second.next = first;
			first = second;
			second = third;
		}

		return first;

	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}

	public static LinkedList newLinkedList(int[] values) {
		LinkedList ll = new LinkedList(values[0]);
		LinkedList current = ll;
		for (int i = 1; i < values.length; i++) {
			current.next = new LinkedList(values[i]);
			current = current.next;
		}
		return ll;
	}

	public static List<Integer> toArrayList(LinkedList ll) {
		List<Integer> arr = new ArrayList<Integer>();
		LinkedList current = ll;
		while (current != null) {
			arr.add(current.value);
			current = current.next;
		}
		return arr;
	}

	public boolean arraysEqual(List<Integer> arr1, int[] arr2) {
		if (arr1.size() != arr2.length)
			return false;
		for (int i = 0; i < arr1.size(); i++) {
			if (arr1.get(i) != arr2[i])
				return false;
		}
		return true;
	}

}
