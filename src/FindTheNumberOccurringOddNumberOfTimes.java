/*
 * Given an array of POSITIVE integers. 
 * All numbers occur even number of times except one number which occurs odd number of times. 
 * Example:
 * Input: [1, 2, 3, 2, 3, 2, 1, 2, 3]
 * Output: 3   
 */

import java.util.*;

public class FindTheNumberOccurringOddNumberOfTimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 2, 3, 2, 1, 2, 3};
		int n = findOddOccurence(arr);
		System.out.println(n);
	}
	
	/*
	 * Best approach
	 * O(n) time, O(1) space
	 */
	
	public static int findOddOccurence(int[] arr) {
		
		int xor = 0;
		for (int i = 0; i < arr.length; i++) {
			xor ^= arr[i];
		}
		
		return xor;
	}
	
	/*
	 * Better approach 2
	 * O(n) time, O(n) space
	 */
	public static int findOddOccurence3(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i])) {
				set.remove(arr[i]);
			} else {
				set.add(arr[i]);
			}
		}
		
		Iterator<Integer> it = set.iterator();
		
		if (it.hasNext()) {
			return it.next();	
		}
		
		//if the input is valid, shouldn't reach here
		return 0;
		
	}
	
	
	/*
	 * Better approach
	 * O(n) time, O(n) space
	 */
	public static int findOddOccurence2(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			Integer count = map.get(arr[i]);
			if (count == null) {
				count = 0;
			}
			map.put(arr[i], count + 1);
		}
		
		for (Integer key: map.keySet()) {
			if (map.get(key) % 2 == 1) {
				return key;
			}
		}
		
		//if the input is valid, shouldn't reach here
		return 0;
	}
	
	
	/* Naive approach
	 * O(n2) time and O(1) space
	 */
	public static int findOddOccurence1(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			boolean odd = false;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					odd = !odd;
				}
			}
			if (odd) {
				return arr[i];
			}
		}
		
		//if the input is valid, shouldn't reach here
		return 0;
	}

}
