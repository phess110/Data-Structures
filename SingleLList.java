/*
 * Peter Hess
 * 2/7/17
 * CSC 172 Lab 4 - Linked Lists
 */

public class SingleLList<T> implements SingleLinkedList<T>{

    private SNode<T> head;

    /*
     * List constructor - Initializes head to null.
     */
    public SingleLList(){
        head = null;
    }

    /*
     * Returns true if list contains no elements, false otherwise.
     */
    public boolean isEmpty(){
        return head == null;
    }

    /*
     * Inserts SNode to front of list with data x, unless it's already in the list.
     * insert() is O(n), since it calls contains() which is O(n), while the rest of insert is a bunch of O(1) operations.
     */
    public void insert(T x){
        if(this.contains(x)) 	//Don't insert if list contains x.
            return;
        SNode<T> newLink = new SNode<T>();
        newLink.data = x;
        if(head == null) 		//Case where list is empty.
            head = newLink;
        else{					//Case where list is non-empty.
            newLink.next = head;
            head = newLink;
        }
    }

    /*
     * Deletes node from list with given data. Does nothing if not present.
     */
    public void delete(T x){
        if(this.isEmpty()) 					//Exits if list is empty.
            return;
        if(x.equals(head.data)){ 			//Case where element to be removed is at the front of list.
            head = head.next;
            return;
        }
        SNode<T> iter = head;
        while((iter.next).next != null){ 	//Traverses rest of list, deleting if found.
            if(x.equals((iter.next).data)){
                iter.next = (iter.next).next;
                return;
            }
            iter = iter.next;
        }
        if(x.equals(iter.next.data)) 		//Case where element to be removed is at the end of list.
        	 iter.next = (iter.next).next;
    }

    /*
     * Returns true if x (data) is found in the list, false otherwise.
     */
    public boolean contains(T x){
        SNode<T> iter = head;
        while(iter != null){ 
            if((iter.data).equals(x))
                return true;
            iter = iter.next;
        }
        return false;
    }

    /*
     * Returns data of the node containing x (data) if found, null otherwise.
     */
    public T lookup(T x){
        SNode<T> iter = head; //Prevents changes to head for some reason
        while(iter != null){
            if(x.equals(iter.data)){
                return iter.data;
            }
            iter = iter.next;
        }
        return null;
    }

    /*
     * Prints the contents of the list. Must iterate through all elements of the list, and perform a constant time 
     * operation on each, thus printlist() is O(n), where n is the length of the list.
     */
    public void printList(){
        SNode<T> iter = head;
        while(iter != null){
            System.out.print(iter.data + " ");
            iter = iter.next;
        }
        System.out.println();
    }
}

