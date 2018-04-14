package com.Algos.Datastructures;

public class LowHighIndices {
	
	public static void printHighsAndLows(int[] arr, int testVal) {
		int high = -1;
		int low = -1;
		
		for(int i = 0; i < arr.length; i++) {
			if((i + 1) == arr.length) {
				break;
			}
			if(arr[i] != testVal) {
				continue;
			}
			low = i;
			while(arr[i] == arr[i + 1]) {
				i++;
				if((i + 1) == arr.length) {
					break;
				}
			}
			high = i;
			System.out.format("Value = %d Lowest index = %d Highest index = %d\n", arr[i], low, high);
		}
		//System.out.format("Value = %d Lowest index = %d Highest index = %d\n", arr[high], low, high);
		
	}
	
	
	public static int BinarySearchLow(int[] arr, int val) {
		int low = 0, high = arr.length - 1, mid = (low +high)/2;
		
		while(low<=high) {
			mid = (low +high)/2;
			
			if(val > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			} 
		}
		
		if(arr[low] == val) {
			return low;
		}
		return -1;
	}
	
	public static int BinarySearchHigh(int[] arr, int val) {
		int low = 0, high = arr.length - 1, mid = (low +high)/2;
		
		while(low<=high) {
			mid = (low +high)/2;
			
			if(val > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			} 
		}
		
		if(arr[high] == val) {
			return high;
		}
		return -1;
	}
	
	public static void printHighLowUsingBS(int[] arr, int val) {
		int high = BinarySearchHigh(arr, val);
		int low = BinarySearchLow(arr, val);
		
		System.out.format("Value = %d Lowest index = %d Highest index = %d\n", arr[low], low, high);
				
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{1,2,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,6,7,7,7,7,7,8,8};
		printHighsAndLows(arr, 6);
		printHighLowUsingBS(arr, 5);
	}

}
