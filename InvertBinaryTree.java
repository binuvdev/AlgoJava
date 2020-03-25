package com.java.algo;

//Algo Medium #7

//O(N) time | O(N) space because we storing the values in an array. Otherwise O(d) where d is the depth of the tree.

public class InvertBinaryTree {

	public static void invertBinaryTree(BinaryTree tree) {
		if (tree == null)
			return;
		if (tree.left != null)
			invertBinaryTree(tree.left);
		if (tree.right != null)
			invertBinaryTree(tree.right);
		BinaryTree tempTree = tree.left;
		tree.left = tree.right;
		tree.right = tempTree;
		return;
	}

	static class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
		}
	}
}
