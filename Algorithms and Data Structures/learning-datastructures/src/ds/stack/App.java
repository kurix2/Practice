package ds.stack;

// Stack is First in Last Out (FILO)

public class App {
	
	public static void main(String[] args) {
//		theStack.push(20); // Add numbers to the stack
//		theStack.push(40);
//		theStack.push(60);
//		theStack.push(80);
//		theStack.push(100);
		
//		while(!theStack.isEmpty()){
//			long value = theStack.pop(); // pop the last number pushed to the stack
//			System.out.println(value);
//		}
		
		System.out.println(reverseString("WhatsUp!"));
	}
	
	public static String reverseString(String str){
		
		int stackSize = str.length(); // get max stack size
		Stack theStack = new Stack(stackSize); // make the stack
		
		for(int j = 0; j < str.length(); j++){
			char ch = str.charAt(j); // get a char from the index position of the inputed string
			theStack.push(ch);
		}
		
		String result = "";
		while(!theStack.isEmpty()){
			char ch = theStack.pop();
			result = result + ch; // appending the output
		}
		
		
		return result;
	}

}
