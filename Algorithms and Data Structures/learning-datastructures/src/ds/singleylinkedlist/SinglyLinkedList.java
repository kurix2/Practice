package ds.singleylinkedlist;

public class SinglyLinkedList {
	private Node first; // references first node in the linked list
	
	public SinglyLinkedList(){
		
	}
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	// used to insert at the beginning of a list
	public void insertFirst(int data){
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = first;
		first = newNode;
	}
	
	public Node deleteFirst(){
		Node temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList(){
		System.out.println("List (first --> last)");
		Node current = first;
		while(current != null){
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
	
	// This is not efficient because we have to traverse the entire list
	// to get to the end
	public void insertLast(int data){
		Node current = first;
		while(current.next != null){
			current = current.next; // loop until current.next is null to get to the last node
		}
		
		Node newNode = new Node();
		newNode.data = data;
		current.next = newNode;
	}
	
}
