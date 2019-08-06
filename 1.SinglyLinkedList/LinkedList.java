/*
 * Contains The following functions to manipulate the LinkedList
 * 1. insertAtBeginning(Object data)
 * 2. insertAtEnd(Object data)
 * 3. deleteAtBeginning()
 * 4. deleteAtEnd()
 * 5. insertAtPosition(Object data,int position)
 * 6. deleteFromPosition(int position)
 * 5. display()
 * 7. searchNode(Object data)
 * 8. size()
 * 9. isEmpty()
 */


public class LinkedList<T> {
	Node head = null;
	int count =0;
	
	public void insertAtBeginning(Object data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
		}else {
			Node TempNode = head;
			head = newNode;
			head.next = TempNode;
		}
		this.count++;
	}
	public void insertAtEnd(Object dataitem) {
		Node newNode = new Node(dataitem);
		if(head == null) {
			
			head = newNode;
		}else {
			Node currentNode = head;
			while(currentNode.next!=null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}
		this.count++;
	}
	
	public void display () {
		System.out.print("LinkedList is ");
		Node currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.data+"->");
			currentNode = currentNode.next;
		}
		System.out.print("null");
		System.out.println();
	}
	public void deleteAtBeginning() {
		if (head == null) {
			return;
		}else {
			head = head.next;
			this.count--;
		}
	}
	
	public void deleteAtEnd() {
		Node currentNode = head;
		Node prevNode = head;
		while(currentNode.next!=null) {
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		prevNode.next = null;
		this.count--;
	}
	// This method uses 1 based indexing for inserting elements
	// If you want to use 0 based indexing then add +1 to your position
	public void insertAtPosition(Object data, int position) {
		Node newNode = new Node(data);
		if(head == null) {
			this.head = newNode;
			this.count++;
		}
		
		else {
			if(position<1||position>count+1) {
				System.out.println("Invalid Position: Position "+position);
			}else if (position ==1){
				newNode.next=this.head;
				this.head = newNode;
				this.count++;
			}else {
				Node currentNode = this.head;
				for(int i=1;i<position-1&&currentNode.next!=null;i++) {
					currentNode = currentNode.next;
				}
				newNode.next = currentNode.next;
				currentNode.next=newNode;
				this.count++;
			}
			
			
		}
	}
	// This method uses 1 based indexing to remove elements
	public void deleteFromPosition(int position) {
		if(head == null) {
			return;
		}else {
			if(position<1&&position>count) {
				System.out.println("Invalid Position: Position "+position);
			}else if(position ==1) {
				this.head = this.head.next;
				this.count--;
			}else {
				Node currentNode = this.head;
				for(int i=1;i<position-1&&currentNode.next!=null;i++) {
					currentNode = currentNode.next;
				}
				currentNode.next = currentNode.next.next;
				this.count--;
			}
			
		}
		
	}
	
	public Node searchNode(Object data) {
		Node currentNode = this.head;
		while(currentNode != null) {
			if(currentNode.data==data)
				break;
			currentNode = currentNode.next;
			
		}
		if(currentNode!=null) {
			return currentNode;
		}else {
			return null;
		}
	}
	
	public int size() {
		return this.count;
	}
	
	public boolean isEmpty() {
		return this.head==null;
	}
	
	
	public static void main(String[] args) {
		System.out.println("**********Inserting a at beginning, b at beginning, c at end, d at end*********");
		LinkedList<String> ll = new LinkedList<String>();
		ll.insertAtBeginning("a");
		ll.insertAtBeginning("b");
		ll.insertAtEnd("c");
		ll.insertAtEnd("d");
		ll.display();
		System.out.println("**********deleting b from beginning, d from end*********");
		ll.deleteAtBeginning();
		ll.deleteAtEnd();
		ll.display();
		System.out.println("**********Inserting s at 1st position, p at 4th position*********");
		ll.insertAtPosition("s", 1);
		ll.insertAtPosition("p", 4);
		ll.display();
		System.out.println("**********Deleting 2nd and then 3rd position elements*********");
		ll.deleteFromPosition(2);
		ll.deleteFromPosition(3);
		ll.display();
		System.out.println("**********Searching for element s*********");
		Node search = ll.searchNode("s");
		if(search!=null)System.out.println(search.data);
		System.out.println("**********Getting size of linkedlist*********");
		System.out.println(ll.size());
		System.out.println("**********check if linkedlist is empty*********");
		System.out.println(ll.isEmpty());
		
		/*
		 * **OUTPUT**
			**********Inserting a at beginning, b at beginning, c at end, d at end*********
			LinkedList is b->a->c->d->null
			**********deleting b from beginning, d from end*********
			LinkedList is a->c->null
			**********Inserting s at 1st position, p at 4th position*********
			LinkedList is s->a->c->p->null
			**********Deleting 2nd and then 3rd position elements*********
			LinkedList is s->c->null
			**********Searching for element s*********
			s
			**********Getting size of linkedlist*********
			2
			**********check if linkedlist is empty*********
			false
		 */
	}

}
