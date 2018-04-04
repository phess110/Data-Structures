/*
 * Peter Hess
 * 2/22/17
 * CSC 172 - Lab 9: Heaps
 */

public class Heap<E extends Comparable<E>> implements myHeap<E> {
	private E[] theHeap;
	private int size; // Current size
	private int capacity; // Max size

	@SuppressWarnings("unchecked")
	public Heap() {
		theHeap = (E[]) new Comparable[10]; // Default capacity = 10
		size = 0;
		capacity = 10;
	}

	@SuppressWarnings("unchecked")
	public Heap(int leng) {
		if (leng < 1) {
			System.out.println("Invalid heap capacity");
			return;
		}
		theHeap = (E[]) new Comparable[leng];
		size = 0;
		capacity = leng;
	}
	
	@SuppressWarnings("unchecked")
	public Heap(E[] vals){
		theHeap = (E[]) new Comparable[1 + vals.length];
		size = vals.length;
		capacity = theHeap.length;
		for(int i = 1; i <= vals.length; i++ ){
			theHeap[i] = vals[i - 1];
		}
		theHeap = heapify(theHeap);
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * @param item to be inserted into heap.
	 */
	public void insert(E item) {
		size++;
		if (size >= capacity)
			expandHeap();
		theHeap[size] = item;
		bubbleUp();
	}

	/**
	 * Moves inserted item to correct position in heap.
	 */
	public void bubbleUp() {
		int curr = size;
		while (curr != 1) {
			int parent = curr / 2; // Position of parent
			if (theHeap[curr].compareTo(theHeap[parent]) < 0) { // Min heap: <  OR  Max heap: >
				E temp = theHeap[curr];
				theHeap[curr] = theHeap[parent];
				theHeap[parent] = temp;
				curr = parent;
			} else {
				break;
			}
		}
	}

	/**
	 * Doubles the capacity of the current heap array.
	 */
	@SuppressWarnings("unchecked")
	public void expandHeap() {
		capacity*= 2;
		E[] enlarged = (E[]) new Comparable[capacity];
		for (int i = 0; i < size; i++) {
			enlarged[i] = theHeap[i];
		}
		theHeap = enlarged;
	}

	/**
	 * @return E the maximum value in the heap.
	 */
	public E deleteMin() {
		if (isEmpty())
			return null;
		E deleted = theHeap[1];
		if (size() == 1) {
			theHeap[1] = null;
			size--;
			return deleted;
		}
		theHeap[1] = theHeap[size];
		theHeap[size] = null;
		size--;
		bubbleDown();
		return deleted;
	}

	/**
	 * Rearranges heap after a deletion to the correct ordering.
	 */
	public void bubbleDown() {
		int curr = 1;
		int child;
		while (2*curr <= size) {
			if (2 * curr + 1 <= size && theHeap[2 * curr].compareTo(theHeap[2 * curr + 1]) > 0) { //Min heap: >  OR  Max heap: <
				child = 2 * curr + 1;
			} else
				child = 2 * curr;
			if (theHeap[curr].compareTo(theHeap[child]) > 0) { //Min heap: >  OR  Max heap: <
				E temp = theHeap[curr];
				theHeap[curr] = theHeap[child];
				theHeap[child] = temp;
				curr = child;
			} else {
				break;
			}
		}
	}

	public void printHeap() {
		for (int i = 1; i <= size; i++)
			System.out.print(theHeap[i] + " ");
		System.out.println();
	}
	
	/**
	 * Converts a random array into a min heap.
	 * @param toHeap Array to be transformed
	 * @return Transformed array
	 */
	public E[] heapify(E [] toHeap){
		for(int k = toHeap.length/2; k >= 1; k--){
			int curr = k;
			int child;
			while (2*curr < toHeap.length) {
				if (2 * curr + 1 < toHeap.length && toHeap[2 * curr].compareTo(toHeap[2 * curr + 1]) > 0) { //Min heap: >  OR  Max heap: <
					child = 2 * curr + 1;
				} else
					child = 2 * curr;
				if (toHeap[curr].compareTo(toHeap[child]) > 0) { //Min heap: >  OR  Max heap: <
					E temp = toHeap[curr];
					toHeap[curr] = toHeap[child];
					toHeap[child] = temp;
					curr = child;
				} else {
					break;
				}
			}
		}
		return toHeap;
	}

	public static void main(String[] args) {
		Heap<Integer> nums = new Heap<>();
		Heap<Integer> nums2 = new Heap<>(2);
		System.out.println(nums.isEmpty());
		System.out.println(nums2.isEmpty());
		nums2.insert(9);
		System.out.println(nums2.isEmpty());
		nums2.insert(50);
		nums2.insert(1);
		nums2.insert(100);
		nums2.insert(20);
		nums2.insert(30);
		System.out.println(nums2.size());
		nums2.printHeap(); //Prints heap after all insertions (min first)
		
		nums2.deleteMin();
		nums2.printHeap();
		nums2.deleteMin();
	    nums2.deleteMin();
		nums2.printHeap();
		nums2.deleteMin();
		nums2.printHeap();
		nums2.deleteMin();
		nums2.printHeap();
		nums2.deleteMin();
		nums2.printHeap();
		System.out.println(nums2.isEmpty());
		
		Integer [] test = {100, 10, 50, 60, 0, 20, 80, 30, 70, 40, -1};
		Heap<Integer> testHeap = new Heap<>(test);
		testHeap.printHeap();
	}
}
