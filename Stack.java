/*
 * Peter Hess
 * 2/14/17
 * CSC 172 Lab 6 - Stacks
 * 
 * Code src: Lab 6 handout.
 */

public interface Stack<AnyType> {
	public boolean isEmpty();
	public void push(AnyType x);
	public AnyType pop();
	public AnyType peek();
}