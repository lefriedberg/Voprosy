

public class AVLTree<Key extends Comparable<? super Key>, E> extends BST<Key, E> {
	 private AVLNode<Key,E> root; // Root of the AVLT
	 private int nodecount;
	 private LStack<AVLNode<Key, E>> s = new LStack<AVLNode<Key, E>>();
	
	public void balance(){ //O(log(n))
		System.out.println("BALANCE");
		AVLNode<Key,E> curr = root;
		AVLNode<Key,E> a1;
		r: while(true){
			s.push(curr);
			a1 = curr;
			if(curr.left() != null){
				if(curr.left().balcheck())
					curr = curr.left();
			}else if(curr.right() != null){
				if(curr.right().balcheck())
					curr = curr.right();
			}
			if(curr == a1)	
				break r;
		}
		boolean a;
		while(s.topValue() != root){
			curr = s.pop();
			a = s.topValue().left().equals(curr);
			if(curr.balance() < 1){ //left heavy
				if(curr.left().balance() > 0)
					DRrotate(s.topValue(), a);
				else
					Rrotate(s.topValue(), a);
			}else if(curr.balance() > 1){ //right heavy
				if(curr.left().balance() < 0)
					DLrotate(s.topValue(), a);
				else
					Lrotate(s.topValue(), a);
		}
		}
		if (root.balance() < 1){
			if(root.left().balance() > 0)
				Lrotate(root, true);
			rootrotate(false);
		}else if (root.balance() > 1){
			if(root.right().balance() < 0){
				Rrotate(root, false);
			}
			rootrotate(true);
		
		}
		s.pop();
	}
	 
	public AVLTree(Key k, E e){
		root = new AVLNode<Key,E>();
		root.setElement(e);
		root.setKey(k);
		root.findweight();
	}
	
	 public AVLNode<Key, E> finda(Key k) { return findhelpa(root, k); } //O(log(n))
	  
	 AVLNode<Key, E> findhelpa(AVLNode<Key,E> rt, Key k) {
		 System.out.println("FINDHELPA");
		 if (rt == null) return rt;
		 if (rt.key() == null) System.out.println("OIC");
		 else System.out.println("Once");
	  if (rt.key().compareTo(k) > 0)
	    return findhelpa(rt.left(), k);
	  else if (rt.key().compareTo(k) == 0) return rt;
	  else return findhelpa(rt.right(), k);
	}
	
	  public void insert(Key k, E e) {
		    root = inserthelp(root, k, e);
		    balance();
		    nodecount++;
		  }
	
	AVLNode<Key,E> inserthelp(AVLNode<Key,E> rt, //changed to mark every node visited to get to insert. O(logn)
                      Key k, E e) {
			  if (rt == null) return new AVLNode<Key,E>(k, e);
			  rt.bc(true);
			  if (rt.key().compareTo(k) > 0)
			    rt.setLeft(inserthelp(rt.left(), k, e));
			  else
			    rt.setRight(inserthelp(rt.right(), k, e));
			  return rt;
	}
	
	private void rootrotate(boolean a){//if a rotate left, right otherwise 
		AVLNode<Key, E> curr;
		if(a){
			if(root.right() != null){
				curr = root.right();
				root.setRight(curr.left());
				curr.setLeft(root);
				root = curr;
				
			}
		}else{
			if(root.left() != null){
				curr = root.left();
				root.setLeft(curr.right());
				curr.setRight(root);
				root = curr;
				curr.findweight();
				root.findweight();
			}
		}
		
	}
	
	private void Lrotate(AVLNode<Key, E> N, boolean a){ //a is true if the left child of N rotates, false otherwise
		AVLNode<Key, E> curr;
		if(a)
			curr = N.left();
		else
			curr = N.right();
		AVLNode<Key, E> a1 = curr.right();
		curr.setRight(a1.left());
		a1.setLeft(curr);
		if(a)
			N.setLeft(a1);
		else
			N.setRight(a1);	
		curr.findweight();
		a1.findweight();
	}
	
	private void Rrotate(AVLNode<Key, E> N, boolean a){ //see above. all rotations are O(1)
		AVLNode<Key, E> curr;
		if(a){
			curr = N.left();
		}else{
			curr = N.right();
		}	
		AVLNode<Key, E> a1 = curr.left();
		curr.setLeft(a1.right());
		a1.setRight(curr);
		if(a)
			N.setLeft(a1);
		else
			N.setRight(a1);
		curr.findweight();
		a1.findweight();
	}
	
	private void DLrotate(AVLNode<Key, E> N, boolean a){ // double rotate left
		AVLNode<Key, E> curr;
		if(a){
			curr = N.left();
		}else{
			curr = N.right();
		}
		if(curr != null){
			Rrotate(curr, false);
			Lrotate(N, a);
		}
	}
	
	private void DRrotate(AVLNode<Key, E> N, boolean a){ //double rotate right
		AVLNode<Key, E> curr;
		if(a){
			curr = N.left();
		}else{
			curr = N.right();
		}
		if(curr != null){
			Lrotate(curr, true);
			Lrotate(N, a);
		}
	}
	
 
}
