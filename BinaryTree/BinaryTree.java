package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <T>{
	Node root;
	BinaryTree(){
		this.root=null;
	}

	public void preOrderTraversal(Node node) {
		if(node!=null) {
			System.out.println( node.object);

			if(node.left!=null) {
				preOrderTraversal(node.left);
			}

			if(node.right!=null) {
				preOrderTraversal(node.right);
			}
		}
	}
	public void preOrderTraversal(Node node, int levelNo) {
		if(node!=null) {
			for(int i=0;i<levelNo;i++) {
				System.out.print("*");
			}
			System.out.println( node.object);

			if(node.left!=null) {
				preOrderTraversal(node.left,levelNo+1);
			}

			if(node.right!=null) {
				preOrderTraversal(node.right,levelNo+1);
			}
		}
	}
	
	public void postOrderTraversal(Node node, int levelNo) {
		if(node!=null) {

			if(node.left!=null) {
				postOrderTraversal(node.left,levelNo+1);
			}

			if(node.right!=null) {
				postOrderTraversal(node.right,levelNo+1);
			}
			
			for(int i=0;i<levelNo;i++) {
				System.out.print("*");
			}
			System.out.println( node.object);
		}
	}
	
	public void inOrderTraversal(Node node, int levelNo) {
		if(node!=null) {

			if(node.left!=null) {
				inOrderTraversal(node.left,levelNo+1);
			}
			
			for(int i=0;i<levelNo;i++) {
				System.out.print("*");
			}
			System.out.println( node.object);
			
			if(node.right!=null) {
				inOrderTraversal(node.right,levelNo+1);
			}
			
			
		}
	}
	
	
	public void levelOrderTraversal(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		if(node!=null) {
		q.add(node);
		while(!q.isEmpty()) {
			Node currentNode = q.remove();
			System.out.print(currentNode.object+" ");
			
			if(currentNode.left!=null) {
				q.add(currentNode.left);
			}
			
			if(currentNode.right!=null) {
				q.add(currentNode.right);
			}
		}
		}
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();	// Tree is
		tree.root = new Node(0);								 			
		Node rootChild1 = new Node(1);
		Node rootChild2 =  new Node(2);
		tree.root.addChildren(rootChild1,rootChild2);			//			0
		rootChild1.addChildren(new Node(3), new Node(4));		//		1		2
		rootChild2.addChildren(new Node(5), new Node(6));		//	3	   4 5		6
		System.out.println("PreOrder Traversal");
		tree.preOrderTraversal(tree.root,0);
		System.out.println("PostOrder Traversal");
		tree.postOrderTraversal(tree.root,0);
		System.out.println("InOrder Traversal");
		tree.inOrderTraversal(tree.root,0);
		System.out.println("levelOrder Traversal");
		tree.levelOrderTraversal(tree.root);
		
		/*
		 * OUTPUT
			PreOrder Traversal
			0
			*1
			**3
			**4
			*2
			**5
			**6
			PostOrder Traversal
			**3
			**4
			*1
			**5
			**6
			*2
			0
			InOrder Traversal
			**3
			*1
			**4
			0
			**5
			*2
			**6
			levelOrder Traversal
			0 1 2 3 4 5 6
		 */
	}

}
