import java.util.Scanner;
import linkedlist.Node; 

/* Given two numbers represented by two linked lists, write a function that returns sum list. 
 * The sum list is linked list representation of addition of two input numbers. 
 * Node that this problem can have two versions:
 * Forward version:
 * 		The most significant digit is the first node and the least significant digit is the last node (Natural order)
 * 		Example: 
 * 		Input:
 * 			First list:  3 -> 4 -> 2 (342)
 * 			Second list: 9 -> 9 -> 8 -> 6 (9986)
 * 		Output:
 * 			Result list: 1 -> 0 -> 3 -> 2 -> 8 (10328)
 * 
 * Backward version:
 * 	    The least significant digit is the first node and the most significant digit is the last node (Natural order)
 * 		Example: 
 * 		Input:
 * 			First list:  3 -> 4 -> 2 (243)
 * 			Second list: 9 -> 9 -> 8 -> 6 (6899)
 * 		Output:
 * 			Result list: 2 -> 4 -> 1 -> 7 (7142)
 * 
 * Note that in the solution below, we assume we only have access of the Node class, but not the LinkedList class
 */

public class SumLinkedLists {
	
	/*
	 * Forward version: 
	 * adding two linked lists
	 */
	public static Node<Integer> addLinkedListsForward(Node<Integer> node1, Node<Integer> node2) {
		
		//First get the lengths of both lists
		int length1 = getLength(node1);
		int length2 = getLength(node2);
		
		//and see which is shorter and which is longer
		Node<Integer> shorter = length1 < length2 ? node1 : node2;
		Node<Integer> longer = length1 < length2 ? node2 : node1;
		
		
		//append leading zeros to the shorter list
		for (int i = 0;i < Math.abs(length1 - length2); i++){
			Node<Integer> node = new Node<Integer>(0);
			node.next = shorter;
			shorter = node;
		}
		
		//sum up the two lists
		ResultWrapper result = addLinkedListsForwardHelper(shorter, longer);
		
		Node<Integer> head = result.node;

		//The result could still have a positive carryover
		if (result.carryover > 0) {
			head = new Node<Integer>(result.carryover);
			head.next = result.node;
		}
		
		return head;
	}
	
	/*
	 * Forward version:
	 * Needed to return two values in the helper method, to ResultWrapper is needed.
	 */
	private static class ResultWrapper {
		Node<Integer> node;
		int carryover;
		
		public ResultWrapper(Node<Integer> node, int carryover) {
			this.node = node;
			this.carryover = carryover;
		}
	}
	
	/*
	 * Forward version:
	 * Main recursive helper method to sum of the two lists
	 */
	private static ResultWrapper addLinkedListsForwardHelper(Node<Integer> node1, Node<Integer> node2) {
		
		//base case, when they are null, return a null node and carryover 0
		if (node1 == null || node2 == null) {
			return new ResultWrapper(null, 0);
		}
		
		//Recursion here, get the sum of the numbers without the current digits.
		ResultWrapper resultNext = addLinkedListsForwardHelper(node1.next, node2.next);
		
		//Calculate the sum of the current two digits and the carryover from 'resultNext'
		int result = node1.value + node2.value + resultNext.carryover;
		
		//Calculate the current digit and carryover
		int digit = result % 10;
		int carryover = result / 10;
		
		Node<Integer> node = new Node<Integer>(digit);
		//Set the next node of current node to resultNext's node 
		node.next = resultNext.node;
		
		//Wrap up the digit node and the carryover and return it
		ResultWrapper resultWrapper = new ResultWrapper(node, carryover);
		return resultWrapper;
	}
	
	/*
	 * Return the length of the linkedlist
	 */
	private static int getLength(Node<Integer> node) {
		int i = 0;
		while (node != null) {
			i++;
			node = node.next;
		}
		
		return i;
	}
	
	
	/*
	 * Backward version: 
	 * adding two linked lists (Iterative)
	 */
	public static Node<Integer> addLinkedListsBackward(Node<Integer> node1, Node<Integer> node2) {
		
		//The head node pointer which we will return at the end
		Node<Integer> head = null;
		//The previous node pointer which we will keep track when creating the result linked list
		Node<Integer> previous = null;
		
		//Default carryover is 0
		int carryover = 0;
		
		//We will break if both become null
		while (node1 != null || node2 != null) {
			
			//The current sum will the sum of the previous carryover + node1.value (if not null) + node2.value (if not null)
			int sum = carryover;
			if (node1 != null) {
				sum += node1.value;
				//Move to next
				node1 = node1.next;
			}
			
			if(node2 != null) {
				sum += node2.value;
				//Move to next
				node2 = node2.next;
			}
			
			//Calculate the current digit and carryover
			int digit = sum % 10;
			carryover = sum / 10;
			
			//Create new node for the current digit
			Node<Integer> newNode = new Node<Integer>(digit);
			
			//Set head and previous if not set yet
			if (head == null) {
				head = newNode;
				previous = newNode;
			}
						
			//Link the new node to the previous node
			previous.next = newNode;
			previous = newNode;
		}
		
		//The result could still have a positive carryover
		if (carryover > 0) {
			previous.next = new Node<Integer>(carryover);
		}
		
		return head;
		
	}
	
