

public class AVLNode<Key, E> extends BSTNode<Key, E>{
	private int weight;
	private int balance;
	private boolean balcheck = false;
	private Key key;              
	private E element;            
	private AVLNode<Key,E> left;  
	private AVLNode<Key,E> right; 
	
	
	//constructors
	public AVLNode(){ 
		weight = 0;
	}
	public AVLNode(Key k, E e){
		key = k;
		element = e;
		weight = 0;
	}

	//returns balance
	public boolean balcheck(){
		return balcheck;
	}
	
	//sets balcheck
	public void bc(boolean a){
		balcheck = a;
	}
	
	//get and set left
	public AVLNode<Key,E> left(){
		return left; 
	}
	public void setLeft(AVLNode<Key,E> p){
		left = p; 
		findweight();
	}

	//get and set right
	public AVLNode<Key,E> right(){
		return right;
	}
	public void setRight(AVLNode<Key,E> p){
		right = p;
		findweight();
	}
	
	//verifies weight (height) of the node O(logn) & returns it
	public int findweight(){
		if(isLeaf()) weight = 1;
		else if(right() == null){
			return left.findweight();
		} else if(left() == null){
			return right.findweight();
		}else
			weight += max(left().findweight(), right().findweight());
		return weight;
		
	}
	
	public int max(int a, int b){ //This needs to exist.
		if(a>=b)
			return a;
		return b;
	}
	
	//returns balance of the node O(1)
	public int balance(){
		balance = 0;
		if(left != null){
			balance = balance - left.weight;
		}
		if(right != null){
			balance += right.weight;
		}
		return balance;
	}
}
