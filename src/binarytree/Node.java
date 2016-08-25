package binarytree;

public class Node<T> {
	public T data;
	public Node<T> left;
	public Node<T> right;
	
	public Node(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
	
}