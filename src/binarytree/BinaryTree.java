package binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {
	protected Node<T> root;
	
	static class Queue<T> {
		List<T> queue = new ArrayList<T>();
		
		public void enqueue(T node) {
			queue.add(node);
		}
		
		public T dequeue() {
			if (this.isEmpty()) {
				return null;
			}
			return queue.remove(0);
		}
		
		public boolean isEmpty() {
			return queue.isEmpty();
		}
		
		
	}

	
	public void preOrderStr() {
		preOrderStrHelper(this.root);
		System.out.println();
	}
	
	private void preOrderStrHelper(Node<T> node) {
		if (node == null) {
			return;
		}
		
		System.out.print(node + ", ");
		preOrderStrHelper(node.left);
		preOrderStrHelper(node.right);
	}
	
	public void inOrderStr() {
		inOrderStrHelper(this.root);
		System.out.println();
	}
	
	private void inOrderStrHelper(Node<T> node) {
		if (node == null) {
			return;
		}
		
		inOrderStrHelper(node.left);
		System.out.print(node + ", ");
		inOrderStrHelper(node.right);
		
	}
	
	public void postOrderStr() {
		postOrderStrHelper(this.root);
		System.out.println();
	}
	
	private void postOrderStrHelper(Node<T> node) {
		if (node == null) {
			return;
		}
		
		postOrderStrHelper(node.left);
		postOrderStrHelper(node.right);
		System.out.print(node + ", ");
	}
	
	public void levelOrderStr() {
		if (this.root == null) {
			return;
		}
		
		Queue<Node<T>> queue = new Queue<Node<T>>();
		queue.enqueue(this.root);
		
		while (!queue.isEmpty()) {
			Node<T> node = queue.dequeue();
			System.out.print(node + ", ");
			
			if (node.left != null) {
				queue.enqueue(node.left);
			}
			
			if (node.right != null) {
				queue.enqueue(node.right);
			}
		}
		System.out.println();
	}

	public Node<T> getRoot() {
		return root;
	}
	
	
}
