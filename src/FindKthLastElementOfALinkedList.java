import linkedlist.*;

public class FindKthLastElementOfALinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = new Integer[] {3,5,1,2,3,4,3,1,6,4};
		
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		linkedlist.insertAll(arr);
		System.out.println(linkedlist);
		
		Node<Integer> node = kthLast(linkedlist.head, 3);
		System.out.println(node.value);
		
		Node<Integer> node2 = kthLast2(linkedlist.head, 3);
		System.out.println(node2.value);
		
		Index index = new Index();
		Node<Integer> node3 = kthLast3(linkedlist.head, 3, index);
		System.out.println(node3.value);
	}
	
	/*
	 * O(n) time: and O(1) space
	 */
	public static Node<Integer> kthLast(Node<Integer> node, int k) {
		Node<Integer> node2 = node;
		while (k > 0) {
			if (node2 == null) return null; //out of bounds
			node2 = node2.next;
			k--;
		}
		
		while (node2 != null) {
			node2 = node2.next;
			node = node.next;
		}
		
		return node;
	}
	
	
	/*
	 * O(n) time and O(1) space
	 */
	public static Node<Integer> kthLast2(Node<Integer> node, int k) {
		if (k <= 0) return null;
		//Find the size of the list first.
		int size = size(node);
		int i = 0;
		
		while (i < size - k) {
			node = node.next;
			i++;
		}
		
		return node;
	}
	
	public static int size(Node<Integer> node) {
		int i = 0;
		while (node != null) {
			i++;
			node = node.next;
		}
		
		return i;
	}

	/*
	 * O(n) time and O(n) space, each recursive call takes up one space
	 */
	public static Node<Integer> kthLast3(Node<Integer> node, int k, Index index){
		if (node == null) {
			return null;
		}
		
		Node<Integer> result = kthLast3(node.next, k, index);
		
		if (index.i == k) {
			return result;
		}
		index.i = index.i + 1;
		return node;
	}
	
	static class Index {
		public int i = 0;
	}
	
}
