/*
 * Peter Hess
 * 2/18/17
 * CSC 172 Lab 7 - Queues
 * 
 * Code src: Lab 7 handout.
 */

public interface Queue<AnyType> {
	public boolean isEmpty();
	public void enqueue(AnyType x);
	public AnyType dequeue();
	public AnyType peek();
}
