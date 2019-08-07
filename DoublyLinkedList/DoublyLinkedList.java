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
 * 12. getNode(int position)
 */
package DoublyLinkedList;



public class DoublyLinkedList<T> {
	
	int count =0;
	Node head = null;
	Node tail = null;
	
	// Method inserts a node at the beginning of doublylinkedlist
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
	// Method deletes the first node of doublylinkedlist
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
	
	// Method inserts a node at the end of doublylinkedlist
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
	
	// Method deletes the last node of doublylinkedlist
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
	
	//prints the doublylinkedlist in forward order
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
	// prints the doublylinkedlist in reversed order
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
	
	// This method uses 1 based indexing for inserting nodes
	// For example insertAtPosition('a',1) will insert 'a' in the first position or head of linked list
	// If you want to use 0 based indexing then add +1 to your position
	
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
	
	// This method uses 1 based indexing to remove nodes
	// For example deleteFromPositionAt(1) will delete the first position or head of linked list
	// If you want to use 0 based indexing then add +1 to your position
	
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
	// Returns the size of the doublylinkedlist or total number of nodes in doublylinkedlist
	public int size() {
		return this.count;
	}
	
	// Checks whether the doublylinkedlist is empty or not
	public boolean isEmpty() {
		return this.head==null;
	}
	// Returns the node which contains the value given in argument of this method
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
	
	// Returns the nth node of the doublylinkedlist where n is specified in the argument of the method
	// This method uses 0 based indexing
	// For example getNode(0) returns the first node or head node
		public Node getNode(int position) {
			Node returnNode=null;
			if(this.head==null) {
				return null;
			}else {
				
				if(position<0||position>=this.count) {
					System.out.println("Invalid Position: "+position);
					
				}else {
					if(position == 0) {
						returnNode = this.head;
					}else {
						Node currentNode = this.head.next;
						for(int i=0;i<position-1&&currentNode.next!=null;i++) {
							currentNode = currentNode.next;
						}
						returnNode = currentNode;
					}
					
				}
				return returnNode;
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
		System.out.println("**********check if getNode(int position) gave correct values*********");
		for(int i=0;i<dll.size();i++) {
			System.out.println(dll.getNode(i).data);
		}
		
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
		**********check if getNode(int position) gave correct values*********
		s
		c
		 */
		
	}

}
