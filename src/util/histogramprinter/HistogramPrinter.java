package util.histogramprinter;

import java.util.Formatter;
import java.util.Stack;

public class HistogramPrinter {
	
	/*
	 * Print the histogram for debug purpose
	 * (Expect the largest element in array is less than 100)
	 */
	public void printHistogram(int[] arr) {
		printHistogram(arr, null, null);
	}
	

	/*
	 * Print the water-filled version of the histogram
	 */
	public void printWaterFilledHistogram(int[] arr) {
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
		
		
		printHistogram(arr, filled, null);
		
	}
	
	public void printLargestRectangleFilledHistogram(int[] arr) {
		//base case
		if (arr == null || arr.length == 0) return ;
		
		//variable to keep track of the largest area
		int max_area = 0;		
		int max_area_start = -1;
		int max_area_end = -1;
		int max_area_height = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		
		while (true) {
			if (i < arr.length && (stack.isEmpty() || arr[i] >= arr[stack.peek()])) {
				stack.push(i++);
			} else if (!stack.isEmpty()){
				int top = stack.pop();
				int area = arr[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
			
				if (area > max_area) {
					max_area = area; 
					max_area_start = stack.isEmpty() ? 0 : (stack.peek() + 1);
					max_area_end = i - 1;
					max_area_height = arr[top]; 
				}						
			} else{
				break;
			}
		}
		
		int[] filled = new int[arr.length];
		for (i = 0; i < arr.length; i++) {
			if (i >= max_area_start && i <= max_area_end) {
				filled[i] = max_area_height;
			}
		}
		printHistogram(arr, null, filled);
		
	}
	
	/*
	 * Print the histogram for debug purpose
	 * (Expect the largest element in array is less than 100)
	 */
	private void printHistogram(int[] arr, int[] waterFilled, int[] rectangleFilled) {
		if (arr == null || arr.length == 0) return;
		if (waterFilled != null && waterFilled.length != arr.length) return;
		if (rectangleFilled != null && rectangleFilled.length != arr.length) return;
		
		
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) 
				max = arr[i];
		}
		
		StringBuilder builder = new StringBuilder();
		
	
		//bottom
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				
				if (rectangleFilled != null && rectangleFilled[i] > 0) {
					builder.append("|±±±");	
				} else {
					builder.append("|___");
				}
				
			} else {
				
				if (i > 0 && arr[i-1] > 0) {
					builder.append("|");
				} else {
					builder.append(" ");
				}
				
				if (waterFilled != null && waterFilled[i] > 0) {
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
					
					if (waterFilled != null && waterFilled[j] > i + 1) {
						builder2.append("+++");	
					} else {
						builder2.append("   ");
					}
					
					
				} else if (arr[j] == i + 1) { //cap
					
					if (j > 0 && arr[j-1] > i + 1) {
						builder2.append("|");
					} else {
						builder2.append(" ");
					}
					
					if (waterFilled != null && waterFilled[j] > i + 1) {
						builder2.append("±±±");	
					} else {
						builder2.append("___");
					}
					
				} else { //body
					if (rectangleFilled != null && rectangleFilled[j] > i + 1) {
						builder2.append("|+++");	
					} else {
						builder2.append("|   ");
					}
					
//					builder2.append("|   ");
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
