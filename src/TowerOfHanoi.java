import java.util.Iterator;
import java.util.Stack;

/*
 * Tower of Hanoi is a mathematical puzzle. 
 * It consists of three towers and a number of disks of different sizes which can slide onto any tower. 
 * The puzzle starts with the disk in a neat stack in ascending order of size in one tower, 
 * the smallest at the top thus making a conical shape. 
 * The objective of the puzzle is to move all the disks from one tower (say ‘source tower’) 
 * to another tower (say ‘target tower’) with the help of third tower (say auxiliary tower).
 * The puzzle has the following two rules:
 *    1. You can’t place a larger disk onto smaller disk
 *    2. Only one disk can be moved at a time
 *    
 * In this example below, we will start from the first tower and move them to the third tower.
 */


public class TowerOfHanoi {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//The number of disks for the game.
		int numberOfDisks = 3;
		
		//Initialize the stacks
		Stack<Integer>[] stacks = initializeGame(numberOfDisks);
		
		//Check the initial state of the stacks
		printStacks(stacks);
		
		//Start moving the disks, default source is 0 and target is 2
		solveTowerOfHanoi(stacks);
		
	}
	
	public static void solveTowerOfHanoi(Stack<Integer>[] stacks) {
		if (stacks == null || stacks.length != 3) return;
		int numberOfDisks = stacks[0].size();
		move(stacks, numberOfDisks, 0, 2);
	}
	
	@SuppressWarnings("unchecked")
	public static Stack<Integer>[] initializeGame(int numberOfDisks) {
		
		//Create 3 stacks, using Java's built-in Stack
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Stack<Integer> stack3 = new Stack<Integer>();
		
		//insert disks in to the first stack
		for ( int i = numberOfDisks; i > 0; i--) {
			stack1.push(i);
		}
		
		//return the 3 stacks in an array.
		//Note: cannot create generic array
		return new Stack[] {stack1, stack2, stack3};
	}
	
	/*
	 * Keep track of the number of moves for debugging
	 */
	private static int moves = 0;
	
	/*
	 * The main recursive function
	 * 
	 * @param stacks: the 3 stacks with all the disks
	 * @param size: number of disks to be moved
	 * @param source: the source tower
	 * @param target: the target tower
	 * 
	 * Move [size] number of disks from the [source] tower to the [target] tower
	 */
	public static void move(Stack<Integer>[] stacks, int size, int source, int target) {
		//Base case
		if (size == 1) {
			
			//Pop the top disk form the source stack and push it to the target stack
			Integer disk = stacks[source].pop();
			stacks[target].push(disk);
			
			//increment moves
			moves++;
			//Check the current state of the stacks
			printStacks(stacks, disk, source, target);
			return;
		}
		
		
		//Core of the recursive algorithm
		// First, get the auxiliary tower, which is the tower other than the source or the target tower
		int auxiliary_tower = 3 - source - target;
		
		//The subproblem here is to move all the disks except for the bottom disk to the auxiliary tower
		move(stacks, size - 1, source, auxiliary_tower);
		//And then move the bottom disk to the target tower
		move(stacks, 1, source, target);
		//And finally move the rest of disks from the auxiliary tower to the target tower
		move(stacks, size - 1, auxiliary_tower, target);
	}
	
	/*
	 * Method to print the current state of the stacks
	 * Helpful for debugging
	 */
	private static void printStacks(Stack<Integer>[] stacks, int disk, int source, int target) {
		System.out.println("Move: #" + moves);
		if (disk >= 0) {
			System.out.format("Moved disk %d from tower %d to tower %d.%n", disk, source, target);
		}
		for (int i = 0; i<stacks.length;i++) {
			Iterator<Integer> it = stacks[i].iterator();
			
			System.out.print("[");
			if (it.hasNext()) {
				System.out.print(it.next());
			}
			while (it.hasNext()) {
				System.out.print(" -> " + it.next());	
			}
			System.out.println("]");
		}
		System.out.println();
	}
	
	private static void printStacks(Stack<Integer>[] stacks) {
		printStacks(stacks, -1, -1, -1);
	}

}
