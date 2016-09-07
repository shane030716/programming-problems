import linkedlist.*;
public class DeleteMiddleNodeOfALinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = new Integer[] {3,5,1,2,3,4,3,1,6,4};
		
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		linkedlist.insertAll(arr);
		System.out.println(linkedlist);
		Node<Integer> node = linkedlist.head.next.next.next.next.next; //4
		
		deleteMiddle2(node); //node's value now becomes 3
		System.out.println(linkedlist);
		
		deleteMiddle(linkedlist.head); //delete 1
		System.out.println(linkedlist);
		
	}
	
	/*
	 * More optimal
	 * Change the current node's value to the next node's value
	 * And then update current node's next to next node's next
	 */
	public static void deleteMiddle(Node<Integer> node) {
		if (node == null || node.next == null) return;
		
		Node<Integer> next = node.next;
		node.value = next.value;
		node.next = next.next;
		
	}
	
	
	/*
	 * Keep changing the current node's value to next one's until the end
	 * And change the last node's next to null
	 */
	public static void deleteMiddle2(Node<Integer> node) {
		if (node == null || node.next == null) return;
		
		while (node.next != null && node.next.next != null) {
			node.value = node.next.value;
			node = node.next;
		}
			
		node.value = node.next.value;
		node.next = null;	
		
	}

}
