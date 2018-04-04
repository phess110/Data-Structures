/*
 * Peter Hess
 * 2/21/17
 * CSC 172 Lab 8 - Binary Search Trees
 */

public class TreeNode<T extends Comparable<T>> {
	public T data;
	
	public TreeNode<T> leftChild;
	public TreeNode<T> rightChild;
	public TreeNode<T> parent;
	
	public void insert(T key){
		 if(key.compareTo(data) < 0){
			 if(leftChild == null){
				 TreeNode<T> newNode = new TreeNode<>();
				 newNode.data = key;
				 newNode.parent = this;
				 leftChild = newNode;
			 }
			 else
				 leftChild.insert(key);
		 }
		 else if(key.compareTo(data) > 0){
				 if(rightChild == null){
					 TreeNode<T> newNode = new TreeNode<>();
					 newNode.data = key;
					 newNode.parent = this;
					 rightChild = newNode;
				 }
				 else
					 rightChild.insert(key);
		 }
	}
	
	public boolean isLeaf(){
		return leftChild == null && rightChild == null;
	}
	
	public void printPreOrder(){
		System.out.print(this.data + " ");
		
		if(leftChild != null)
			leftChild.printPreOrder();
		
		if(rightChild != null)
			rightChild.printPreOrder();
	}
	
	public void printInOrder(){
		if(leftChild != null)
			leftChild.printInOrder();
		
		System.out.print(this.data + " ");
		
		if(rightChild != null)
			rightChild.printInOrder();
	}
	
	public void printPostOrder(){
		if(leftChild != null)
			leftChild.printPostOrder();
		
		if(rightChild != null)
			rightChild.printPostOrder();
		
		System.out.print(this.data + " ");
	}
	
	public boolean lookup(T x){
		if (data == x){return true;}
		else if (x.compareTo(data) < 0){
			if (leftChild != null) 
				return leftChild.lookup(x);
		}
		else if (x.compareTo(data) > 0){
			if (rightChild != null) 
				return rightChild.lookup(x);
		}
		return false;
	}

}