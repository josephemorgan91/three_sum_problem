package Main;

import java.util.LinkedList;
import java.util.Queue;

public class BST{
	// Fields
	private Node root;			// Top-level node in tree
	private int n;				// Number of nodes in tree
	private Queue<Integer> q;	// Used for the inorder toString method
	
	public class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int key) { 
            this.key = key; 
            left = right = null; 
        } 
	}
	
	// Constructor
	public BST(){
		root = null;
		n = 0;
	}
	
	// Methods
	public void insert(int key){
		root = insertHelper(root, key);
	}
	
	private Node insertHelper(Node root, int key){
		if(root == null){
			root = new Node(key);
			n++;
			return root;
		}
		if(key < root.key){
			root.left = insertHelper(root.left, key);
		}else if(key > root.key){
			root.right = insertHelper(root.right, key);
		}
		return root;
	}
	
	public boolean search(int key){
		return searchHelper(root, key);
	}
	
	private boolean searchHelper(Node root, int key){
		if(root == null)
			return false;
		if(root.key == key)
			return true;
		if(key < root.key)
			return searchHelper(root.left, key);
		return searchHelper(root.right, key);
	}
	
	public void delete(int key){
		root = deleteHelper(root, key);
	}
	
	private Node deleteHelper(Node root, int key){
		if(root == null)
			return null;
		if(key < root.key){
			root.left = deleteHelper(root.left, key);
		}else if(key > root.key){
			root.right = deleteHelper(root.right, key);
		}else{
			if(root.left == null){
				n--;
				return root.right;
			}
			else if(root.right == null){
				n--;
				return root.left;
			}
			// Here is where we decide how to delete...
			root.key = minNodeKey(root.right);
			root.right = deleteHelper(root.right, root.key);
		}
		return root;
	}
	
	private int minNodeKey(Node root) 
    { 
        int min = root.key; 
        while (root.left != null) 
        { 
            min = root.left.key; 
            root = root.left; 
        } 
        return min; 
    } 
	
	public int size(){
		return n;
	}
	
	public void clear(){
		root = null;
		n = 0;
	}
	
	/* This will return the keys of the BST in an inorder traversal */
	public String toString(){
		String ret = "[";
		q = new LinkedList<Integer>();
		inorder(root);
		while(!q.isEmpty()){
			ret += q.remove() + ",";
		}
		ret = ret.substring(0, ret.length()-1);
		ret +="]";
		return ret;
	}
	
	private void inorder(Node node){
		if(node == null)		return;
		inorder(node.left);
		q.add(node.key);
		inorder(node.right);
	}
	
	/* This is for the preorder traversal */
	public String preorderToString(){
		// TODO: Remove when complete
		return null;	// Placeholder to prevent Java error; remove when complete
	}
	
	/* This is for the postorder traversal */
	public String postorderToString(){
		// TODO: Remove when complete
		return null;	// Placeholder to prevent Java error; remove when complete
	}
	
	/* This is for the level order (BFS) */
	public String levelorderToString(){
		// TODO: Remove when complete
		return null;	// Placeholder to prevent Java error; remove when complete
	}
}