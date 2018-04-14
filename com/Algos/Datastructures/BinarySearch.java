package com.Algos.Datastructures;

public class BinarySearch {
	
	
	public static int BinarySearchRecursive(int low, int end, int[] arr, int key) {
		int mid = (low + end)/2;
		System.out.print("(Mid = "+ mid + ")(End = "+ end + ")(Low = "+ low + ")\n");
		System.out.print("Arr[Mid]" + arr[mid] + "  And Key = " + key + "\n");
		
		if(low > end) {
			return -1;
		}
		if(arr[mid] == key) {			
			return mid;
		} else if(key > arr[mid]) {
			BinarySearchRecursive(mid + 1, end, arr, key);		
			//System.out.print((mid + 1) + " " + end + " \n");
		} else {
			BinarySearchRecursive(low, mid - 1, arr, key);
//			/System.out.print(low + " " + (mid - 1) + " \n");
		}
		
		if(arr[mid] == key) {			
			return mid;
		}
		return -1;
	}
	
	public static int BinarySearchNonRecursive(int[] arr, int key) {
		int low = 0, high = arr.length - 1, mid = (low +high)/2;
		
		while(low<=high) {
			mid = (low +high)/2;
			if(key == arr[mid]) {
				return mid;
			}
			
			if(key > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			} 
		}
		
		
		
		return -1;
	}
	
	public static int BinarySearchS(int[] arr) {
		//return BinarySearchRecursive(0, arr.length-1, arr, 162);
		return BinarySearchNonRecursive(arr, 162);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sortedArr = new int[] {1 ,10,20,47,59,63,75,88,99,107,120,133,155,162,176,188,199,200,210,222};
		int keyIndex = BinarySearch.BinarySearchS(sortedArr);
		//System.out.println(keyIndex);
		if(keyIndex != -1)
			System.out.format("The Value %d is present at the index %d", sortedArr[keyIndex], keyIndex);
		else
			System.out.println("Key not found");
	}

}
