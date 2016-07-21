package algo.binarysearch;

public class App {

	public static void main(String[] args) {
		System.out.println(recursiveBinarySerach(new int[] {1,2,3,4,5,6,7,8,9},0,8,6));
	}
	
	/* 
	 [p][][][][q][][][][][r] 
	 p is the beginning of the range
	 r is the end, q is the middle
	 Binary search only works on a sorted array 
	*/
	
	public static int binarySearch(int [] a, int x){
		int p = 0;
		int r = a.length-1;
		
		while(p <= r){
			int q = (p+r)/2;
			if(x < a[q]){ r = q-1;}
			else if(x > a[q]){p = q+1;}
			else return q;
		}	
		return -1;
	}
	

	public static int recursiveBinarySerach(int [] a, int p, int r, int x){
		System.out.println("[" + p + "..." + r + " ]");
		if (p > r){ return -1; // check if the lower range is not greater than the higher range
		}
		else{
			int q = (p+r)/2; 
			if (a[q] == x){ // if the mid-point matches the number we are searching, then return q
				return q;
			} else if(a[q] > x){ // if the number we are searching for is more than the mid point
				return recursiveBinarySerach(a, p, q-1, x); // mid point minus 1 becomes the new end
			} else{ // if the number we are searching for is less than the mid-point
				return recursiveBinarySerach(a, p + 1, r, x); // mid point plus 1 becomes the new beginning
			}
		}
	}

}
