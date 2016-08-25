public class MoveAllZerosToEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] {1,3,0,0, 0, 2, 8,12,0,4,0,7};
		printArray(arr);
		moveAllZerosToEnd(arr);
		printArray(arr);
		
	}
	
	/*
	 * O(n) time, O(1) space
	 */
	public static void moveAllZerosToEnd(int[] arr) {
		int j = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0 && j < 0) {
				j = i;
				continue;
			} 
			
			if (arr[i] != 0 && j >= 0) {
				swap(arr, i, j);
				j++;
			}
		}
	}
	
	/*
	 * O(n) time, O(1) space
	 */
	public static void moveAllZerosToEnd2(int[] arr) {
		int j = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0 && j < 0) {
				j = i;
				continue;
			} 
			
			if (arr[i] != 0 && j >= 0) {
				arr[j] = arr[i];
				j++;
			}
		}
		
		for (int i = j; i<arr.length;i++) {
			arr[i] = 0;
		}
		
		System.out.println(arr);
	}
	
	/*
	 * O(n) time, O(n) space
	 */
	public static void moveAllZerosToEnd3(int[] arr) {
		int[] result = new int[arr.length];
		
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				result[j] = arr[i];
				j++;
			}
		}
		
		arr = result;
	}
	

	/*
	 * O(n2) time, O(1) space
	 */
	public static void moveAllZerosToEnd4(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] != 0) {
						swap(arr, i, j);
						break;
					}
				}
 			}
		}
	}
	
	private static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
	
	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
}
