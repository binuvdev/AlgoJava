package com.java.algo;

//Algo Medium
//O(N^2) time | O(N^2) space

import java.util.*;

public class SuffixTrie {

	TrieNode root = new TrieNode();
	char endSymbol = '*';

	static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	}

	public SuffixTrie(String str) {
		populateSuffixTrieFrom(str);
	}

	public void populateSuffixTrieFrom(String str) {
		
		for (int i=0;i<str.length();i++) {
			populateSuffix(i,str);
		}
	}
//O(N^2) time | O(N^2) space	
	void populateSuffix(int start, String str){
		
		TrieNode node = this.root;
		for(int i=start; i<str.length(); i++) {
			char aChar = str.charAt(i);
			if (node.children.containsKey(aChar)) {
				node = node.children.get(aChar);
			} else {
				TrieNode newNode = new TrieNode();
				node.children.put(aChar, newNode);
				node = newNode;
			}
		}
		TrieNode newNode = new TrieNode();
		node.children.put(this.endSymbol, newNode);
	}
	
//O(N) time | O(1) space
	public boolean contains(String str) {
		TrieNode node = this.root;
		for (int i=0; i<str.length();i++) {
			if (node.children.containsKey(str.charAt(i))) {
				node = node.children.get(str.charAt(i));
			} else {
				return false;
			}
		}
		return node.children.containsKey(this.endSymbol);
	}
}
