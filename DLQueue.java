/*
 * Author: Peter Hess
 * 2/18/17
 * CSC 172 Lab 7- Queues
 */

public class DLQueue<E> implements Queue<E>{
	
	private DoublyLList<E> myQueue;
	
	public DLQueue(){
		myQueue = new DoublyLList<>();
	}
	
	/**
	 * @return true if queue is empty. 
	 */
	public boolean isEmpty(){return myQueue.isEmpty();}
	
	/**Adds item to end of queue.*/
	public void enqueue(E item){myQueue.insert(item);}
	
	/**
	 * Removes item from front of non-empty queue.
	 * @return item removed.
	 */
	public E dequeue(){
		if(myQueue.isEmpty()){
			return null;	
		}
		E item = myQueue.getFirst().next.data;
		myQueue.delete();
		return item;	
	}
	
	/**
	 * @return Data stored in first node in the queue.
	 */
	public E peek(){return myQueue.getFirst().next.data;}
}
