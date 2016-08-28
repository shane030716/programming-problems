/*
 * Given an amount of money in cents, and a list of all the different coin denominations for this currency, 
 * find how many different ways you can make a change for this amount. 
 * (Suppose you have unlimited supply of all the coins)
 * This problem could include two parts.
 *  One is to return only the number, and the other is to return all the different ways.
 *  
 * Example1:
 * Denominations (USA): [25, 10, 5, 1] The number of ways to make exact change of ¢12 is 4
 * {10: 1, 1: 2} 
 * {5: 2, 1: 2} 
 * {5: 1, 1: 7} 
 * {1: 12}
 * 
 * This problem can also be extended for the Canadian version, 
 * where you need to round the money amount to the nearest 5 cents first
 * 
 * Example2:
 * Denominations (Canada): [200, 100, 25, 10, 5] The number of ways to make exact change of ¢10 (rounded from ¢12) is 2
 * {10: 1} 
 * {5: 2}
 * 
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class CoinChange {
	
	public static int[] US_denoms = new int[] {25, 10, 5, 1};
	public static int[] Canadian_denoms = new int[] {200, 100, 25, 10, 5};

	/* 
	 * Count how many different ways of making the changes
	 * @param value: the amount of money
	 * @param denoms: an array of different denominations of the currency
	 */
	public static int count(int amount, int[] denoms) {
		//pass amount, denominations and the initial index of denominations to the helper function
		int count = count(amount, denoms, 0);
		
		System.out.println("The number of ways to make exact change of ¢" + amount + " is " + count);
		return count;
	}
	
	/*
	 * Canadian version
	 */
	public static int countCanadian(int amount, int[] denoms) {
		//Round the amount to the nearest ¢5
		int original = amount;
		int remainder = amount % 5;
		if (remainder < 3) {
			amount -= remainder;
		} else {
			amount += 5 - remainder;
		}
		
		//pass amount, denominations and the initial index of denominations to the helper function
		int count = count(amount, denoms, 0);
		
		String rounded = "";
		if (original != amount) {
			rounded = " (rounded from ¢" + original + ")";
		}
		System.out.println("The number of ways to make exact change of CAD¢" + amount + rounded + " is " + count);
		return count;

	}
	
	/* 
	 * Helper function: count how many different ways of making the changes
	 * @param value: the amount of money
	 * @param denoms: an array of different denominations of the currency
	 * @param m: index of denoms, which means only using the current and the next denominations
	 */
	private static int count(int amount, int[] denoms, int m) {
	
		//1st Base case: 
		//If the amount is 0, this means the previous steps have already made the exact change,
		//So we found one way how to make the change
		if (amount == 0) {
			return 1;
		}

		//2nd Base Case
		//if m reaches the size of denoms (out of index) 
		//this means the previous step still wants to make changes with the next denomination,
		//which we already ran out of options, then we could not find a way to make the change in this step
		if (m >= denoms.length) {
			return 0;
		}
		
		//the variable to return, the total number of ways of making changes
		int count = 0;
		
		//Get the current denomination
		int c = denoms[m];
		
		//Get the maximum number of coins with the current denomination without going over the amount
		int n = amount / c;
		
		//The main recursive part
		for (int i = n; i >= 0; i--) {
			//For each number of coins between the maximum 'allowed' number and 0 of the current denomination
			//we try to find the number of ways of making changes 
			//for the amount after deducting using i coins with the current denomination and with next denomination.
			//And then sum them up.
			count += count(amount - c * i, denoms, m + 1);
		}
		
		return count;
	}
	
	/* 
	 * Canadian Version
	 */
	public static List<TreeMap<Integer, Integer>> findAllWaysOfMakingChangesCanadian(int amount, int[] denoms) {
		//Round the amount to the nearest ¢5
		int remainder = amount % 5;
		if (remainder < 3) {
			amount -= remainder;
		} else {
			amount += 5 - remainder;
		}
		
		return findAllWaysOfMakingChanges(amount, denoms, 0);
	}
	
	
	/* 
	 * Find all the different ways of making the changes
	 * @param value: the amount of money
	 * @param denoms: an array of different denominations of the currency
	 */
	public static List<TreeMap<Integer, Integer>> findAllWaysOfMakingChanges(int amount, int[] denoms) {
		return findAllWaysOfMakingChanges(amount, denoms, 0);
	}
	
	/* 
	 * Helper function: find all the different ways of making the changes
	 * @param value: the amount of money
	 * @param denoms: an array of different denominations of the currency
	 * @param m: index of denoms, which means only using the current and the next denominations
	 * 
	 * We use a TreeMap to represent one way of making the changes, 
	 * where the key is the denomination and the value is number of coins used.
	 * And we then use ArrayList to put all ways together. 
	 */
	public static List<TreeMap<Integer, Integer>> findAllWaysOfMakingChanges(int amount, int[] denoms, int m) {
		
		//Create the empty list of ways of making changes, and we will return it at the end
		List<TreeMap<Integer, Integer>> result = new ArrayList<TreeMap<Integer, Integer>>();
		
		//1st Base Case:
		//If the amount is 0, this means the previous steps have already made the exact change,
		//So we found one way how to make the change
		if (amount == 0) {
			//And we need to add a way to represent 0 amount to the result list, which is an empty TreeMap
			result.add(new TreeMap<Integer, Integer>(new DescendingComparator()));
			return result;
		}

		//2nd Base Case:
		//if m reaches the size of denoms (out of index) 
		//this means the previous step still wants to make changes with the next denomination,
		//which we already ran out of options, then we could not find a way to make the change in this step
		if (m >= denoms.length) {
			return null;
		}
		
		//Get the current denomination
		int c = denoms[m];
		//Get the maximum number of coins with the current denomination without going over the amount
		int n = amount / c;
		
		for (int i = n; i >= 0; i--) {	
			//For each number of coins between the maximum 'allowed' number and 0 of the current denomination
			//we try to find all the different ways of making changes 
			//for the amount after deducting using i coins with the current denomination and with next denomination.
			List<TreeMap<Integer, Integer>> result_next = findAllWaysOfMakingChanges(amount - c * i, denoms, m + 1);

			//If we found some ways of the sub-problem above
			if (result_next != null) {
					
				for (TreeMap<Integer, Integer> tree_next: result_next) {
					//We add the current denomination and how many such coins we use to each result
					if (i != 0) {
						tree_next.put(c, i);	
					}
					//And put each sub-result to the current result
					result.add(tree_next);	
				}
				
			}
		}
		
		//Finally return the result list
		return result;
	}
	
	//main method is here
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int value = 12;
		
		//Some different test cases
		//US
		System.out.println("US");
		count(value, US_denoms);
		List<TreeMap<Integer, Integer>> result = findAllWaysOfMakingChanges(value, US_denoms);
		printResult(result);
	
		//Canada
		System.out.println();
		System.out.println("Canada");
		countCanadian(value, Canadian_denoms);
		result = findAllWaysOfMakingChangesCanadian(value, Canadian_denoms);
		printResult(result);
		

	}
	
	/*
	 * Print the result list of tree maps
	 */
	private static void printResult(List<TreeMap<Integer, Integer>> result) {
		for (TreeMap<Integer, Integer> way: result) {
			System.out.print("{");
			for (Integer key : way.keySet()) {
				System.out.print(key +": " + way.get(key) + ", ");
			}
			System.out.println("}");
		}
	}
	
	/*
	 * Helper comparator class for the TreeMap to show the largest denomination first
	 */
	private static class DescendingComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2 - o1;
		}
		
	}
}
