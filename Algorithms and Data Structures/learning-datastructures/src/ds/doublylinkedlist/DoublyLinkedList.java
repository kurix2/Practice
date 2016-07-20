package ds.doublylinkedlist;

public class DoublyLinkedList {
	private Node first;
	private Node last;
	
	public DoublyLinkedList(){
		this.first = null;
		this.last = null;
	}
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	public void insertFirst(int data){
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()){
			last = newNode; // if empty, last will refer to the new Node being created
		}
		else{
			first.previous = newNode;
		}
		
		newNode.next = first; //new node's next field will point to the first
		this.first = newNode;
	}
	
	public void insertLast(int data){
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()){
			first = newNode;
		}else{
			last.next = newNode; // assigning old last to new node
			newNode.previous = last; // the old last will be the newnodes previous
		}
		
		last = newNode; // the linkedlist's last field should point to the new node
	}
	
	// assume non-empty list
	public Node deleteFirst(){
		Node temp = first;
		if(first.next == null){ // there is only one item in the list
			last = null;
		}else{
			first.next.previous = null; // the list's first node will point to null
		}
		
		// we are assigning the reference of the node following 
		//the old first node to the first field in the link list object
		first = first.next; 
		return temp; // return the deleted old first node
	}
	
	public Node deleteLast(){
		Node temp = last;
		if(first.next == null){ // we only have one item in the list
			first = null;
		}else{
			last.previous.next = null;
		}
	    last = last.previous;
		
		return temp;
	}
	
	// assume a non-empty list
	public boolean insertAfter(int key, int data){
		Node current = first; //start from the beginning of the list
		while(current.data != key){ // as long as we have not found the key in a particular node
			current = current.next;
			if (current == null){ // if we have reached the end of the list
				return false;
			}
		}
		
		Node newNode = new Node();
		newNode.data = data;
		
		if(current == last){
			current.next = null;
			last = newNode;
		}else{
			newNode.next = current.next; // new node's next field should point to the node ahead of the current one
			current.next.previous = newNode; // the node ahead of current, its previous field should point to the new node
		}
		
		newNode.previous = current;
		current.next = newNode;
		
		return true;
	}
	
	// assume non-empty list
	public Node deleteKey(int key){
		Node current = first;
		while(current.data != key){
			current = current.next;
			if(current == null){
				return null;
			}
		}
		
		if(current == first){
			first = current.next; // make first field point to the node following, bc current will be deleted	
		}else{
			current.previous.next = current.next;
		}
		
		if(current == last){
			last = current.previous;
		}else{
			current.next.previous = current.previous;
		}
		
		return current;
	}
	
	public void displayForward(){
		System.out.print("List (first-->last): ");
		Node current = first;
		while(current != null){
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
	
	public void displayBackwards(){
		System.out.print("List (last-->first): ");
		Node current = last;
		while(current != null){
			current.displayNode();
			current = current.previous;
		}
		System.out.println();
	}
	
}
