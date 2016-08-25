/*
 * Convert a Binary Tree to an 'in-order' double-linked list, 
 * where the left child represents previous element and the right child represent next element;
 * Example:
 * Input: 
 * 			8
 *   	  /   \
 *   	4	   10
 *     / \      \
 * 	  1   5      15
 *         \    /
 *          7  12
 * 
 * Output:
 * 1 <-> 4 <-> 5 <-> 7 <-> 8 <-> 10 <-> 12 <-> 15
 */

import binarytree.*;

public class BiNodeConversion {

	public static void main(String[] args) {
		//Create a BST as an example. It doesn't have to be a BST though, any Binary Tree will do.
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.insert(8);
		bst.insert(4);
		bst.insert(10);
		bst.insert(1);
		bst.insert(5);
		bst.insert(7);
		bst.insert(15);
		bst.insert(12);
		
		convert(bst);
	}
	/*
	 * Conversion starts here
	 */
	public static <T> void convert(BinaryTree<T> bt) {
		
		//Pass the root node, and the true boolean value, indicating whether we want the head of the result, to the helper method. 
		Node<T> head = convert(bt.getRoot(), true);
		
		//Conversion complete, print it as a linked list
		printBinaryTreeAsADoubleLinkedList(head);
		
	}
	
	/*
	 * Conversion main process
	 * @param node. The head of a tree to be converted
	 * @param head. Boolean value indicating when we want to return the head or tail of the converted linked list
	 */
	private static <T> Node<T> convert(Node<T> node, boolean head) {
		//Base case
		if (node == null) {
			return null;
		}

		//Convert the left child to a linked list and return the tail
		Node<T> prev = convert(node.left, false);
		//Convert the right child to a linked list and return the head
		Node<T> next = convert(node.right, true);
		
		//Connect the current node with the converted left(prev) list above
		//Set the left(prev) node to tail of the converted left list, even if it's null
		node.left = prev;
		if (prev != null) {
			//And then set the right(next) node of the tail of the converted left list to the current node 
			prev.right = node;
		}
		
		//Connect the current node with the converted right(next) list above
		//Set the right(next) node to the head of the converted right list above, even if it's null
		node.right = next;
		if (next != null) {
			//And then set the left(prev) node of the head of the converted right list to the current node
			next.left = node;
		}
		
		//Connection complete, now return either the head or the tail of the current list
		return getHeadOrTail(node, head);
	}
	
	/*
	 * Helper function to return the head or the tail of a current node in a linked list
	 */
	private static <T> Node<T> getHeadOrTail(Node<T> node, boolean head) {
		if (head) {
			while (node.left != null) {
				node = node.left;
			}
		} else {
			while (node.right != null) {
				node = node.right;
			}
		}
		
		return node;
	}

	private static <T> void printBinaryTreeAsADoubleLinkedList(Node<T> node) {
		if (node == null) return;
		
		System.out.print(node.data) ;
		
		while (node.right != null) {
			node = node.right;
			System.out.print(" <-> " + node.data);
		}
	}
}
