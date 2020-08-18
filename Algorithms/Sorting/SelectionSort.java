/**
*Approach : Approach for Selection Sort is 
*Find minimum value from array and place it at 0th pos,
*and then again find min and place it at 1st pos from rest of array.
*Continue it (n-1) times.

*For placing element, we swap min with ith index.
*/

public class SelectionSort{

	public static void selectionSort(int[] input) {

		for(int i = 0; i < input.length - 1; i++){ // 0 to length-2

			int min = input[i];
			int minIndex = i;

			//Find min value and minIndex
			for(int j = i+1; j < input.length; j++){
				if(input[j] < min){
					min = input[j];
					minIndex = j;
				}
			}

			//If input[i] isn't minimum, then swap
			if(minIndex != i){
				input[minIndex] = input[i];
				input[i] = min;
			}
			
		}

	}

	public static void main(String[] args) {
		int[] input = {8,2,6,1,5};
		selectionSort(input);
		System.out.print("Sorted Array : ");

		for(int n : input)
			System.out.print(n + " ");
	}
}

/*
Time Complexity : Best Case - O(n^2)
		  Average Case - O(n^2)
	          Worst Case - O(n^2)

Space Complexity : O(1)
*/
