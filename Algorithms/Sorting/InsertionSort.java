
public class InsertionSort {

	public static void insertionSort(int[] input){

		for(int i = 1; i < input.length; i++){

			int value = input[i];
			int hole = i;

			while(hole > 0 && input[hole-1] > value){
				input[hole] = input[hole-1];
				hole--;
			}

			input[hole] = value;
		}

	}

	public static void main(String[] args) {
		int[] input = {8,2,6,1,5};
		insertionSort(input);
		System.out.print("Sorted Array : ");

		for(int n : input)
			System.out.print(n + " ");
	}
}

/*
Time Complexity : Best Case - 	Ω(n)		
		  Average Case - θ(n^2)
		  Worst Case - O(n^2)

Space Complexity : O(1)
*/

/**
*Approach : This algorithm is similar to sorting cards.
*Consider array as a deck of card.
*Array is considered of two parts : Sorted Part and Unsorted Part
*Initially First element is in Sorted Part and all other in unsorted
*And we take each element from unsorted and
* place it at its correct position
*/
