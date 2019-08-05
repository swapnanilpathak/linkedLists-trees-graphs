/*
 * Contains The following functions to manipulate the LinkedList
 * 1. insertAtBeginning
 * 2. insertAtEnd
 * 3. deleteAtBeginning
 * 4. deleteAtEnd
 * 5. display
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
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
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
		
		/*
		 * **OUTPUT**
				*******************
				Beginnning2
				Beginnning1
				End1
				End2
				*******************
				Beginnning1
				End1
				*******************
		 */
	}

}
