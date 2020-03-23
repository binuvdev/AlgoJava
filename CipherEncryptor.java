package com.java.algo;
//Algo Easy #14

//O(N) time | O(N) space
public class CipherEncryptor {

	public static void main (String[] args) {
		System.out.println(caesarCypherEncryptor("xyz",2));
		
		System.out.println((char) 97);
	}
	public static String caesarCypherEncryptor(String str, int key) {
		char[] decryptedStr = str.toCharArray();
		for (int i = 0; i < decryptedStr.length; i++) {
			char aChar = decryptedStr[i];
			int index = aChar - 'a';
			index = (index + key) % 26;
			decryptedStr[i] = (char) (index + 'a');
		}
		return new String(decryptedStr);
	}
}
