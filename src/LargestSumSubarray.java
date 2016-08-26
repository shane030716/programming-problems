
public class LargestSumSubarray {

	public static void main(String[] args) {

		int[] arr = {8, 2, -7, -5, 9, 4, -2, 3};
		printArray(arr);
		System.out.println(largestSum(arr));
	}
	
	/*
	 * O(n) time and O(1) space
	 */
	public static int largestSum(int[] arr) {
		int max_sum = 0;
		int current_sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			current_sum += arr[i];
			if (current_sum < 0) {
				current_sum = 0;
			}
			if (current_sum > max_sum) {
				max_sum = current_sum;
			}
			
		}
		
		return max_sum;
		
	}
	
	/*
	 * O(n) time and O(n) space
	 */
	public static int largestSum4(int[] arr) {
		int[] m = new int[arr.length];
		int max_sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 ) {
				m[0] = arr[0];
			} else {
				m[i] = Math.max(m[i-1], 0) + arr[i];
			}
			
			if (m[i] > max_sum) {
				max_sum = m[i];
			}
		}
		return max_sum;
	}
	
	
	/*
	 * O(n2) time and O(n) space
	 */
	public static int largestSum3(int[] arr) {
		int[] m = new int[arr.length];
		int max_sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 ) {
				m[0] = arr[0];
			} else {
				m[i] = m[i-1] + arr[i];
			}
			
			if (m[i] > max_sum) {
				max_sum = m[i];
			}
			
		}
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				m[j] = m[j] - arr[i - 1];
				if (m[j] > max_sum) {
					max_sum = m[j];
				}
			}
		}
	
		return max_sum;
	}
	
	
	/*
	 * O(n2) time and O(n2) space
	 */
	public static int largestSum2(int[] arr) {
		int[][] m = new int[arr.length][arr.length];
		int max_sum = 0;
		
		for (int j = 0; j < arr.length; j++) {
			if (j == 0 ) {
				m[0][0] = arr[0];
			} else {
				m[0][j] = m[0][j-1] + arr[j];
			}
			
			if (m[0][j] > max_sum) {
				max_sum = m[0][j];
			}
		}
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				m[i][j] = m[i-1][j] - arr[i-1];
				if (m[0][j] > max_sum) {
					max_sum = m[0][j];
				}
			}
		}
		
		printMatrix(arr, arr, m);
		return max_sum;
	}
	
	
	/*
	 * Naive approach
	 * O(n3) time and O(1) space
	 */
	public static int largestSum1(int[] arr) {
		
		int max_sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += arr[k];
				}
				if (sum > max_sum) {
					max_sum = sum;
				}
			}
		}
		return max_sum;
	}
	
	
	/*
	 * All methods below are for debugging.
	 */
	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}
	
	private static void printMatrix(int[] arr1, int[] arr2, int[][] m) {
		int[] sizes = new int[m[0].length+1];
		
		int first_column_max_size = 0;
		for (int i = 0; i < arr1.length; i++) {
			int length = String.valueOf(arr1[i]).length();
			if (length > first_column_max_size) {
				first_column_max_size = length;
			}
		}
		sizes[0] = first_column_max_size;
		
		for (int j = 0; j < m[0].length; j++) {
			int max_size = String.valueOf(arr2[j]).length();;
			for (int i = 0; i < m.length; i++) {
				int length = String.valueOf(m[i][j]).length();
				if (length > max_size) {
					max_size = length;
				}
			}
			sizes[j+1] = max_size;
		}
	
		printHorizontalLine(sizes);
		printFirstRow(arr2, sizes);
		
		for (int i = 0; i < arr1.length; i++) { 	
			
			printFirstColumnAt(i, arr1, sizes);
			
			for (int j = 0; j < arr2.length; j++) {
				printIntWithSpaces(sizes[j+1], m[i][j]);
			}
			System.out.println("|");
			printHorizontalLine(sizes);
		}
		System.out.println();
	}
	
	private static void printFirstRow(int[] arr2, int[] sizes) {
		printCharWithSpaces(sizes[0], '*');
		
		for (int i = 0; i < arr2.length; i++) {
			printIntWithSpaces(sizes[i+1], arr2[i]);
		}
		System.out.println("|");
		printHorizontalLine(sizes);
	}
	
	private static void printFirstColumnAt(int i, int[] arr1, int[] sizes) {
		printIntWithSpaces(sizes[0], arr1[i]);	
	}
	
	private static void printCharWithSpaces(int size, char c) {
		System.out.format("| %"+size+"s ", c);
	}
	
	private static void printIntWithSpaces(int size, int i) {
		System.out.format("| %"+size+"s ", i);
	}
	
	private static void printHorizontalLine(int[] sizes) {
		for (int i = 0; i < sizes.length; i++) {
			for (int j = 0; j<=sizes[i]+2;j++) {
				System.out.print("-");
			}
		}
		System.out.println("-");
	}
}
