/*
 * Given a histogram represented by an array of non-negative integers,
 * each element in the array represents the height of each bar of the histogram.
 * Now imagine pouring water inside the histogram.
 * Find the maximum volume of water that the histogram can hold.
 * Assume all bars have the same width and the width is 1 unit
 * 
 * Example:
 * Input: [1,0,0,0,6,0,0,3,10,1,2,3,4,5,0,3,0];
 * Output: 31
 * 
 * The histogram will look like
 * 
 *                                  ___                                
 *                                 |   |                               
 *                                 |   |                               
 *                                 |   |                               
 *                  ___            |   |                               
 *                 |   |           |   |                ___            
 *                 |   |           |   |            ___|   |           
 *                 |   |        ___|   |        ___|   |   |    ___    
 *                 |   |       |   |   |    ___|   |   |   |   |   |   
 *  ___            |   |       |   |   |___|   |   |   |   |   |   |   
 * |___|___ ___ ___|___|___ ___|___|___|___|___|___|___|___|___|___|___
 *   1   0   0   0   6   0   0   3  10   1   2   3   4   5   0   3   0 
 *   
 *   After filling the histogram with water with its maximum capacity, it will then look like this.
 *   '+' represents the water
 *                                  ___                                
 *                                 |   |                               
 *                                 |   |                               
 *                                 |   |                               
 *                  ___            |   |                               
 *                 |   |+++ +++ +++|   |                ___            
 *                 |   |+++ +++ +++|   |+++ +++ +++ ±±±|   |           
 *                 |   |+++ +++ ±±±|   |+++ +++ ±±±|   |   |    ___    
 *                 |   |+++ +++|   |   |+++ ±±±|   |   |   |+++|   |   
 *  ___            |   |+++ +++|   |   |±±±|   |   |   |   |+++|   |   
 * |___|±±± ±±± ±±±|___|±±± ±±±|___|___|___|___|___|___|___|±±±|___|___
 *   1   0   0   0   6   0   0   3  10   1   2   3   4   5   0   3   0 
 */

import java.util.Formatter;

import util.HistogramPrinter;

public class VolumeOfHistogram {

	public static void main(String[] args) {
		int[] arr = new int[] {1,0,0,0,6,0,0,3,10,1,2,3,4,5,0,3,0};
//		int[] arr = new int[] {1, 0 ,5, 0, 0, 5, 0, 3, 0, 5, 0, 5, 2};

		int total_volume = volumeOfHistogram(arr);
		System.out.println("Total volume: " + total_volume);
		

		//Visualize the problem, print the histogram out empty and filled
		HistogramPrinter histogramPrinter = new HistogramPrinter();
		histogramPrinter.printHistogram(arr);
		histogramPrinter.printWaterFilledHistogram(arr);

	}
	
	/*
	 * O(n) time, O(1) space
	 */
	public static int volumeOfHistogram(int[] arr) {
		
		int total_volume = 0;
		int current_volume = 0;
		int current_tallest = 0;
		int tallest_position = -1;
		
		//Traversing the array from left to right
		for (int i = 0; i < arr.length; i++) {
			
			//If found a column that is taller than or equal to the current tallest
			if (arr[i] >= current_tallest) {
				//update the current tallest
				current_tallest = arr[i];
				//add up the volume we've accumulated so far to the total volume
				total_volume += current_volume;
				//reset current volume to 0
				current_volume = 0;
				
				tallest_position = i;
			} else {
				//if current column is shorter than the current tallest,
				//still add the height difference to the current volume
				//if later we found a column that is taller, then we will be inside the if block above
				//if later we never found a such column, the current_volumne will not be added to the total_volume
				current_volume += current_tallest - arr[i];
			}
		
		}
		
		//Reset current volume and current tallest
		current_volume = 0;
		current_tallest = 0;
		
		
		//Traversing the array from right to left
		for (int i = arr.length - 1; i >= tallest_position; i--) {
			//If found a column that is taller than the current tallest 
			//Note that it's just "taller than", since the first traversal covers the "equal to" part already
			if (arr[i] > current_tallest) {
				//update the current tallest
				current_tallest = arr[i];
				//add up the volume we've accumulated so far to the total volume
				total_volume += current_volume;
				//reset current volume to 0
				current_volume = 0;
			} else {
				//Add the height difference to the current volume
				current_volume += current_tallest - arr[i];
			}
		
		}
		return total_volume;
	}	
	

}
