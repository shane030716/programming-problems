import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindThePairWhoseSumIsEqualToAGivenNumberInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6,3,5,4,2};
		int sum = 8;
		findPairUnsorted(arr, sum);
	}

	
	/****************************
	 ******* Sorted Array *******
	 ****************************/
	
	/*
	 * Use two indexes at start and end.
	 * O(n) time, O(1) space
	 */
	public static void findPairSorted(int[] arr, int sum) {
		int start = 0;
		int end = arr.length - 1;
		
		while (start < end) {
			if (arr[start] + arr[end] < sum) {
				start++;
			} else if (arr[start] + arr[end] > sum) {
				end--;
			} else {
				System.out.println(arr[start] + " + " + arr[end] + " = " + sum);
				return;
			}
		}
		
		System.out.println("No pair found.");
		
	}

	/* 
	 * For each element, find the complement in the rest of the array using binary search.
	 * O(nlogn) time, O(logn) space?
	 */
	public static void findPairSorted2(int[] arr, int sum) {
		for (int i = 0; i<arr.length;i++) {
			int complementIndex = binarySearch(arr, i+1, arr.length, sum - arr[i]);
			if (complementIndex > 0) {
				System.out.println(arr[i] + " + " + arr[complementIndex] + " = " + sum);
				return;
			}
		}
		System.out.println("No pair found.");
	}
	
	private static int binarySearch(int[] arr, int start, int end, int target) {//end is exclusive
		if (start >= end) {
			return -1;
		}
		
		int middle = (start + end) / 2;
		if (arr[middle] < target) {
			return binarySearch(arr, middle + 1, end, target);
		} else if (arr[middle] > target) {
			return binarySearch(arr, start, middle, target);
		} else {
			return middle;
		}
			
	}

	/*
	 * Brute force. 
	 * O(n2) time, O(1) space
	 */
	public static void findPairSorted1(int[] arr, int sum) {
		for (int i = 0; i<arr.length; i++) {
			for (int j = i + 1; j<arr.length; j++) {
				if (arr[i] + arr[j] == sum) {
					System.out.println("" + arr[i] + " + " + arr[j] + " = " + sum);
					return;
				}
			}
		}
		System.out.println("No pair found.");
	}
	
	/****************************
	 ******* Unsorted Array *******
	 ****************************/
	
	/*
	 * Use additional data structure.
	 * O(n) time, O(n) space
	 */
	
	public static void findPairUnsorted(int[] arr, int sum) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0;i<arr.length;i++) {
			int complement = sum - arr[i];
			if (set.contains(arr[i])) {
				System.out.println(complement + " + " + arr[i] + " = " + sum);
				return;
			} else {
				set.add(complement);
			}
			
		}
		System.out.println("No pair found.");
	}
	
	/*
	 * Brute Force.
	 * Same as findPairSorted1
	 * O(n2) time, O(1) space
	 */
	public static void findPairUnsorted1(int[] arr, int sum) {
		findPairSorted1(arr, sum);
	}
	
	/*
	 * Sort the array first
	 * and then use findPairSorted2
	 * O(nlogn) time, O(logn) space?
	 */
	public static void findPairUnsorted2(int[] arr, int sum) {
		Arrays.sort(arr);
		findPairSorted2(arr, sum);
	}
	
	/*
	 * Sort the array first
	 * and then use findPairSorted
	 * O(nlogn) time, O(1) space
	 */
	public static void findPairUnSorted3(int[] arr, int sum) {
		Arrays.sort(arr);
		findPairSorted(arr, sum);
	}
	

	
}
