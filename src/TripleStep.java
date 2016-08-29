/*
 * A child is running up a staircase with n steps and can hop either 1 step, 2
 */
public class TripleStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int count = countWaysWithMemo(10);
		System.out.println("Count with memo: " + count);

		count = countWays(10);
		System.out.println("Count without memo: " + count);
		
		
	}
	
	/*
	 * O(n^3) time & space
	 */
	public static int countWays(int n) {
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		}
		
		return countWays(n-1) + countWays(n-2) + countWays(n-3); 
	}
	
	/*
	 * O(n) time & space
	 */
	public static int countWaysWithMemo(int n) {
		int[] memo = new int[n+1];
		for (int i = 0; i <= n; i++) {
			memo[i] = -1;
		}
		return countWaysWithMemo(n, memo);
	}
	
	public static int countWaysWithMemo(int n, int[] memo) {
		
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		} else if (memo[n] >= 0) {
			return memo[n];
		} else {
			memo[n] = countWaysWithMemo(n - 1 , memo) +
					  countWaysWithMemo(n - 2 , memo) +
					  countWaysWithMemo(n - 3 , memo);
			return memo[n];
		}
		
		
	
	}

}
