/*
 * A city will be represented by a 2D array where each element is considered as a block in the city.
 * Given the width and the length of the city, and the locations of some lockers inside the city, 
 * which will be represented by the indexes of the array as coordinates,
 * generate the 2D grid so that each element specifies the distance to the closest locker.
 * The distance between two blocks is the sum of their horizontal and vertical distance. 
 * (a move in the diagonal direction is there considered a distance of 2)
 * Example:
 * Input:
 * 		cityWidth: 5
 * 		cityLength: 7
 * 		lockerXCoordinates: [2, 4]
 * 		lockerYCoordinates: [5, 1]
 * Output:
 *		-----------------------------
 *		| 5 | 4 | 5 | 4 | 3 | 2 | 3 |
 *		-----------------------------
 *		| 4 | 3 | 4 | 3 | 2 | 1 | 2 |
 *		-----------------------------
 * 		| 3 | 2 | 3 | 2 | 1 | 0 | 1 |
 * 		-----------------------------
 * 		| 2 | 1 | 2 | 3 | 2 | 1 | 2 |
 * 		-----------------------------
 * 		| 1 | 0 | 1 | 2 | 3 | 2 | 3 |
 * 		-----------------------------
 */

import util.matrixprinter.MatrixPrinter;

public class FindTheNearestLockerInTheCity {

	public static void main(String[] args) {
		generateCityGrid(5, 7, new int[] {2,4}, new int[] {5,1});
//		generateCityGrid(7, 12, new int[] {2,4, 4, 5}, new int[] {3,6, 8, 0});
	}
	
	/*
	 * O(mnk) time and O(mn) space, where m is cityWidth, n is cityLength and k is number of lockers
	 */
	public static int[][] generateCityGrid(int cityWidth, int cityLength, int[] lockerXCoordinates, int[] lockerYCoordinates) {
		if (lockerXCoordinates.length != lockerYCoordinates.length) return null;
		
		MatrixPrinter matrixPrinter = new MatrixPrinter();
		
		int[][] grid = new int[cityWidth][cityLength];
		
		for (int i = 0; i < cityWidth; i++) {
			for (int j = 0; j < cityLength; j++) {
				grid[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (int k = 0; k < lockerXCoordinates.length; k++) {
			int x = lockerXCoordinates[k];
			int y = lockerYCoordinates[k];
			
			for (int i = 0; i < cityWidth; i++) {
				for (int j = 0; j < cityLength; j++) {
					int distance = Math.abs(x - i) + Math.abs(y - j);
					if (distance < grid[i][j]) {
						grid[i][j] = distance;
					}
				}
			}
		}
		matrixPrinter.printMatrix(grid);
		return grid;
	}

}
