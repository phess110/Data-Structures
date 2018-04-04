/*
 * Author: Peter Hess
 * 2/14/17
 * CSC 172 Lab 6 - Stacks
 */

public class LStack<E> implements Stack<E> {
	private SingleLList<E> theStack;
	
	public LStack(){
		theStack = new SingleLList<E>();
	}
	/**
	 * @return True if list is empty, false otherwise.
	 */
	public boolean isEmpty(){return theStack.isEmpty();}
	
	/**
	 * Add item to top of stack.
	 */
	public void push(E x){theStack.insertFront(x);}
	
	/**
	 * Remove item from top of stack.
	 * @return item removed.
	 */
	public E pop(){
		if(theStack.isEmpty())
			return null;
		E x = theStack.getData();
		theStack.delete();
		return x;
	}
	
	/**
	 * @return item on top of stack.
	 */
	public E peek(){
		if(theStack.isEmpty())
			return null;
		return theStack.getData();}
}
