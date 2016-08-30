/*
 * Given a histogram represented by an array of non-negative integers,
 * each element in the array represents the height of each bar of the histogram.
 * Find the largest rectangular area formed by a number of contiguous bars.
 * 
 * Example 1:
 * Input: {3,1,4,3,5,2,1}
 * Output: 9
 *                  ___        
 *          ___    |   |       
 *  ___    |   |___|   |       
 * |   |   |+++|+++|+++|___    
 * |   |___|+++|+++|+++|   |___
 * |___|___|±±±|±±±|±±±|___|___|
 *   3   1   4   3   5   2   1 
 * The area of the largest rectangle is 9, which is formed between bar #2 and #4 with height 3.
 * 
 *   
 * Example 2:
 * Input: {3,1,4,3,5,2,2}
 * Output: 10
 *                  ___        
 *          ___    |   |       
 *  ___    |   |___|   |       
 * |   |   |   |   |   |___ ___
 * |   |___|+++|+++|+++|+++|+++|
 * |___|___|±±±|±±±|±±±|±±±|±±±|
 *   3   1   4   3   5   2   2 
 * The area of the largest rectangle is 10, which is formed between bar #2 and #6 with height 2.
 * 
 */


import java.util.Stack;

import util.*;

public class LargestRectangleInAHistogram {
	
	public static void main(String[] args) {
	
		int[] arr = new int[] {3,1,4,3,5,2,1};
//		int[] arr = new int[] {3,1,4,3,5,2,2};

		//Visualize the problem, easier for debugging
		HistogramPrinter histogramPrinter = new HistogramPrinter();
		//print the histogram 
		histogramPrinter.printHistogram(arr);
		//print the histogram with the largest rectangle filled
		histogramPrinter.printLargestRectangleFilledHistogram(arr);
		
		//Find the largest rectangle
		largestRectangle(arr);
				
	}
	
	
	/*
	 * We use a stack to keep track of indexes of all the previous bars that are equal or shorter than the current bar,
	 * while maintaining the elements in the stack in descending order.
	 * Each element will be push and pop once, so it takes 2n iterations
	 * which will take O(n) time and O(n) space
	 */
	public static int largestRectangle(int[] arr) {
		//base case
		if (arr == null || arr.length == 0) return 0;
		
		//variable to keep track of the largest area
		int max_area = 0;		
		int max_area_start = -1;
		int max_area_end = -1;
		int max_area_height = 0;
		
		//Create an empty stack
		Stack<Integer> stack = new Stack<Integer>();
		
		//index of the histogram
		int i = 0;
		
		//the while loop will not break until i reaches after the end of the histogram AND the stack is empty
		while (true) {
			//while we are still traversing the array, if the current bar is equal or taller than the top of the stack
			//we push it to the stack, and move the index to the next element
			if (i < arr.length && (stack.isEmpty() || arr[i] >= arr[stack.peek()])) {
				stack.push(i++);
			//while we reach the end of the histogram, or the current bar is shorter than the top of the stack
			} else if (!stack.isEmpty()){
				//we pop the top of the stack, which is basically the index of the previous element that is taller than the current one.
				int top = stack.pop();
				
				//calculate the area with 
				//the height of this previous taller bar (arr[top]) 
				//and the number of bars between this previous taller bar (at index i - 1) and the previous shorter (or same height taller) bar (at index stack.peek()) exclusively.
				//So there are ( i - 1 - stack.peek()) bars.
				//If the stack is empty, which means there is no previous taller bar, 
				//then the number of bars to use calculate the area is basically the number of bars before the current bar.
				int area = arr[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
				
				//update the largest area
				if (area > max_area) {
					max_area = area; 
					max_area_start = stack.isEmpty() ? 0 : (stack.peek() + 1);
					max_area_end = i - 1;
					max_area_height = arr[top]; 
				}
				
			} else{
				//when out of index and the stack is empty, we break
				break;
			}
		}
		System.out.format("The area of the largest rectangle is %d, which is formed between bar #%d and #%d with height %d.%n", max_area, max_area_start, max_area_end, max_area_height);
		return max_area;
	}

	/* 
	 * O(n^2) time, O(1) space
	 */
	public static int largestRectangle2(int[] arr) {
		int max_area = 0;
		for (int i = 0; i < arr.length; i++) {
			int current_min = arr[i];
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < current_min) {
					current_min = arr[j];
				}
				int area = current_min * (j - i + 1);
				if (area > max_area) {
					max_area = area;
				}
			}
		}
		
		return max_area;
	}
	
	/*
	 * O(n^2) time, O(n^2) space
	 */
	public static int largestRectangle3(int[] arr) {
		
		int[][] m = new int[arr.length][arr.length];
		int max_area = 0;
		
		for (int i = 0; i < arr.length; i++) {
			m[i][i] = arr[i];
			if (arr[i] > max_area) {
				max_area = arr[i];
			}
			for (int j = i + 1; j < arr.length; j++) {
				m[i][j] = Math.min(m[i][j-1], arr[j]);
				int area = m[i][j] * (j - i + 1);
				if (area > max_area) {
					max_area = area;
				}
			}
		}
		new MatrixPrinter().printMatrix(arr, m);
		return max_area;
	}
	
	/* Naive Approach
	 * O(n^3) time, O(1) space
	 */
	public static int largestRectangle4(int[] arr) {
		int max_area = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = i; k <= j; k++) {
					if (arr[k] < min) {
						min = arr[k];
					}
				}
				int area = min * (j - i + 1);
				if (area > max_area) {
					max_area = area;
				}
			}
		}
		
		return max_area;
	}
	
}
