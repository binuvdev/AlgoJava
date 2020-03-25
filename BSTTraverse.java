package com.java.algo;
import java.util.List;

//Algo Medium #6 

//All method will run 
//O(N) time | O(N) space because we storing the values in an array. Otherwise O(d) where d is the depth of the tree.

public class BSTTraverse {
  public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
		if (tree == null) return array;
		inOrderTraverse(tree.left, array);
		array.add(tree.value);
		inOrderTraverse(tree.right, array);
		return array;
  }
	

  public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
		if (tree == null) return array;
		array.add(tree.value);
		preOrderTraverse(tree.left, array);
		preOrderTraverse(tree.right, array);
		return array;
  }
  public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
		if (tree == null) return array;
		postOrderTraverse(tree.left, array);
		postOrderTraverse(tree.right, array);
		array.add(tree.value);
		return array;
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
