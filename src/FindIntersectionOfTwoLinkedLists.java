import java.util.Stack;

import linkedlist.*;


public class FindIntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node<Integer> node1_1 = new Node<Integer>(3);
		Node<Integer> node1_2 = new Node<Integer>(1);
		Node<Integer> node1_3 = new Node<Integer>(4);
		Node<Integer> node1_4 = new Node<Integer>(1);
		Node<Integer> node1_5 = new Node<Integer>(5);
		Node<Integer> node1_6 = new Node<Integer>(9);
		Node<Integer> node1_7 = new Node<Integer>(2);
		
		node1_1.next = node1_2;
		node1_2.next = node1_3;
		node1_3.next = node1_4;
		node1_4.next = node1_5;
		node1_5.next = node1_6;
		node1_6.next = node1_7;
		
		Node<Integer> node2_1 = new Node<Integer>(3);
		Node<Integer> node2_2 = new Node<Integer>(1);
		
		node2_1.next = node2_2;
		node2_2.next = node1_5; //They intersect here
	
		System.out.println("List1: " + node1_1);
		System.out.println("List2: " + node2_1);
		System.out.println();
		
		Node<Integer> intersection1 = findIntersection1(node1_1, node2_1);
		System.out.println("Intersection1: " + intersection1);
		System.out.println();
		
		Node<Integer> intersection2 = findIntersection2(node1_1, node2_1);
		System.out.println("Intersection2: " + intersection2);
		System.out.println();
		
		Node<Integer> intersection3 = findIntersection3(node1_1, node2_1);
		System.out.println("Intersection3: " + intersection3);
	}
	
	/*
	 * Store the lists into two stacks
	 * Compare the stacks
	 */
	public static Node<Integer> findIntersection3(Node<Integer> node1, Node<Integer> node2) {
		Stack<Node<Integer>> stack1 = new Stack<Node<Integer>>();
		Stack<Node<Integer>> stack2 = new Stack<Node<Integer>>();
		
		while (node1 != null) {
			stack1.push(node1);
			node1 = node1.next;
		}
		
		while (node2 != null) {
			stack2.push(node2);
			node2 = node2.next;
		}
		
		Node<Integer> intersection = null;
		
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			Node<Integer> top1 = stack1.pop();
			Node<Integer> top2 = stack2.pop();
			
			if (top1 == top2) {
				intersection = top1;
			} else {
				break;
			}
		}
		
		return intersection;
	}
	
	/*
	 * Get the sizes of the two lists
	 * Chop the longer list from the font so that it will become the same size as the shorter one
	 * Start traversing until intersecting found
	 */
	public static Node<Integer> findIntersection2(Node<Integer> node1, Node<Integer> node2) {
		int size1 = size(node1);
		int size2 = size(node2);
		
		Node<Integer> shorter = size1 < size2 ? node1: node2;
		Node<Integer> longer = size1 < size2 ? node2: node1;
		
		for (int i = 0; i < Math.abs(size1 - size2); i++) {
			longer = longer.next;
		}
		
		System.out.println("Shorter list:\n" + shorter);
		System.out.println("Chopped longer list:\n" + longer);
		
		while (longer != null) {
			if (shorter == longer) {//reference equality
				return longer;
			}
			
			shorter = shorter.next;
			longer = longer.next;
		}
		return null;
	}
	
	/*
	 * Get the sizes of the two lists
	 * Pad the shorter list with dummy nodes in the front
	 * Start traversing until intersecting found
	 */
	public static Node<Integer> findIntersection1(Node<Integer> node1, Node<Integer> node2) {
		int size1 = size(node1);
		int size2 = size(node2);
		
		Node<Integer> shorter = size1 < size2 ? node1: node2;
		Node<Integer> longer = size1 < size2 ? node2: node1;
		
		for (int i = 0; i < Math.abs(size1 - size2); i++) {
			Node<Integer> newNode = new Node<Integer>(0);
			newNode.next = shorter;
			shorter = newNode;
		}
		
		System.out.println("Shorter list with padded nodes:\n" + shorter);
		System.out.println("Longer list:\n" + longer);
		
		while (longer != null) {
			if (shorter == longer) {//reference equality
				return longer;
			}
			
			shorter = shorter.next;
			longer = longer.next;
		}
		return null;
	}
	
	private static int size(Node<Integer> node) {
		int size = 0;
		
		while (node != null) {
			size++;
			node = node.next;
		}
		
		return size;
	}

}
