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
	    String ret = "[";
	    Queue<Integer> preorderQ = preorderToStringHelper(root);
	    while (!preorderQ.isEmpty())
	    	ret += preorderQ.remove() + ",";
	    ret = ret.substring(0, ret.length() - 1);
	    ret += "]";
	    return ret;
	}

	public Queue<Integer> preorderToStringHelper (Node root) {
		LinkedList<Integer> preorderQ = new LinkedList<Integer>();

		if (root == null)
			return q;

		preorderQ.add(root.key);
		if (root.left != null)
			preorderQ.addAll(preorderToStringHelper(root.left));
		if (root.right != null)
			preorderQ.addAll(preorderToStringHelper(root.right));
		return preorderQ;
	}

	/* This is for the postorder traversal */
	public String postorderToString(){
	    String ret = "[";
	    Queue<Integer> postorderQ = postorderToStringHelper(root);
		while (!postorderQ.isEmpty())
			ret += postorderQ.remove() + ",";
		ret = ret.substring(0, ret.length() - 1);
		ret += "]";
		return ret;
	}

	public Queue<Integer> postorderToStringHelper(Node root) {
		LinkedList<Integer> postorderQ = new LinkedList<Integer>();

		if (root == null)
			return q;

		if (root.left != null)
			postorderQ.addAll(postorderToStringHelper(root.left));
		if (root.right != null)
			postorderQ.addAll(postorderToStringHelper(root.right));
		postorderQ.add(root.key);
		return postorderQ;
	}
	
	/* This is for the level order (BFS) */
	public String levelorderToString(){
		// Add all nodes from each level to queue before we go down a level and add children
		String ret = new String("[");
		Queue<Node> nodes = new LinkedList<Node>();
	    nodes.add(root);

	    while (!nodes.isEmpty()) {
	    	Node temp = nodes.remove();
	    	ret += temp.key + ",";

	    	if (temp.left != null) {
	    		nodes.add(temp.left);
			}
	    	if (temp.right != null) {
	    		nodes.add(temp.right);
			}
		}
		ret = ret.substring(0, ret.length() - 1);
		ret += "]";
	    return ret;
	}
}
