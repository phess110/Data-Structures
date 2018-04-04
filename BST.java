/*
 * Peter Hess
 * 2/21/17
 * CSC 172 Lab 8 - Binary Search Trees
 */

public interface BST<T extends Comparable<T>> {
	public void insert(T x);
	public void delete(T x);
	public boolean lookup(T x);
	public void printPreOrder();
	public void printInOrder();
	public void printPostOrder();
}