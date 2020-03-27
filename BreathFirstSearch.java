package com.java.algo;

//Algo Medium #14
//O(V+E) time | O(V) space : V - Vertices, E - Edges

import java.util.*;

public class BreathFirstSearch {

	static class Node {
		String name;
		List<Node> children = new ArrayList<Node>();

		public Node(String name) {
			this.name = name;
		}

		public List<String> breadthFirstSearch(List<String> array) {
			Node aNode = null;
			Queue<Node> aQueue = new LinkedList<Node>();
			aQueue.add(this);
			while (!aQueue.isEmpty()) {
				aNode = aQueue.remove();
				array.add(aNode.name);
				for (Node childNode : aNode.children)
					aQueue.add(childNode);
			}
			return array;
		}

		public Node addChild(String name) {
			Node child = new Node(name);
			children.add(child);
			return this;
		}
	}
}
