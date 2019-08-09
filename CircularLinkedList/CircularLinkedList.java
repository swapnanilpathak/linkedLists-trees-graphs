/*
 * Methods:-
 * insertAtBeginning(Object object)
 * insertAtEnd(Object object)
 * deleteAtBeginning()
 * deleteAtEnd()
 * display()
 * size()
 * isEmpty()
 * searchNode(Object object)
 * getNode(int position)
 * insertAtPosition(Object object,int position)
 * deleteAtPosition(int position)
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
		System.out.print("CircularlinkedList: ");
		Node currentNode = this.head;
		while(currentNode.next!=this.head) {
			
			System.out.print(currentNode.data+"->");
			currentNode=currentNode.next;
		}
		System.out.print(currentNode.data+"->");
		
		// To display the linked list once again and conform the circular nature
//		System.out.print("||");
//		currentNode = this.head;
//		while(currentNode.next!=this.head) {
//			
//			System.out.print(currentNode.data+"->");
//			currentNode=currentNode.next;
//		}
//		System.out.print(currentNode.data+"->");
		
		System.out.println();
	}
	
		// Returns the size of the circular linked list or total number of nodes in circular linked list
		public int size() {
			return this.count;
		}
		// Checks whether the circular linked list is empty or not
		public boolean isEmpty() {
			return this.head==null;
		}
		
		// Returns the node which contains the value given in argument of this method
		public Node searchNode(Object data) {
			int flag=0;
			Node returnNode = null;
			if(this.head.data==data) {
				flag=1;
				returnNode = this.head;
			}else {
				Node currentNode = this.head.next;
				while(currentNode != this.head) {
					if(currentNode.data==data) {
						flag=1;
						break;
						
					}
						
					currentNode = currentNode.next;
					
				}
				returnNode=currentNode;
			}
			
			if(flag==1) {
				return returnNode;
			}else {
				return null;
			}
		}
		
		// Returns the nth node of the linkedlist where n is specified in the argument of the method
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
						for(int i=0;i<position-1&&currentNode.next!=this.head;i++) {
							currentNode = currentNode.next;
						}
						returnNode = currentNode;
					}
					
				}
				return returnNode;
			}
		}
		
		// adds node at the specified position
		// uses 1 based indexing
		// for example addAtPosition('a',1) adds 'a' to the beginning of circular linked list
		
		 public void insertAtPosition(Object object,int position) {
			 Node newNode = new Node(object);
			 if(this.head==null && position==1) {
				 this.head= newNode;
					this.tail=this.head;
					this.head.next=newNode;
					this.count++;
			 }else if(this.head==null&&(position!=1)) {
				 System.out.println("Invalid position because list is empty please give position 1");
			 }else {
				 if(position<1||position>count+1) {
						System.out.println("Invalid Position: Position "+position);
					}else if (position==1){
						Node previousHead = this.head;
						this.head=newNode;
						this.head.next=previousHead;
						this.tail.next=this.head;
						this.count++;
					}else if(position ==this.count+1) {
						Node previousTail = this.tail;
						this.tail=newNode;
						this.tail.next=previousTail.next;
						previousTail.next=this.tail;
						this.count++;
					}else {
						Node currentNode=this.head;
						for(int i=1;i<position-1;i++) {
							currentNode = currentNode.next;
						}
						newNode.next=currentNode.next;
						currentNode.next=newNode;
						this.count++;
					}
			 }
			 
		 }
		 // deletes node at the specified position
		 // uses 1 based indexing
		 // for example deleteAtPosition(1) deletes the first element of circular linked list
		 public void deleteAtPosition(int position) {
			 if(this.head==null) {
				 return;
			 }else {
				 if(position<1||position>count) {
						System.out.println("Invalid Position: Position "+position);
					}else if(position==1) {
						if(this.head==this.tail) {
							this.head=null;
							this.tail=null;
						}else {
							this.head=this.head.next;
							this.tail.next =this.head;
						}
						
						this.count--;
					}else if(position==this.count) {
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
					}else {
						Node currentNode = this.head;
						for(int i=1;i<position-1;i++) {
							currentNode= currentNode.next;
						}
						currentNode.next=currentNode.next.next;
						this.count--;
					}
			 }
			 
		 }
	
	public static void main(String[] args) {
		CircularLinkedList<String> cll = new CircularLinkedList<String>();
		System.out.println("**********Inserting a at beginning, b at beginning, c at end, d at end*********");
		cll.insertAtBeginning("a");
		cll.insertAtBeginning("b");
		cll.insertAtEnd("c");
		cll.insertAtEnd("d");
		cll.display();
		System.out.println("**********deleting b from beginning, d from end*********");
		cll.deleteAtBeginning();
		cll.deleteAtEnd();
		cll.display();
		System.out.println("**********Inserting s at 1st position, p at 4th position*********");
		cll.insertAtPosition("s", 1);
		cll.insertAtPosition("p", 4);
		cll.display();
		System.out.println("**********Deleting 2nd and then 3rd position elements*********");
		cll.deleteAtPosition(2);
		cll.deleteAtPosition(3);
		cll.display();
		System.out.println("**********Searching for element s*********");
		Node search = cll.searchNode("s");
		if(search!=null)System.out.println(search.data);
		System.out.println("**********Getting size of linkedlist*********");
		System.out.println(cll.size());
		System.out.println("**********check if linkedlist is empty*********");
		System.out.println(cll.isEmpty());
		System.out.println("**********check if getNode(int position) gave correct values*********");
		for(int i=0;i<cll.size();i++) {
			System.out.println(cll.getNode(i).data);
		}
		
		
		/*
		 * **OUTPUT**
		**********Inserting a at beginning, b at beginning, c at end, d at end*********
		CircularlinkedList: b->a->c->d->
		**********deleting b from beginning, d from end*********
		CircularlinkedList: a->c->
		**********Inserting s at 1st position, p at 4th position*********
		CircularlinkedList: s->a->c->p->
		**********Deleting 2nd and then 3rd position elements*********
		CircularlinkedList: s->c->
		**********Searching for element s*********
		s
		**********Getting size of linkedlist*********
		2
		**********check if linkedlist is empty*********
		false
		**********check if getNode(int position) gave correct values*********
		s
		c
		 */
		
		

	}

}
