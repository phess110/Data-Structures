/*
 * Peter Hess
 * 2/21/17
 * CSC 172 Lab 8 - Binary Search Trees
 */

public class BinarySearchTree<T extends Comparable<T>> implements BST<T> {

	public TreeNode<T> root;

	public BinarySearchTree() {
		root = null;
	}

	public BinarySearchTree(T item) {
		root = new TreeNode<>();
		root.data = item;
	}

	/**
	 * Inserts new node into appropriate position in tree.
	 */
	public void insert(T x) {
		if (root == null) { // Test if tree is empty.
			root = new TreeNode<>();
			root.data = x;
			return;
		}
		root.insert(x); // Call to insert in TreeNode class
	}

	/**
	 * Deletes node from tree with given data
	 * 
	 * @param x value of node to delete
	 */
	public void delete(T x) {
		TreeNode<T> target = null; // Node with data to be deleted
		TreeNode<T> parent = null; // Parent of target
		TreeNode<T> node = root;

		while (node != null) {
			if (x == node.data) { // Found node to remove
				target = node;
				break;
			} else if (x.compareTo(node.data) > 0) { // Go right
				parent = node;
				node = node.rightChild;
			} else { // Go left
				parent = node;
				node = node.leftChild;
			}
		}

		if (target == null) {
			return; // Not present, exit method.
		}

		if (target == root) { // Special case where node to be removed is the
								// root.
			if (root.isLeaf()) { // Root is leaf
				root = null;
				return;
			} else if (root.rightChild == null) { // One left child
				root.leftChild.parent = null;
				root = root.leftChild;
				return;
			} else if (root.leftChild == null) { // One right child
				root.rightChild.parent = null;
				root = root.rightChild;
				return;
			} else { // Two children
				root.data = root.rightChild.data;
				root.rightChild = null;
				return;
			}
		}
		// Node to be removed isn't a leaf.
		if (target.isLeaf()) { // Delete leaf
			if (target == parent.leftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		} else if (target.leftChild != null && target.rightChild != null) { // Two
																			// children
			node = getLMC(target.rightChild);
			target.data = node.data;
			if (node.isLeaf()) {
				(node.parent).leftChild = null;
			} else {
				(node.rightChild).parent = node.parent;
				(node.parent).rightChild = node.rightChild;
			}
		} else { // One child
			if (target.leftChild == null) { // One right child
				if (target == parent.leftChild) { // Is target a left or right
													// child of its parent
					parent.leftChild = target.rightChild;
				} else {
					parent.rightChild = target.rightChild;
				}
			} else { // One left child
				if (target == parent.leftChild) { // Is target a left or right
													// child of its parent
					parent.leftChild = target.leftChild;
				} else {
					parent.rightChild = target.leftChild;
				}
			}
		}
	}

	/**
	 * @param node
	 *            root of the right subtree
	 * @return leftmost node in subtree
	 */
	public TreeNode<T> getLMC(TreeNode<T> node) {
		TreeNode<T> lmc = node;
		while (lmc.leftChild != null) {
			lmc = lmc.leftChild;
		}
		return lmc;
	}

	/**
	 * @param x
	 *            data to search for
	 * @return true if x is found, false otherwise
	 */
	public boolean lookup(T x) {
		if (root == null)
			return false;

		return root.lookup(x);
	}

	// Prints tree data in preorder (node, lc, rc).
	public void printPreOrder() {
		if (root != null)
			root.printPreOrder();
	}

	// Prints tree data in preorder (lc, node, rc).
	public void printInOrder() {
		if (root != null)
			root.printInOrder();
	}

	// Prints tree data in postorder (lc, rc, node).
	public void printPostOrder() {
		if (root != null)
			root.printPostOrder();
	}
}
