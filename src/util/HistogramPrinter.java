package util;

import java.util.Formatter;

public class HistogramPrinter {

	/*
	 * Print the filled version of the histogram
	 */
	public void printFilledHistogram(int[] arr) {
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
//		System.out.print("Filled: ");
//		for (int i = 0; i < filled.length; i++) {
//			System.out.print(filled[i] + ", ");
//		}
//		System.out.println();
		
		
		printHistogram(arr, filled);
		
	}
	
	/*
	 * Print the histogram for debug purpose
	 * (Expect the largest element in array is less than 100)
	 */
	public void printHistogram(int[] arr) {
		int[] filled = new int[arr.length];
		printHistogram(arr, filled);
	}
	
	/*
	 * Print the histogram for debug purpose
	 * (Expect the largest element in array is less than 100)
	 */
	private void printHistogram(int[] arr, int[] filled) {
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
