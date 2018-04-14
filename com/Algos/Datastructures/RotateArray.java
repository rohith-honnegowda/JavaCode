package com.Algos.Datastructures;

import java.util.ArrayList;
import java.util.List;

public class RotateArray {

	public static void reverseList(int[] list, int start, int end) {
		while(start < end) {
			int temp = list[start];
			list[start] = list[end];
			list[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void reverseInPlace(int[] list, int n) {
		int len = list.length;
		n = n % len;
		if(n < 0) {
			n = n + len;
		}
		
		reverseList(list, 0, len-1);
		reverseList(list, 0, n - 1);
		reverseList(list, n, len - 1);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> testArr = new ArrayList<Integer>();
		int[] te = new int[] {1,2,3,4,5,6,7,8,9};
		for(int i : te){
			testArr.add(i);
		}
		for(int i : te) {
			System.out.print(i + " ");
		}
		System.out.println();
		reverseInPlace(te, 1);
		for(int i : te) {
			System.out.print(i + " ");
		}
		System.out.println();
	}


}
