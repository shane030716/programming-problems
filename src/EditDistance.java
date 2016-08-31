/*
 * Given two strings str1 and str2 and below operations that can performed on str1. 
 * Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.
 * Insert
 * Remove
 * Replace
 * All of the above operations are of equal cost.
 * Examples:
 * Input: Saturday, Sunday
 * Output: 3
 * 
 * Input: Canada, Canadian
 * Output: 2
 * 
 * Input: edit, distance
 * Output: 6
 */

import java.util.Scanner;

import util.matrixprinter.MatrixPrinter;

public class EditDistance {
	
	/*
	 * Use dynamic programming
	 */
	public static int editDistance(String s1, String s2) {
		//Create a 2D array based on the numbers of the characters of s1 and s2, and plus one row and one column
		int[][] m = new int[s1.length() + 1][s2.length() + 1];
		
		//initialize the first row
		for (int i = 0; i <= s1.length(); i++) {
			m[i][0] = i;
		}
		
		//initialize the first column
		for (int j = 0; j <= s2.length(); j++) {
			m[0][j] = j;
		}
		
		//The main part of the dynamic programming
		//if the current two characters are the same, eg. s1[i] = s2[j], set m[i][j] = m[i-1][j-1], which means no edits needed
		//otherwise, set m[i][j] = 1 + the minimum of the three previous elements in the matrix m[i-1][j], m[i][j-1] & m[i-1][j-1]
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					m[i][j] = m[i-1][j-1];
				} else {
					int min = Math.min(m[i-1][j], m[i][j-1]);
					min = Math.min(m[i-1][j-1], min);
					m[i][j] = min + 1;
				}
			}
		}
		
		//Use the MatrixPrinter to see what m looks like
		//Note because the matrix is one row and one column larger than the sizes of s1 and s2.
		//We need to fill one extra character for each of s1 and s2
		new MatrixPrinter().printMatrix("*" + s1, "*" + s2, m);
		
		//Return the last (bottom right) element from the matrix
		return m[s1.length()][s2.length()];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (true)
			start(sc);
	}
	
	public static void start(Scanner sc) {
		
		System.out.print("Enter first word: ");
		String s1 = sc.nextLine();
		
		System.out.print("Enter second word: ");
		String s2 = sc.nextLine();
		
		int distance = editDistance(s1, s2);
		System.out.println("The edit distance between '" +s1 + "' and '" + s2 + "' is " + distance);
	}

}
