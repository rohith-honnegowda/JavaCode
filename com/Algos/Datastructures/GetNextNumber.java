package com.Algos.Datastructures;

import java.io.*;
import java.util.*;

public class GetNextNumber {

  //naive solution (Modifying the array)
  //Sort the array
  //iterate through the arr for its length
  // i - arr[i]  != 0 2 - 3 = -1
  static int getDifferentNumberWithoutSorting(int[] arr) {
	  Hashtable<Integer, Integer> retrieve = new Hashtable<Integer, Integer>();
	  
	  for(int i = 0; i < arr.length; i++) {
		  retrieve.put(arr[i], i);
	  }
	  
	  for(int i = 0; i < arr.length; i++) {
		  if(!retrieve.containsKey(i)) {
/*			  continue;
			  }
		  else {*/
			  return i;
		  }
	  }
	  return -1;
  }
  
  static int getDifferentNumber(int[] arr) {
    // your code goes here
	Arrays.sort(arr);
    for(int i = 0; i < arr.length; i++){
      if((i - arr[i]) != 0){
        return i;
      }
    }
    return arr.length;
  }  // do you hear me? no i dont hear you, no camera either, Chrome crashed.
  // Don't know what's happening, but I think it should work.
  // Maybe you can tell me now the complexity of your code
  

  public static void main(String[] args) {
    int[] arr = new int[]{0,1,2,3,500, 5000,6000};
    //int lowestInteger = getDifferentNumber(arr);
    int lowestInteger = getDifferentNumberWithoutSorting(arr);
    System.out.println("The lowest integer is: " + lowestInteger);
  }

}