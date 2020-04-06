package com.java.algo;

import java.util.HashSet;

public class FindLoop {

	public static void main(String[] args) {
		TestLinkedList test4 = new TestLinkedList(0);
		test4.addMany(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		test4.getNthNode(10).next = test4.getNthNode(3);

		System.out.println(test4.getNthNode(10).next.value);
		LinkedList aNode = findLoop(test4);

		System.out.println(aNode.value);

	}

	public static LinkedList findLoopNotOptimal(LinkedList head) {
		HashSet<LinkedList> aSet = new HashSet<LinkedList>();
		LinkedList aNode = head;
		System.out.println("===========");
		while (!aSet.contains(aNode)) {
			System.out.println(aNode.value);
			aSet.add(aNode);
			aNode = aNode.next;
		}
		System.out.println("===========");
		System.out.println(aNode.value);
		System.out.println();
		LinkedList current = head;
		LinkedList runner = head.next.next;
		int i = 0;
		while (current != runner) {
			System.out.println("current: " + current.value + "|runner: " + runner.value);
			current = current.next;
			runner = runner.next.next;
			i++;
		}
		System.out.println("current: " + current.value + "|runner: " + runner.value);

		return current;
	}

	public static LinkedList findLoop(LinkedList head) {
		LinkedList current = head.next;
		LinkedList runner = head.next.next;

		while (current != runner) {
			System.out.println("current: " + current.value + "|runner: " + runner.value);
			current = current.next;
			runner = runner.next.next;
		}
		System.out.println("current: " + current.value + "|runner: " + runner.value);
		current = head;
		while (current != runner) {
			current = current.next;
			runner = runner.next;
		}

		return current;
	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}

	static class TestLinkedList extends LinkedList {
		public TestLinkedList(int value) {
			super(value);
		}

		public void addMany(int[] values) {
			LinkedList current = this;
			while (current.next != null) {
				current = current.next;
			}
			for (int value : values) {
				current.next = new LinkedList(value);
				current = current.next;
			}
		}

		public LinkedList getNthNode(int n) {
			int counter = 1;
			LinkedList current = this;
			while (counter < n) {
				current = current.next;
				counter++;
			}
			return current;
		}

	}
}
