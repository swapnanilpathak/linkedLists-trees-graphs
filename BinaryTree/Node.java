package BinaryTree;

public class Node {
	Object object;
	Node left;
	Node right;
	
	Node(Object object){
		this.object=object;
		this.left=null;
		this.right=null;
	}
	
	void addChildren(Node left,Node right) {
		this.left=left;
		this.right=right;
	}
}
