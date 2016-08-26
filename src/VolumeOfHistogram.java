/*
 * Given a histogram represented by an array of non-negative integers,
 * each element in the array represents the height of each bar of the histogram.
 * Now imagine pouring water inside the histogram.
 * Find the maximum volume of water that the histogram can hold.
 * Assume all bars have the same width and the width is 1 unit
 * 
 * Example:
 * Input: [1,0,0,4,0,0,6,0,0,3,10,0,2,0,5,2,0,3,0,0];
 * Output: 42
 * 
 * The histogram will look like
 * 
 *                                          ___                                    
 *                                         |   |                                   
 *                                         |   |                                   
 *                                         |   |                                   
 *                          ___            |   |                                   
 *                         |   |           |   |            ___                    
 *              ___        |   |           |   |           |   |                   
 *             |   |       |   |        ___|   |           |   |        ___        
 *             |   |       |   |       |   |   |    ___    |   |___    |   |       
 *  ___        |   |       |   |       |   |   |   |   |   |   |   |   |   |       
 * |___|___ ___|___|___ ___|___|___ ___|___|___|___|___|___|___|___|___|___|___ ___
 *   1   0   0   4   0   0   6   0   0   3  10   0   2   0   5   2   0   3   0   0 
 *   
 *   After filling the histogram with water with its maximum capacity, it will then look like this.
 *   '+' represents the water
 *                                          ___                                    
 *                                         |   |                                   
 *                                         |   |                                   
 *                                         |   |                                   
 *                          ___            |   |                                   
 *                         |   |+++ +++ +++|   |            ___                    
 *              ___        |   |+++ +++ +++|   |+++ +++ +++|   |                   
 *             |   |+++ +++|   |+++ +++ ±±±|   |+++ +++ +++|   |        ___        
 *             |   |+++ +++|   |+++ +++|   |   |+++ ±±± +++|   |±±± +++|   |       
 *  ___        |   |+++ +++|   |+++ +++|   |   |+++|   |+++|   |   |+++|   |       
 * |___|±±± ±±±|___|±±± ±±±|___|±±± ±±±|___|___|±±±|___|±±±|___|___|±±±|___|___ ___
 *   1   0   0   4   0   0   6   0   0   3  10   0   2   0   5   2   0   3   0   0 
 */

import java.util.Formatter;

public class VolumeOfHistogram {

	public static void main(String[] args) {
		int[] arr = new int[] {1,0,0,4,0,0,6,0,0,3,10,0,2,0,5,2,0,3,0,0};
//		int[] arr = new int[] {1, 0 ,5, 0, 0, 5, 0, 3, 0, 5, 0, 5, 2};

		printHistogram(arr);
		printFilledHistogram(arr);
		
		volumeOfHistogram(arr);
	}
	
	/*
	 * O(n) time, O(1) space
	 */
	public static void volumeOfHistogram(int[] arr) {
		
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
		
		System.out.println("Total volume: " + total_volume);
	}
	
	
	
	//All methods below are for debugging
	/*
	 * Print the filled version of the histogram
	 */
	private static void printFilledHistogram(int[] arr) {
		int[] filled = new int[arr.length];
		
		int current_tallest = 0;
		int tallest_position = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= current_tallest) {
				current_tallest = arr[i];
				tallest_position = i;
			} else {
				filled[i] = current_tallest;
			}
		
		}
		
		current_tallest = 0;
		
		for (int i = arr.length - 1; i >= tallest_position; i--) {
			if (arr[i] > current_tallest) {
				current_tallest = arr[i];
				filled[i] = 0;
			} else {
				filled[i] = current_tallest;
			}
		
		}
		System.out.print("Filled: ");
		for (int i = 0; i < filled.length; i++) {
			System.out.print(filled[i] + ", ");
		}
		System.out.println();
		
		
		printHistogram(arr, filled);
		
	}
	
	/*
	 * Print the histogram for debug purpose
	 * (Expect the largest element in array is less than 100)
	 */
	private static void printHistogram(int[] arr) {
		int[] filled = new int[arr.length];
		printHistogram(arr, filled);
	}
	
	/*
	 * Print the histogram for debug purpose
	 * (Expect the largest element in array is less than 100)
	 */
	private static void printHistogram(int[] arr, int[] filled) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) 
				max = arr[i];
		}
		
		StringBuilder builder = new StringBuilder();
		
	
		//bottom
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				builder.append("|___");
			} else {
				
				if (i > 0 && arr[i-1] > 0) {
					builder.append("|");
				} else {
					builder.append(" ");
				}
				
				if (filled[i] > 0) {
					builder.append("±±±");	
				} else {
					builder.append("___");
				}
				
			}
		}
		if (arr[arr.length - 1] > 0) {
			builder.append("|");
		}
		builder.append("\n");
		
		for (int i = 0; i < arr.length; i++) {
			Formatter formatter = new Formatter();
			builder.append(formatter.format("%3s ", arr[i]));
			formatter.close();
		}
		//end bottom
		
		for (int i = 0; i < max; i++) {
			StringBuilder builder2 = new StringBuilder();	
			int j;
			for (j = 0; j < arr.length; j++) {
				if (arr[j] < i + 1) {//empty
					
					if (j > 0 && arr[j-1] > i + 1) {
						builder2.append("|");
					} else {
						builder2.append(" ");
					}
					
					if (filled[j] > i + 1) {
						builder2.append("+++");	
					} else {
						builder2.append("   ");
					}
					
					
				} else if (arr[j] == i + 1) { //cap
					
					if (j > 0 && arr[j-1] >= i + 1) {
						builder2.append("|");
					} else {
						builder2.append(" ");
					}
					
					if (filled[j] > i + 1) {
						builder2.append("±±±");	
					} else {
						builder2.append("___");
					}
					
				} else { //body

					
					builder2.append("|   ");
				}
			}
			if (arr[j - 1] > i + 1) {
				builder2.append("|");
			}
			builder2.append("\n");
			builder.insert(0, builder2.toString());
		}
		

		
		System.out.println(builder.toString());
	}
	
	

}
