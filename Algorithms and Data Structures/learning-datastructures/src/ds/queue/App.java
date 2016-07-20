package ds.queue;

public class App {

	public static void main(String[] args) {
		Queue myQueue = new Queue(5);

		myQueue.insert(5);
		myQueue.insert(4);
		myQueue.insert(3);
		myQueue.insert(2);
		myQueue.insert(1);


		myQueue.view();

	}

}
