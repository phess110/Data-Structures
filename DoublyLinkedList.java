/*
 * Peter Hess
 * 2/9/17
 * CSC 172 Lab 5 - Doubly Linked Lists
 * 
 * Code src: Lab 5 handout.
 */

public interface DoublyLinkedList<T>{
	public void insert(T x);
	public void delete(T x);
	public boolean contains(T x);
	public T lookup(T x);
	public boolean isEmpty();
	public void printList();
	public void printListRev();
}