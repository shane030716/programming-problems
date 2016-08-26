import util.MatrixPrinter;

public class LargestSumSubarray {

	public static void main(String[] args) {

		int[] arr = {-3, -2,  4, -1, 3, -8, 2, 4, -3, 3, -2, 4};
//		int[] arr = {-3, -2,  -1};
//		int[] arr = {};
		printArray(arr);
		int max_sum = largestSum4Detail(arr);
		System.out.println("The max sum is " + max_sum);
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
	 * O(n) time and O(1) space
	 * With tracking of the maximum sum subarray
	 */
	public static int largestSumDetail(int[] arr) {
		int max_sum = 0;
		int current_sum = 0;
		
		int current_start = -1, current_end = -1;
		int max_start = -1, max_end = -1;
		
		for (int i = 0; i < arr.length; i++) {
			current_sum += arr[i];
			if (current_sum <= 0) {
				current_sum = 0;
				current_start = -1;
				current_end = -1;
			} else {
				if (current_start < 0) {
					current_start = i;	
				}
				current_end = i;
			
				if (current_sum > max_sum) {
					max_sum = current_sum;
					max_start = current_start;
					max_end = current_end;
				}
			}
			
		}
		printMaxSumSubarray(arr, max_start, max_end);
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
	 * O(n) time and O(n) space
	 * With tracking of the maximum sum subarray
	 */
	public static int largestSum4Detail(int[] arr) {
		int[] m = new int[arr.length];
		int max_sum = 0;
		int current_start = -1, current_end = -1;
		int max_start = -1, max_end = -1;
		
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 ) {
				m[0] = arr[0];
			} else {
				m[i] = Math.max(m[i-1], 0) + arr[i];
			}
			
			if (m[i] <= 0) {
				current_start = -1;
				current_end = -1;
			} else {
				if (current_start < 0) {
					current_start = i;	
				}
				
				current_end = i;
				
				if (m[i] > max_sum) {
					max_sum = m[i];
					max_start = current_start;
					max_end = current_end;
				}
			}
		}
		
		printMaxSumSubarray(arr, max_start, max_end);
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
	 * O(n2) time and O(n) space
	 * With tracking of the maximum sum subarray
	 */
	public static int largestSum3Detail(int[] arr) {
		int[] m = new int[arr.length];
		int max_sum = 0;
		int max_start = -1, max_end = -1;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 ) {
				m[0] = arr[0];
			} else {
				m[i] = m[i-1] + arr[i];
			}
			
			if (m[i] > max_sum) {
				max_sum = m[i];
				max_start = 0;
				max_end = i;
			}
			
		}
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				m[j] = m[j] - arr[i - 1];
				if (m[j] > max_sum) {
					max_sum = m[j];
					max_start = i;
					max_end = j;
				}
			}
		}
		printMaxSumSubarray(arr, max_start, max_end);
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
				if (m[i][j] > max_sum) {
					max_sum = m[i][j];
				}
			}
		}
		
		new MatrixPrinter().printMatrix(arr, m);
		return max_sum;
	}
	
	/*
	 * O(n2) time and O(n2) space
	 * With tracking of the maximum sum subarray
	 */
	public static int largestSum2Detail(int[] arr) {
		int[][] m = new int[arr.length][arr.length];
		int max_sum = 0;
		int max_start = -1, max_end = -1;
		
		for (int j = 0; j < arr.length; j++) {
			if (j == 0 ) {
				m[0][0] = arr[0];
			} else {
				m[0][j] = m[0][j-1] + arr[j];
			}
			
			if (m[0][j] > max_sum) {
				max_sum = m[0][j];
				max_start = 0;
				max_end = j;
			}
		}
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				m[i][j] = m[i-1][j] - arr[i-1];
				if (m[i][j] > max_sum) {
					max_sum = m[i][j];
					max_start = i;
					max_end = j;
				}
			}
		}
		
		new MatrixPrinter().printMatrix(arr, m);
		printMaxSumSubarray(arr, max_start, max_end);
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
	 * Naive approach
	 * O(n3) time and O(1) space
	 * With tracking of the maximum sum subarray
	 */
	public static int largestSum1Detail(int[] arr) {
		
		int max_sum = 0;
		int max_start = -1, max_end = -1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += arr[k];
				}
				if (sum > max_sum) {
					max_start = i;
					max_end = j;
					max_sum = sum;
				}
			}
		}
		
		printMaxSumSubarray(arr, max_start, max_end);
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
	
	private static void printMaxSumSubarray(int[] arr, int start, int end) {
		if (start < 0 || start > end) {
			System.out.print("No maximum sum subarray");
			System.out.println();
			return;
		}
		System.out.print("The maximum sum subarray is from index " + start + " to " + end + " => ");
		for (int i = start; i <= end; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}
	
}
