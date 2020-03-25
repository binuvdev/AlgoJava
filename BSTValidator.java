package com.java.algo;

//Algo Medium #5

//O(N) time | O(d) space.  d: depth of the tree

public class BSTValidator {
	public static boolean validateBst(BST tree) {
		if (tree == null)
			return false;
		return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean validateBst(BST tree, int min, int max) {
		boolean leftValid = true;
		boolean rightValid = true;
		if (tree.value < min || tree.value >= max)
			return false;
		if (tree.left != null)
			leftValid = validateBst(tree.left, min, tree.value);
		if (tree.right != null)
			rightValid = validateBst(tree.right, tree.value, max);
		return leftValid && rightValid;
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
	}
}
