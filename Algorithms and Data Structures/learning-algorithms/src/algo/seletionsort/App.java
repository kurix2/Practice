package algo.seletionsort;

public class App {

	public static void main(String[] args) {
		int[] myArray = selectionSort(new int[] {19,42,62,33,732,2,55});
		for(int i = 0; i < myArray.length;++i){
			System.out.println(myArray[i]);
		}
	}
	
	public static int [] selectionSort(int a[]){
		for(int i = 0; i < a.length; i++){
			int minimum = i;
			for(int j = i+1; j < a.length; j++ ){
				if(a[j] < a[minimum]){ // if we find a smaller value
					minimum = j;
				}
			}
			int temp = a[i];
			a[i] = a[minimum];
			a[minimum] = temp;
		}
		return a;
	}

}

/*
 Inputs: 
 	A: an array to be sorted
 Output:
 	A, sorted in ascending order
 
 1. for i = 0 to A.length - 1:
 		A. Set minimum to i
 		B. for j = i + 1 to A.length
 			a. if A[j] < A[minimum]
 				i. then set minimum to j
 		C. Swap A[i] with A[minimum] 
*/
 