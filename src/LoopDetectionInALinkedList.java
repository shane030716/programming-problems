import linkedlist.Node;

public class LoopDetectionInALinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> node1 = new Node<Integer>(0);
		Node<Integer> node2 = new Node<Integer>(1);
		Node<Integer> node3 = new Node<Integer>(2);
		Node<Integer> node4 = new Node<Integer>(3);
		Node<Integer> node5 = new Node<Integer>(4);
		Node<Integer> node6 = new Node<Integer>(5);
		Node<Integer> node7 = new Node<Integer>(6);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node4;
		//0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 3 (The fourth node)
		Node<Integer> intersection = findLoop(node1);
		System.out.println(intersection.value);
		
	}
	
	public static Node<Integer> findLoop(Node<Integer> head) {
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow == fast) {
				break;
			}
		}
		
		if (fast == null | fast.next == null) {
			return null;
		}
		
		while (head != fast) {
			head = head.next;
			fast = fast.next;
		}
		return fast;
	}

}
