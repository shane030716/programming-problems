package binarytree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
	public void insert(T value) {
		if (this.root == null) {
			this.root = new Node<T>(value);
			return;
		}
		insert(this.root, value);
	}
	
	private void insert(Node<T> node, T value) {
		if (node.data.compareTo(value) > 0) {
			if (node.left == null) {
				node.left = new Node<T>(value);
			} else {
				insert(node.left, value);
			}
		} else {
			if (node.right == null) {
				node.right = new Node<T>(value);
			} else {
				insert(node.right, value);
			}
		}
	}
}
