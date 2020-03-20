package com.java.algo;

//Algo Easy Question 2
//

public class FindClosestBST {

  public static int findClosestValueInBst(BST tree, int target) {
    if (tree == null) return -1;
		return findClosestValueInBst(tree, target, Double.MAX_VALUE);
  }
	public static int findClosestValueInBst(BST tree, int target, double currentValue) {
		
		if (tree == null) return (int)currentValue;
		
		if (tree.value - target == 0) return tree.value;
		
		if (Math.abs(tree.value - target) < Math.abs(currentValue - target)) {
			currentValue = tree.value;
		}
		
		if (target < tree.value) {
			return (int)findClosestValueInBst(tree.left, target, currentValue);
		} else {
			return (int)findClosestValueInBst(tree.right, target, currentValue);
		}	
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
