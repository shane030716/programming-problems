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
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.insert(8);
		bst.insert(4);
		bst.insert(10);
		bst.insert(1);
		bst.insert(5);
		bst.insert(7);
		bst.insert(15);
		bst.insert(12);
		
		bst.preOrderStr();
		bst.inOrderStr();
		bst.postOrderStr();
		bst.levelOrderStr();
		
		convert(bst);
	}
	
	public static <T> void convert(BinaryTree<T> bt) {
		
		Node<T> head = convert(bt.getRoot(), true);
		printBinaryTreeAsADoubleLinkedList(head);
		
	}
	
	private static <T> Node<T> convert(Node<T> node, boolean head) {
		if (node == null) {
			return null;
		}

		Node<T> prev = convert(node.left, false);
		Node<T> next = convert(node.right, true);
		
		node.left = prev;
		if (prev != null) {
			prev.right = node;
		}
		
		node.right = next;
		if (next != null) {
			next.left = node;
		}
		
				
		return getHeadOrTail(node, head);

	}
	
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
