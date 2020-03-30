package com.java.algo;

//Algo Medium 
//Group Anagram

//O(w*nlogn) time | O(w*n) space : w is the number of words and n is maximum number of character in any word

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramFinder {


public static List<List<String>> groupAnagrams(List<String> words) {
	  
	  HashMap<String,ArrayList<String>> anagrams = new HashMap<String,ArrayList<String>>();
	  
	  for(String str : words) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
	  	String sortedStr =  new String(charArray);
	  	if (anagrams.containsKey(sortedStr)) {
	  		ArrayList<String> listOfWords = anagrams.get(sortedStr);
	  		listOfWords.add(str);
	  		anagrams.put(sortedStr,listOfWords);
	  	} else {
	  		ArrayList<String> newEntry = new ArrayList<String>();
	  		newEntry.add(str);
	  		anagrams.put(sortedStr,newEntry);
	  	}	
	  }
	  List<List<String>> retList = new ArrayList<List<String>>();
	  for(Map.Entry<String,ArrayList<String>> item : anagrams.entrySet()) {
	  	retList.add(item.getValue());
	  }
	  return retList;
	}
}