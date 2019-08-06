/*
 * Contains The following functions to manipulate the LinkedList
 * 1. insertAtBeginning(Object data)
 * 2. insertAtEnd(Object data)
 * 3. deleteAtBeginning()
 * 4. deleteAtEnd()
 * 5. insertAtPosition(Object data,int position)
 * 6. deleteFromPosition(int position)
 * 5. display()
 *
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
		Node currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.data+" ");
			currentNode = currentNode.next;
		}
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
	// If you want to use 0 based indexing then add +1 to your index
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
	
	
	public static void main(String[] args) {
		System.out.println("*******************");
		LinkedList<String> ll = new LinkedList<String>();
		ll.insertAtBeginning("Beginnning1");
		ll.insertAtBeginning("Beginnning2");
		ll.insertAtEnd("End1");
		ll.insertAtEnd("End2");
		ll.display();
		System.out.println("*******************");
		ll.deleteAtBeginning();
		ll.deleteAtEnd();
		ll.display();
		System.out.println("*******************");
		ll.insertAtPosition("InsertedAt1stposition", 1);
		ll.insertAtPosition("InsertedAt4thPosition", 4);
		ll.display();
		System.out.println("*******************");
		ll.deleteFromPosition(2);
		ll.deleteFromPosition(3);
		ll.display();
		System.out.println("*******************");
		
		/*
		 * **OUTPUT**
			*******************
			Beginnning2 Beginnning1 End1 End2 
			*******************
			Beginnning1 End1 
			*******************
			InsertedAt1stposition Beginnning1 End1 InsertedAt4thPosition 
			*******************
			InsertedAt1stposition End1 
			*******************
		 */
	}

}