	/*
	 * Backward version
	 * adding two lnked lists (Recursive)
	 */
	public static Node<Integer> addLinkedListsBackward2(Node<Integer> node1, Node<Integer> node2) {
		//pass it to the helper with initial 0 carryover
		return addLinkedListsBackward2Helper(node1, node2, 0);
	}
	
	public static Node<Integer> addLinkedListsBackward2Helper(Node<Integer> node1, Node<Integer> node2, int carryover) {
		//Base case, reach the ends of both lists
		if (node1 == null && node2 == null) {
			//However, if carryover is positive, return a Node with value of the carryover, which will be 1; otherwise, just return null
			if (carryover > 0) {
				return new Node<Integer>(carryover);
			} else {
				return null;
			}
		}
		
		//The current sum will the sum of the previous carryover + node1.value (if not null) + node2.value (if not null)
		int sum = carryover;
		
		if (node1 != null) {
			sum += node1.value;
			//Move to next
			node1 = node1.next;
		}
		
		if (node2 != null) {
			sum += node2.value;
			//Move to next
			node2 = node2.next;
		}
		
		//Calculate the current digit and carryover
		int digit = sum % 10;
		carryover = sum / 10;
		
		//Create new node for the current digit
		Node<Integer> node = new Node<Integer>(digit);
		
		//Recursion here, get the sum of the numbers without the current digits.
		Node<Integer> resultNext = addLinkedListsBackward2Helper(node1, node2, carryover);
		
		//The the next of the current node to the resultNext
		node.next = resultNext;
		return node;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true)
			start(sc);
		
	}
	
	private static void start(Scanner sc) {
		System.out.println("Please enter the first number");
		int n1 = sc.nextInt();
		System.out.println("Please enter the second number");
		int n2 = sc.nextInt();
		
		enterMode(sc, n1, n2);
	}
	
	private static void enterMode(Scanner sc, int n1, int n2) {
		System.out.println("Please enter a mode: forward (f), backward iterative (b1) or backward recursive (b2). (f/b1/b2)?");
		String m = sc.next();
		
		if (m.equals("f")) {
			forwardExample(n1, n2);	
		} else if (m.equals("b1") || m.equals("b2")) {
			backwardExample(n1, n2, m);	
		} else {
			enterMode(sc, n1, n2);
		}
	}
	
	private static void forwardExample(int n1, int n2) {
		
		//Some preparation for the problem
		System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
		
		Node<Integer> list1 = insertDigitsToLinkedListForward(n1);
		Node<Integer> list2 = insertDigitsToLinkedListForward(n2);
		
		System.out.println(list1);
		printLinkedListAsIngeterForward(list1);
		System.out.println();
		
		System.out.println(list2);
		printLinkedListAsIngeterForward(list2);
		System.out.println();
		//Finished preparation
		
		Node<Integer> list3 = addLinkedListsForward(list1, list2);
		System.out.println(list3);
		printLinkedListAsIngeterForward(list3);
		System.out.println();
	}
	
	public static Node<Integer> insertDigitsToLinkedListForward( int n ) {
		if (n <= 0) return null;
		
		int size = 0;
		int m = n;
		while ( m > 0) {
			size++;
			m /= 10;
		}
		
		int digit = (int) (n / Math.pow(10, size - 1));
		Node<Integer> head = new Node<Integer>(digit);
		Node<Integer> node = insertDigitsToLinkedListForward((int) (n % Math.pow(10, size - 1)));
		
		head.next = node;
		
		return head;
		
	}
	
	
	
	private static void printLinkedListAsIngeterForward(Node<Integer> node) {
		while (node != null) {
			System.out.print(node.value);
			node = node.next;
		}
	}

	private static void backwardExample(int n1, int n2, String mode) {
		
		//Some preparation for the problem
		System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
		
		Node<Integer> head1 = insertDigitsToLinkedListBackward(n1);
		Node<Integer> head2 = insertDigitsToLinkedListBackward(n2);
	
		System.out.println(head1);
		printLinkedListAsIngeterBackward(head1);
		System.out.println();
		System.out.println(head2);
		printLinkedListAsIngeterBackward(head2);
		System.out.println();
		//Finished preparation
		
		Node<Integer> list3;
		if (mode.equals("b1")) {
			list3 = addLinkedListsBackward(head1, head2);	
		} else {
			list3 = addLinkedListsBackward2(head1, head2);	
		}
		
		System.out.println(list3);
		printLinkedListAsIngeterBackward(list3);
		System.out.println();
		
	}
	
	private static Node<Integer> insertDigitsToLinkedListBackward(int n) {
		if (n <=0 ) return null;
		
		Node<Integer> head = new Node<Integer>(n % 10);
		Node<Integer> node =  insertDigitsToLinkedListBackward(n / 10);
		
		head.next = node;
		
		return head;
		
	}
		
	private static void printLinkedListAsIngeterBackward(Node<Integer> node) {
		if (node == null) {
			return;
		}
		
		printLinkedListAsIngeterBackward(node.next);
		System.out.print(node.value);
		
	}
	

}
