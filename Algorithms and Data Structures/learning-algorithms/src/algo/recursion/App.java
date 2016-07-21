package algo.recursion;

public class App {

	public static void main(String[] args) {
		//reduceByOne(10);
		System.out.println(recursiveLinearSearch(new int[] {4,48,4,28,34,76,9,3},0,100));
	}
	
	public static void reduceByOne(int n){
		if(n >= 0){ // Base case
			reduceByOne(n-1);
		}
		
		System.out.println("Complete Call: " + n);
	}
	
	public static int recursiveLinearSearch(int [] a, int i, int x){
		if (i > a.length){
			return -1;
		} // if evaluates to true, then x was no found in array
		else if(a[i] == x){
			return i;
		}
		else {
			System.out.println("index at: " + i);
			return recursiveLinearSearch(a, i+1, x);
		}
	}

}
