import linkedlist.LinkedList;
import linkedlist.Node;
import java.util.*;

public class RemoveDupsInALinkedList {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] {3,5,1,2,3,4,3,1,6,4};
		
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		linkedlist.insertAll(arr);
		
		System.out.println(linkedlist);
		removeDup(linkedlist.head);
		System.out.println(linkedlist);
	}
	

	/*
	 * O(n) time and O(n) space
	 */
	public static void removeDup(Node<Integer> node) {
		Set<Integer> set = new HashSet<Integer>();
		Node<Integer> previous = null; 
		
		while (node != null) {
			if (set.contains(node.value)) {
				previous.next = node.next;
			} else {
				set.add(node.value);
				previous = node;
			}
			node = node.next;
		}
	}
	
	/*
	 * O(n2) time, O(1) space
	 */
	public static void removeDup2(Node<Integer> node) {
		
		while (node != null) {
			Node<Integer> node2 = node.next;
			Node<Integer> previous2 = null;
			while (node2 != null) {
				if (node.value == node2.value) {
					previous2.next = node2.next;
				} else {
					previous2 = node2;
				}
				node2 = node2.next;
			}
			node = node.next;
		}
	}
}
