package com.java.algo;

//Algo Medium

//Balanced brackets
//O(N) time | O(N) space
//We can declare a HashMap to store open and close brackets to clean the code 

import java.util.Stack;

public class BalanceBrackets {

	public static boolean balancedBrackets(String str) {
		Stack<Character> aStack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char aChar = str.charAt(i);
			if (aChar == '{' || aChar == '[' || aChar == '(') {
				aStack.push(aChar);
			}
			if (aChar == '}') {
				if (aStack.isEmpty() || (aStack.pop() != '{'))
					return false;
			}
			if (aChar == ']') {
				if (aStack.isEmpty() || (aStack.pop() != '['))
					return false;
			}
			if (aChar == ')') {
				if (aStack.isEmpty() || (aStack.pop() != '('))
					return false;
			}
		}
		return aStack.isEmpty();

	}

}
