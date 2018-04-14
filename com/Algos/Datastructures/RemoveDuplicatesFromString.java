package com.Algos.Datastructures;

import java.util.HashSet;

public class RemoveDuplicatesFromString {
	
	public static void removeDuplicatesFromString(char[] str) {
		HashSet<Character> uniqueChars = new HashSet<Character>();
		int readPtr = 0;
		int writePtr = 0;
		while(readPtr < str.length) {
			if(!uniqueChars.contains(str[readPtr])) {
				uniqueChars.add(str[readPtr]);
				str[writePtr] = str[readPtr];
				writePtr++;
			}
			readPtr++;
		}
		str[writePtr] = '\0'; 
		for(int i = 0; str[i] != '\0'; i++) {
			System.out.print(str[i]);
		}
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		String test = "aaabbhhsggcyyeippajdhhflsaass";
		char[] testarr = test.toCharArray();
		System.out.println(testarr);
		removeDuplicatesFromString(testarr);
		
		
	}

}
