/*
 * Three solutions:
 * 1. Reverse and Compare
 * 2. Use a stack
 * 3. Recursion
 */

import java.util.Stack;
import linkedlist.*;

public class CheckIfALinkedListIsAPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = new Integer[] {1,2,3,2,1};
		
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		linkedlist.insertAll(arr);
//		System.out.println(linkedlist);
		
		Node<Integer> node = linkedlist.head;
		System.out.println(node);
		Node<Integer> reverse = getReverse(node);
		System.out.println(reverse);
		
		System.out.println(isPalindrome1(node));
		System.out.println(isPalindrome2(node));
		System.out.println(isPalindrome3(node));
	}
		
	/*
	 * Recursion
	 */
	public static boolean isPalindrome3(Node<Integer> node) {
		int size = size(node);
		Result result = isPalindrome3(node, size);
		return result.result;
	}
	
	private static class Result{
		public Node<Integer> node;
		public boolean result;
		
		public Result(Node<Integer> node, boolean result) {
			this.node = node;
			this.result = result;
		}
	}
	
	private static Result isPalindrome3(Node<Integer> node, int size) {
		if (node == null || size == 0) {
			return new Result(node, true);
		} else if (size == 1) {
			return new Result(node.next, true);
		}
		
		Result result = isPalindrome3(node.next, size - 2);
		
		if (!result.result) {
			return result;
		}
		
		result.result = node.value == result.node.value;
		result.node = result.node.next;
		
		return result;
	}
	
	private static int size(Node<Integer> node) {
		int size = 0;
		
		while (node != null) {
			size++;
			node = node.next;
		}
		
		return size;
	}
	
	/*
	 * Use stack to store the first half
	 * compare the stack with the second half
	 */
	
	public static boolean isPalindrome2(Node<Integer> node) {
		if (node == null) return true;
		
		Node<Integer> slow = node;
		Node<Integer> fast = node;
		
		Stack<Integer> stack = new Stack<Integer>(); 
		
		while (fast != null && fast.next != null) {
			stack.push(slow.value);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (fast != null) {
			slow = slow.next;
		}
		
		while (!stack.isEmpty()) {
			Integer top = stack.pop();
			if (top != slow.value) {
				return false;
			}
			slow = slow.next;
		}
		
		return true;
	}

	/*
	 * Reverse and compare
	 * O(n) time and O(n) space
	 */
	public static boolean isPalindrome1(Node<Integer> node) {
		if (node == null) return true;
		Node<Integer> reverse = getReverse(node);
		
		while (node != null) {
			if (node.value != reverse.value) {
				return false;
			}
			
			node = node.next;
			reverse = reverse.next;
		}
		
		return true;
	}
	
	public static Node<Integer> getReverse(Node<Integer> node) {
		if (node == null) return null;
		Node<Integer> head = null;
		
		while (node != null) {	
			Node<Integer> current = new Node<Integer>(node.value);
			
			current.next = head;
			head = current;
			node = node.next;
		}
		
		return head;
	}
}
