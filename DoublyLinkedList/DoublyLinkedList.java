/*
 * Methods:-
 * 1. insertAtBeginning(Object data)
 * 2. deleteAtBeginning()
 * 3. insertAtEnd(Object data)
 * 4. deleteAtEnd()
 * 5. displayForward()
 * 6. displayReverse()
 * 7. insertAtPosition(Object data,int position)
 * 8. deleteAtPosition(int position)
 * 9. size()
 * 10. isEmpty()
 * 11. searchNode(Object data)
 */
package DoublyLinkedList;

public class DoublyLinkedList<T> {
	
	int count =0;
	Node head = null;
	Node tail = null;
	
	public void insertAtBeginning(Object data) {
		Node newNode = new Node(data);
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		}else {
			Node tempNode = this.head;
			this.head = newNode;
			newNode.next=tempNode;
			tempNode.previous = newNode;
		}
		this.count++;
	}
	
	public void deleteAtBeginning() {
		if(head==null) {
			return;
		}else {
			if(this.head.next!=null) {
				this.head = this.head.next;
				this.head.previous=null;
			}else {
				this.head=null;
			}
			this.count--;
			
		}
	}
	public void insertAtEnd(Object data) {
		Node newNode = new Node(data);
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		}else {
			Node tempNode = this.tail;
			tempNode.next= newNode;
			newNode.previous=tempNode;
			this.tail=newNode;
		}
		this.count++;
	}
	public void deleteAtEnd() {
		if(this.head==null) {
			return;
		}else {
			
			if(this.tail.previous == null) {
				this.head=null;
				this.tail=null;
				this.count--;
			}else {
				Node tempNode = this.tail;
				Node previousNode = tempNode.previous;
				this.tail = previousNode;
				this.tail.next=null;
				this.count--;
			}
		}
	}
	public void displayForward() {
		if(head==null) {
			return;
		}else {
			Node currentNode = this.head;
			while(currentNode!=null) {
				System.out.print(currentNode.data+"->");
				currentNode = currentNode.next;
			}
			System.out.print("null");
			System.out.println();
		}
	}
	
	public void displayReverse() {
		if(head==null) {
			return;
		}else {
			Node currentNode = this.tail;
			while(currentNode!=null) {
				System.out.print(currentNode.data+"->");
				currentNode = currentNode.previous;
			}
			System.out.print("null");
			System.out.println();
		}
	}
	
	public void insertAtPosition(Object data,int position) {
		Node newNode = new Node(data);
		if(this.head==null) {
			this.head = newNode;
			this.tail = newNode;
			this.count++;
		}else {
			if(position<0||position>count+1) {
				System.out.println("Invalid position position"+position);
			}else if(position==1) {
				Node tempNode=this.head;
				newNode.next=tempNode;
				this.head=newNode;
				tempNode.previous=this.head;
				this.count++;
			}else if(position==count+1) {
				Node tempNode = this.tail;
				tempNode.next= newNode;
				newNode.previous=tempNode;
				this.tail=newNode;
				this.count++;
			}
			else {
				Node currentNode = this.head;
				
				for(int i=1;i<position-1&&currentNode.next!=null;i++) {
					
					currentNode = currentNode.next;
				}
				Node previousNode = currentNode;
				Node nextNode = currentNode.next;
				previousNode.next=newNode;
				newNode.next=nextNode;
				nextNode.previous=newNode;
				newNode.previous=previousNode;
				this.count++;
			}
		}
	}
	
	public void deleteAtPosition(int position) {
		if(this.head==null) {
			return;
		}else {
			if(position<0||position>count) {
				System.out.println("Invalid position position"+position);
			}else if(position==1) {
				if(this.head.next!=null) {
					this.head = this.head.next;
					this.head.previous=null;
				}else {
					this.head=null;
				}
				this.count--;
			}else if(position==count) {
				if(this.tail.previous == null) {
					this.head=null;
					this.tail=null;
					this.count--;
				}else {
					Node tempNode = this.tail;
					Node previousNode = tempNode.previous;
					this.tail = previousNode;
					this.tail.next=null;
					this.count--;
				}
			}else {
				Node currentNode = this.head;
				
				for(int i=1;i<position-1&&currentNode.next!=null;i++) {
					currentNode = currentNode.next;
				}
				Node nextNode = currentNode.next.next;
				Node previousNode = currentNode;
				previousNode.next=nextNode;
				nextNode.previous=previousNode;
				this.count--;
			}
		}
	}
	
	public int size() {
		return this.count;
	}
	public boolean isEmpty() {
		return this.head==null;
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
	
	public static void main(String[] args) {
		DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
		System.out.println("**********Inserting a at beginning, b at beginning, c at end, d at end*********");
		dll.insertAtBeginning("a");
		dll.insertAtBeginning("b");
		dll.insertAtEnd("c");
		dll.insertAtEnd("d");
		dll.displayForward();
		dll.displayReverse();
		System.out.println("**********deleting b from beginning, d from end*********");
		dll.deleteAtBeginning();
		dll.deleteAtEnd();
		dll.displayForward();
		dll.displayReverse();
		System.out.println("**********Inserting s at 1st position, p at 4th position*********");
		dll.insertAtPosition("s", 1);
		dll.insertAtPosition("p", 4);
		dll.displayForward();
		dll.displayReverse();
		System.out.println("**********Deleting 2nd and then 3rd position elements*********");
		dll.deleteAtPosition(2);
		dll.deleteAtPosition(3);
		dll.displayForward();
		dll.displayReverse();
		System.out.println("**********Searching for element s*********");
		Node search = dll.searchNode("s");
		if(search!=null)System.out.println(search.data);
		System.out.println("**********Getting size of doublylinkedlist*********");
		System.out.println(dll.size());
		System.out.println("**********check if doublylinkedlist is empty*********");
		System.out.println(dll.isEmpty());
		
		/*
		 * OUTPUT
		**********Inserting a at beginning, b at beginning, c at end, d at end*********
		b->a->c->d->null
		d->c->a->b->null
		**********deleting b from beginning, d from end*********
		a->c->null
		c->a->null
		**********Inserting s at 1st position, p at 4th position*********
		s->a->c->p->null
		p->c->a->s->null
		**********Deleting 2nd and then 3rd position elements*********
		s->c->null
		c->s->null
		**********Searching for element s*********
		s
		**********Getting size of doublylinkedlist*********
		2
		**********check if doublylinkedlist is empty*********
		false
		 */
		
	}

}
