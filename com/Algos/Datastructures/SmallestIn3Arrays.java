package com.Algos.Datastructures;

public class SmallestIn3Arrays {

	public static int smallestAmong3Arrays(int[] arr1, int[] arr2, int[] arr3) {
		int i = 0, j = 0, k = 0;
		

		
		while(i < arr1.length && j < arr2.length && k < arr3.length) {
			if(arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
				return arr1[i];
			}
			
			if(arr2[j] >= arr1[i] && arr3[k] >= arr1[i]) {
				i++;
			}
			else if(arr1[i] >= arr2[j] && arr3[k] >= arr2[j]) {
				j++;
			}
			else if(arr2[j] >= arr3[k] && arr1[i] >= arr3[k]) {
				k++;
			}
		}
		
		return -999;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = new int[] {1,2,3,4,5};
		int[] arr2 = new int[] {3,4,5,6,7};
		int[] arr3 = new int[] {5,6,7,8,9};
		
		int smallest = smallestAmong3Arrays(arr1, arr2, arr3);
		System.out.format("The smallest value common to all the three arrays is: %d", smallest);
	}

}
