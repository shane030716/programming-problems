import java.util.Scanner;

public class EditDistance {

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
		
		editDistance(s1, s2);
	}
	
	public static int editDistance(String s1, String s2) {
		int[][] m = new int[s1.length() + 1][s2.length() + 1];
		
		for (int i = 0; i <= s1.length(); i++) {
			m[i][0] = i;
		}
		
		for (int j = 0; j <= s2.length(); j++) {
			m[0][j] = j;
		}
		
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
		printMatrix(s1, s2, m);
		return m[s1.length()][s2.length()];
	}

	private static void printMatrix(String str1, String str2, int[][] m) {
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
		
		for (int i = 0; i <= str1.length(); i++) { 	
			
			printFirstColumnAt(i, str1, sizes);
			
			for (int j = 0; j <= str2.length(); j++) {
				printIntWithSpaces(sizes[j+1], m[i][j]);
			}
			System.out.println("|");
			printHorizontalLine(sizes);
		}
		System.out.println();
	}
	
	private static void printFirstRow(String str2, int[] sizes) {
		System.out.print("| * ");
		printCharWithSpaces(sizes[1], '*');
		
		for (int i = 0; i < str2.length(); i++) {
			printCharWithSpaces(sizes[i+2], str2.charAt(i));
		}
		System.out.println("|");
		printHorizontalLine(sizes);
	}
	
	private static void printFirstColumnAt(int i, String str1, int[] sizes) {
		if (i == 0) {
			printCharWithSpaces(1, '*');	
		} else {
			System.out.print("| "+str1.charAt(i-1) + " ");	
		}
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
