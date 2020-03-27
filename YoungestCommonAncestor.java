package com.java.algo;

import java.util.HashSet;

public class YoungestCommonAncestor {

	// Algo Medium #16

	// Solution 1: O(d) time | O(d) space : d is the depth of the lowest node

	public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne,
			AncestralTree descendantTwo) {
		if (topAncestor == null || descendantOne == null || descendantTwo == null)
			return null;
		HashSet<AncestralTree> setOfAncestors = new HashSet<AncestralTree>();
		setOfAncestors.add(descendantOne);
		while (descendantOne.ancestor != null) {
			descendantOne = descendantOne.ancestor;
			setOfAncestors.add(descendantOne);
		}
		while (descendantTwo != null) {
			if (setOfAncestors.contains(descendantTwo))
				return descendantTwo;
			descendantTwo = descendantTwo.ancestor;
		}
		return null;
	}
	
	
	// Solution 2: O(d) time | O(1) space : d is the depth of the lowest node
	public static AncestralTree getYoungestCommonAncestorOpt(AncestralTree topAncestor, AncestralTree descendantOne,
			AncestralTree descendantTwo) {
		if (topAncestor == null || descendantOne == null || descendantTwo == null)
			return null;
		int depthOne = 0;
		int depthTwo = 0;
		AncestralTree firstTree = descendantOne;
		AncestralTree SecondTree = descendantTwo;
		int diff = 0;

		depthOne = getDepth(firstTree);
		depthTwo = getDepth(SecondTree);

		diff = Math.abs(depthOne - depthTwo);

		if (depthOne > depthTwo) {
			return findCommonAncestor(descendantOne, descendantTwo, diff);
		} else {
			return findCommonAncestor(descendantTwo, descendantOne, diff);
		}

	}

	static AncestralTree findCommonAncestor(AncestralTree deeperNode, AncestralTree nonDeeperNode, int diff) {
		while (diff > 0) {
			deeperNode = deeperNode.ancestor;
			diff -= 1;
		}

		while (deeperNode != nonDeeperNode) {
			deeperNode = deeperNode.ancestor;
			nonDeeperNode = nonDeeperNode.ancestor;
		}

		return deeperNode;

	}

	static int getDepth(AncestralTree aTree) {
		int depth = 1;
		while (aTree.ancestor != null) {
			depth++;
			aTree = aTree.ancestor;
		}

		return depth;

	}

	static class AncestralTree {
		public char name;
		public AncestralTree ancestor;

		AncestralTree(char name) {
			this.name = name;
			this.ancestor = null;
		}

		// This method is for testing only.
		void addAsAncestor(AncestralTree[] descendants) {
			for (AncestralTree descendant : descendants) {
				descendant.ancestor = this;
			}
		}
	}
}
