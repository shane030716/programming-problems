package binarytree;

public class BSTDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.insert(6);
		bst.insert(2);
		bst.insert(1);
		bst.insert(4);
		bst.insert(3);
		bst.insert(7);
		bst.insert(9);
		bst.insert(8);
		
		bst.preOrderStr();
		bst.inOrderStr();
		bst.postOrderStr();
		bst.levelOrderStr();
	}

}
