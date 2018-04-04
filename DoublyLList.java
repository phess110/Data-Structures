/*
 * Author: Peter Hess
 * 2/9/17
 * CSC 172 Lab 5 - Doubly Linked Lists
 */

public class DoublyLList<T> implements DoublyLinkedList<T>{

    private DNode<T> first;
    private DNode<T> last;

    
    public DoublyLList(){
        first =  new DNode<T>();
        last = new DNode<T>();
        first.next = last;
        last.prev = first;
    }

    /*
     * Inserts new node into list.
     */
    public void insert(T x){
        if(contains(x)) 	//Doesn't insert if already present in list
            return;
        DNode<T> ins = new DNode<T>();
        ins.data = x;
        ins.prev = first;
        ins.next = first.next;
        (first.next).prev = ins;
        first.next = ins;
    }

    /*
     * Deletes existing node from list with given data.
     */
    public void delete(T x){
        DNode<T> iter = first.next;
        while(iter.next != null){
            if((iter.data).equals(x)){
                (iter.prev).next = iter.next;
                (iter.next).prev = iter.prev;
                return;
            }
            iter = iter.next;
        }
    }

    /*
     * Searches list for given data. 
     * Returns true if present, false otherwise.
     */
    public boolean contains(T x){
        DNode<T> iter = first.next;
        while(iter.next != null){
            if((iter.data).equals(x))
                return true;
            iter = iter.next;
        }
        return false;
    }

    /*
     * Searches list for given data. 
     * Returns data is present, null otherwise.
     */
    public T lookup(T x){
        DNode<T> iter = first.next;
        while(iter.next != null){
            if((iter.data).equals(x))
                return iter.data;
            iter = iter.next;
        }
        return null;
    }

    /*
     * Returns true if list is empty, false otherwise.
     */
    public boolean isEmpty(){
        return first.next == last;
    }

    /*
     * Prints contents of list.
     * Runs in O(n), n = size of list.
     */
    public void printList(){
        DNode<T> iter = first.next;
        while(iter.next != null){
            System.out.print(iter.data + " ");
            iter = iter.next;
        }
        System.out.println();
    }

    /*
     * Prints contents of list in reverse.
     * Runs in O(n), n = size of list.
     */
    public void printListRev(){
        DNode<T> iter = last.prev;
        while(iter.prev != null){
            System.out.print(iter.data + " ");
            iter = iter.prev;
        }
        System.out.println();
    }
}