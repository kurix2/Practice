package ds.doublylinkedlist;

public class App {

	public static void main(String[] args) {
		DoublyLinkedList theList = new DoublyLinkedList();
		
		theList.insertFirst(22);
		theList.insertFirst(44);
		theList.insertFirst(66);
		theList.insertFirst(11);
		
		theList.insertLast(33);
		theList.insertLast(55);
		
		theList.displayForward();
		theList.displayBackwards();
		
		theList.deleteFirst();
		theList.deleteLast();
		theList.deleteKey(3);
		
		theList.displayForward();
		
		theList.insertAfter(203,20 );
		theList.insertAfter(4, 694);
		theList.displayForward();
	}

}
