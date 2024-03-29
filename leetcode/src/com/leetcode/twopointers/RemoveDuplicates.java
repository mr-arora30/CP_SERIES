package com.leetcode.twopointers;

import java.util.*;
class RemoveDuplicates { 
  public static void main(String args[]){
     int arr[] ={2, 3, 3, 3, 6, 9, 9};
    System.out.println(remove(arr));
  }

/*
Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the length of the subarray that has no duplicate in it.

Example 1:

Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
Example 2:

Input: [2, 2, 2, 11]
Output: 2
Explanation: The first two elements after removing the duplicates will be [2, 11].
*/
/*
As the input array is sorted, therefore, one way to do this is to shift the elements left whenever we encounter duplicates. In other words, we will keep one pointer for iterating the array and one pointer for placing the next non-duplicate number. So our algorithm will be to iterate the array and whenever we see a non-duplicate number we move it next to the last non-duplicate number we’ve seen.
*/
  public static int remove(int[] arr) {
   int nextNonDuplicate=1; // index of the next non-duplicate element
   for(int i=1;i<arr.length;i++){    
      if(arr[nextNonDuplicate-1]!=arr[i]){ // [2, 2, 3, 3, 6, 9, 9],
        arr[nextNonDuplicate]=arr[i]; //[2,3,3,6,9,9]
            nextNonDuplicate++; //2, increment upto last existing non duplicate element in the array
      }
  
   }  
   System.out.println(Arrays.toString(Arrays.copyOf(arr,nextNonDuplicate)));
   return nextNonDuplicate;
  }
}