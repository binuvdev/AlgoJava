package com.java.algo;

//Algo Medium 

//Min Max Stack Construction

public class MinMaxStack {

	public static void main(String[] args) {
		MinMaxStack aStack = new MinMaxStack();
		aStack.push(5);
		System.out.println(aStack.getMin());
		System.out.println(aStack.getMax());
		System.out.println(aStack.peek());
		aStack.push(7);
		System.out.println(aStack.getMin());
		System.out.println(aStack.getMax());
		System.out.println(aStack.peek());
		aStack.push(2);
		System.out.println(aStack.getMin());
		System.out.println(aStack.getMax());
		System.out.println(aStack.peek());
		System.out.println(aStack.pop());
		System.out.println(aStack.pop());
		System.out.println(aStack.getMin());
		System.out.println(aStack.getMax());
		System.out.println(aStack.peek());

	}

	Node head;
//O(1) time | O(1) space
	public int peek() {
		if (head == null)
			return -1;
		return head.value;
	}

//O(1) time | O(1) space
	public int pop() {
		if (head == null)
			return -1;
		int valueToPop = head.value;
		head = head.next;
		return valueToPop;
	}

//O(1) time | O(1) space	
	public void push(Integer number) {
		Node aNode = new Node(number);
		if (head == null) {
			aNode.max = number;
			aNode.min = number;
			aNode.next = null;
			head = aNode;
		} else {
			aNode.max = head.max > number ? head.max : number;
			aNode.min = head.min < number ? head.min : number;
			aNode.next = head;
			head = aNode;
		}
	}

//O(1) time | O(1) space
	public int getMin() {
		if (head == null)
			return -1;
		return head.min;
	}
	
//O(1) time | O(1) space
	public int getMax() {
		if (head == null)
			return -1;
		return head.max;
	}

	class Node {
		int min;
		int max;
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}
}
