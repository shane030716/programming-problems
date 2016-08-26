/*
 * Print a matrix/table/2D array in console in a nice format.
 * Good for debugging code involving 2D arrays.
 */

package util;

public class MatrixPrinter {
	
	/*
	 * Print just the matrix
	 */
	public void printMatrix(int[][] m) {
		if (m.length <= 0) return;
		int[] sizes = new int[m[0].length];
			
		for (int j = 0; j < m[0].length; j++) {
			int max_size = 0;
			for (int i = 0; i < m.length; i++) {
				int length = String.valueOf(m[i][j]).length();
				if (length > max_size) {
					max_size = length;
				}
			}
			sizes[j] = max_size;
		}
	
		printHorizontalLine(sizes);
		
		for (int i = 0; i < m.length; i++) { 				
			for (int j = 0; j < m[0].length; j++) {
				printIntWithSpaces(sizes[j], m[i][j]);
			}
			System.out.println("|");
			printHorizontalLine(sizes);
		}
		System.out.println();
	}
	
	/*
	 * Print the matrix with str1 as the first column and str2 as the first row
	 */
	public void printMatrix(String str1, String str2, int[][] m) {
		if (m.length <= 0) return;
		int[] sizes = new int[m[0].length + 1];
		sizes[0] = 1;
		
		for (int j = 0; j < m[0].length; j++) {
			int max_size = 1;
			for (int i = 0; i < m.length; i++) {
				int length = String.valueOf(m[i][j]).length();
				if (length > max_size) {
					max_size = length;
				}
			}
			sizes[j + 1] = max_size;
		}
	
		printHorizontalLine(sizes);
		printFirstRow(str2, sizes);
		
		for (int i = 0; i < str1.length(); i++) { 	
			
			printFirstColumnAt(i, str1, sizes);
			
			for (int j = 0; j < str2.length(); j++) {
				printIntWithSpaces(sizes[j+1], m[i][j]);
			}
			System.out.println("|");
			printHorizontalLine(sizes);
		}
		System.out.println();
	}
	
	public void printMatrix(int[] arr1, int[][] m) {
		printMatrix(arr1, arr1, m);
	}
	
	/*
	 * Print the matrix with arr1 as the first column and arr2 as the first row
	 */
	public void printMatrix(int[] arr1, int[] arr2, int[][] m) {
		if (m.length <= 0) return;
		
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
	
	private void printFirstRow(int[] arr2, int[] sizes) {
		printCharWithSpaces(sizes[0], '*');
		
		for (int i = 0; i < arr2.length; i++) {
			printIntWithSpaces(sizes[i+1], arr2[i]);
		}
		System.out.println("|");
		printHorizontalLine(sizes);
	}
	
	private void printFirstRow(String str2, int[] sizes) {
		printCharWithSpaces(sizes[0], '*');
		
		for (int i = 0; i < str2.length(); i++) {
			printCharWithSpaces(sizes[i+1], str2.charAt(i));
		}
		System.out.println("|");
		printHorizontalLine(sizes);
	}
	
	private void printFirstColumnAt(int i, int[] arr1, int[] sizes) {
		printIntWithSpaces(sizes[0], arr1[i]);	
	}
	
	private void printFirstColumnAt(int i, String str1, int[] sizes) {
		printCharWithSpaces(sizes[0], str1.charAt(i));	
	}
	
	private void printCharWithSpaces(int size, char c) {
		System.out.format("| %"+size+"s ", c);
	}
	
	private void printIntWithSpaces(int size, int i) {
		System.out.format("| %"+size+"s ", i);
	}
	
	private void printHorizontalLine(int[] sizes) {
		for (int i = 0; i < sizes.length; i++) {
			for (int j = 0; j<=sizes[i]+2;j++) {
				System.out.print("-");
			}
		}
		System.out.println("-");
	}
}
