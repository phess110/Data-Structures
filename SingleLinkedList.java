/*
 * Peter Hess
 * 2/7/17
 * CSC 172 Lab 4 - Linked Lists
 * 
 * Code src: Lab 4 handout.
 */

public interface SingleLinkedList<T> {
	public void insert(T x);
	public void delete(T x);
	public boolean contains(T x);
	public T lookup(T x);
	public boolean isEmpty();
	public void printList();
}
