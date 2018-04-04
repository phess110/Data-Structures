/*
 * Peter Hess
 * 2/22/17
 * CSC 172 - Lab 9: Heaps
 */

public interface myHeap<E extends Comparable<E>> {
	public void insert(E item);
	public boolean isEmpty();
	public int size();
	public E deleteMin();
}