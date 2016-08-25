package linkedlist;

public class LinkedList<T> {
	public Node<T> head;
	
	public void insert(T value) {
		Node<T> newNode = new Node<T>(value);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> node = head;
			while (node.next != null) {
				node = node.next;
			}
			node.next = newNode;
		}
	}
	
	public void reverse() {
		reverseHelper(this.head);
	}
	
	private void reverseHelper(Node<T> root) {
		Node<T> node = root;
		
		Node<T> head = null;
		Node<T> tail = null;
		
		while (node != null) {
			head = new Node<T>(node.value);
			
			if (tail == null) {
				tail = head;
			} else {
				head.next = tail;
				tail = head;
			}
			node = node.next;
		}
		
		this.head = head;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		Node<T> node = head;
		while(node != null) {
			builder.append(node.value);
			if (node.next != null) {
				builder.append(" -> ");
			}
			node = node.next;
		}
		return builder.toString();
	}
}
