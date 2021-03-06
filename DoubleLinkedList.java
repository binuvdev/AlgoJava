package com.java.algo;

public class DoubleLinkedList {

static class DoublyLinkedList {
 public Node head;
 public Node tail;

 public void setHead(Node node) {
		 
			if (head == null) {
				head = node;
				tail = node;
				return;
			} else {
				insertBefore(head,node);
			}
 }

 public void setTail(Node node) {
			if(tail == null) {
				setHead(node);
				return;
			} else {
				insertAfter(tail,node);
			}
 }

 public void insertBefore(Node node, Node nodeToInsert) {
			if (nodeToInsert == head && nodeToInsert == tail) return;
			remove(nodeToInsert);
			nodeToInsert.prev = node.prev;
			nodeToInsert.next = node;
			if (node.prev == null) {
				head = nodeToInsert;
			} else {
				node.prev.next = nodeToInsert;
			}	
			node.prev = nodeToInsert;
 }

 public void insertAfter(Node node, Node nodeToInsert) {
			if (nodeToInsert == head && nodeToInsert == tail) return;
			remove(nodeToInsert);
			nodeToInsert.prev = node;
			nodeToInsert.next = node.next;
			if (node.next == null) {
				tail = nodeToInsert;
			} else {
				node.next.prev = nodeToInsert;
			}
			node.next = nodeToInsert;
 }

 public void insertAtPosition(int position, Node nodeToInsert) {
			if (position == 1) {
				setHead(nodeToInsert);
				return;
			}
			
			Node aNode = head;
			int currentPos = 1;
   while (aNode != null && currentPos++  != position ) {
				aNode = aNode.next;
			}
			if (aNode != null) {
				insertBefore(aNode,nodeToInsert);
			} else {
				setTail(nodeToInsert);
			}
			
 }

 public void removeNodesWithValue(int value) {
			Node aNode = head;
   while(aNode != null ) {
				Node currNode = aNode;
				aNode = aNode.next;
				if (currNode.value == value) {
					remove(currNode);
				}
			}
		  
 }

 public void remove(Node node) {
	//	if (node == head && node == tail) {
		//		head = null;
		//		tail = null;
		//		return;
		//	}
			
			if (node == head) {
				head = head.next;
			} 
			
			if (node == tail) {
				tail = tail.prev;
			} 
			
			if (node.prev != null) node.prev.next = node.next;
			if (node.next != null) node.next.prev = node.prev;
			
			node.next = null;
			node.prev = null;
			
 }

 public boolean containsNodeWithValue(int value) {
			Node aNode = head;
   while(aNode != null && aNode.value != value) {
				aNode = aNode.next;
			}
			if (aNode != null) return true;
   return false;
 }
}

// Do not edit the class below.
static class Node {
 public int value;
 public Node prev;
 public Node next;

 public Node(int value) {
   this.value = value;
 }
}
}
