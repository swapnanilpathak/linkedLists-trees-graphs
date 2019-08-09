/*
 * Methods:-
 * insertAtBeginning(Object object)
 * insertAtEnd(Object object)
 * deleteAtBeginning()
 * deleteAtEnd()
 * display()
 */
package CircularLinkedList;

public class CircularLinkedList<T> {
	Node head=null;
	Node tail = null;
	int count=0;
	
	// to insertAtBeginning of the circular linked list
	public void insertAtBeginning(Object object) {
		Node newNode = new Node(object);
		if(this.head==null) {
			this.head= newNode;
			this.tail=this.head;
			this.head.next=newNode;
			this.count++;
		}else {
			Node previousHead = this.head;
			this.head=newNode;
			this.head.next=previousHead;
			this.tail.next=this.head;
			this.count++;
		}
	}
	// To insert at end of the circular linked list
	public void insertAtEnd(Object object) {
		Node newNode = new Node(object);
		if(this.head==null) {
			this.head= newNode;
			this.tail=this.head;
			this.head.next=newNode;
			this.count++;
			
		}else {
			Node previousTail = this.tail;
			this.tail=newNode;
			this.tail.next=previousTail.next;
			previousTail.next=this.tail;
			this.count++;
		}
		
	}
	// To delete at beginning of the circular linked list
	public void deleteAtBeginning() {
		if(this.head==null) {
			return;
		}else {
			if(this.head==this.tail) {
				this.head=null;
				this.tail=null;
			}else {
				this.head=this.head.next;
				this.tail.next =this.head;
			}
			
			this.count--;
		}
		
	}
	// To delete at end of the circular linked list
	public void deleteAtEnd() {
		if(this.head==null) {
			return;
		}else {
			if(this.head==this.tail) {
				this.head=null;
				this.tail=null;
			}else {
				Node currentNode = this.head;
				while(currentNode.next!=this.tail) {
					currentNode=currentNode.next;
				}
				currentNode.next=this.head;
				this.tail=currentNode;
			}
			this.count--;
		}
	}
	// To display the circular linked list
	public void display() {
		if(this.head==null) {
			return;
		}
		Node currentNode = this.head;
		while(currentNode.next!=this.head) {
			
			System.out.print(currentNode.data+"->");
			currentNode=currentNode.next;
		}
		System.out.print(currentNode.data+"->");
		
		// To display the linked list once again and conform the circular nature
		
//		currentNode = this.head;
//		while(currentNode.next!=this.head) {
//			
//			System.out.print(currentNode.data+"->");
//			currentNode=currentNode.next;
//		}
//		System.out.print(currentNode.data+"->");
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		CircularLinkedList<Integer> cll = new CircularLinkedList<Integer>();
		cll.insertAtBeginning(1);
		cll.insertAtBeginning(2);
		cll.insertAtBeginning(3);
		cll.display();
		cll.insertAtEnd(4);
		cll.display();
		cll.deleteAtEnd();
		cll.display();
		

	}

}
