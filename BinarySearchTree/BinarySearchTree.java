package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	
	Node root;
	
	BinarySearchTree(){
		this.root=null;
	}
	
	
	public void insert(int data) {
		Node newNode = new Node(data);
		if(this.root == null) {
			root = newNode;
		}else {
			Node currentNode = this.root;
			while(true) {
				if(data < currentNode.data) {
					if(currentNode.left == null) {
						currentNode.left = newNode;
						break;
					}
					else if(currentNode.left.data<data&&currentNode.left!=null) {
						Node tempNode =currentNode.left;
						currentNode.left=newNode;
						currentNode.left.left=tempNode;
						break;
					}
					
					else {
						currentNode = currentNode.left;
					}
					
				}else if (data > currentNode.data) {
					if(currentNode.right == null) {
						currentNode.right = newNode;
						break;
					}
					else if(currentNode.right.data>data&&currentNode.left!=null) {
						Node tempNode =currentNode.right;
						currentNode.right=newNode;
						currentNode.right.right=tempNode;
						break;
					}
					
					else {
						currentNode = currentNode.right;
					}
				}
			}
		}
	}
	
	
	public boolean containsNode(int item) {
		if(this.root == null) {
			return false;
		}else {
			Node currentNode = this.root;
			boolean found = false;
			while((currentNode != null)&&(found == false)) {
				if(item < currentNode.data) {
					currentNode = currentNode.left;
				}else if(item > currentNode.data) {
					currentNode = currentNode.right;
				}else {
					found=true;
				}
			}
			if(found==true) {
				return true;
			}else {
				return false;
			}
		}
	}
	public Node searchNode(int item) {
		if(this.root == null) {
			return null;
		}else {
			Node currentNode = this.root;
			boolean found = false;
			while((currentNode != null)&&(found == false)) {
				if(item < currentNode.data) {
					currentNode = currentNode.left;
				}else if(item > currentNode.data) {
					currentNode = currentNode.right;
				}else {
					found=true;
				}
			}
			if(found==true) {
				return currentNode;
			}else {
				return null;
			}
		}
	}
	
	
	public void levelOrderTraversal(Node root) 
    {  
        if(root == null) 
            return; 
          
        Queue<Node> q =new LinkedList<Node>(); 
                 
        q.add(root); 
                    
        while(true) 
        { 
               
            int nodeCount = q.size(); 
            if(nodeCount == 0) 
                break; 
              
            while(nodeCount > 0) 
            { 
                Node node = q.remove(); 
                System.out.print(node.data + " "); 
                 
                if(node.left != null) 
                    q.add(node.left); 
                if(node.right != null) 
                    q.add(node.right); 
                nodeCount--; 
            } 
            System.out.println(); 
        } 
    }
	
	public void preOrderTraversal(Node node) {
		if(node!=null) {
			System.out.print(node.data+" ");
			if(node.left!=null) {
				preOrderTraversal(node.left);
			}
			
			if(node.right!=null) {
				preOrderTraversal(node.right);
			}
		}
	}
	
	public void postOrderTraversal(Node node) {
		if(node!=null) {
			
			if(node.left!=null) {
				postOrderTraversal(node.left);
			}
			
			if(node.right!=null) {
				postOrderTraversal(node.right);
			}
			System.out.print(node.data+" ");
		}
	}
	
	public void inOrderTraversal(Node node) {
		if(node!=null) {
			
			if(node.left!=null) {
				inOrderTraversal(node.left);
			}
			
			System.out.print(node.data+" ");
			
			if(node.right!=null) {
				inOrderTraversal(node.right);
			}
			
		}
	}
	
	
	public static void main(String[] args) {				//	tree structure
		BinarySearchTree tree = new BinarySearchTree();		//			15
		tree.insert(15);									//		10		20
		tree.insert(5);										//	5				25
		tree.insert(10);
		tree.insert(25);
		tree.insert(20);
		System.out.println("Level Order Traversel");
		tree.levelOrderTraversal(tree.root);
		System.out.println("Searching for 10 in the tree");
		System.out.println(tree.searchNode(10).data);
		System.out.println("Pre Order Traversal");
		tree.preOrderTraversal(tree.root);
		System.out.println();
		System.out.println("Post Order Traversal");
		tree.postOrderTraversal(tree.root);
		System.out.println();
		System.out.println("In Order Traversal");
		tree.inOrderTraversal(tree.root);
		
		/*
		 * OUTPUT
			Level Order Traversel
			15 
			10 20 
			5 25 
			Searching for 10 in the tree
			10
			Pre Order Traversal
			15 10 5 20 25 
			Post Order Traversal
			5 10 25 20 15 
			In Order Traversal
			5 10 15 20 25 
		 */
		
	}

}
