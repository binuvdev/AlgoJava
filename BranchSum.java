package com.java.algo;
import java.util.*;
//Algo Easy Question - 3
public class BranchSum {

	  // This is the class of the input root. Do not edit it.
	  public static class BinaryTree {
	    int value;
	    BinaryTree left;
	    BinaryTree right;

	    BinaryTree(int value) {
	      this.value = value;
	      this.left = null;
	      this.right = null;
	    }
	  }

		
	  public static List<Integer> branchSums(BinaryTree aNode ) {
			if (aNode == null) return new ArrayList<Integer>();
			List<Integer> resList = new ArrayList<Integer>();
	  	if (aNode.left == null && aNode.right == null) {
				resList.add(aNode.value);
				return resList;
			}
			if (aNode.left != null) {
				List<Integer> leftList = branchSums(aNode.left);
				for(int i = 0; i < leftList.size(); i++) {
					resList.add(leftList.get(i) + aNode.value);
				}
			}
			if (aNode.right != null) {
				List<Integer> rightList = branchSums(aNode.right);
				for(int i = 0; i < rightList.size(); i++) {
					resList.add(rightList.get(i) + aNode.value);
				}
			}
			return resList;
	  }

		
	}
