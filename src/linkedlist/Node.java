package linkedlist;

public class Node<T> {
	public T value;
	public Node<T> next;
	
	public Node(T value) {
		this.value = value;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		Node<T> node = this;
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