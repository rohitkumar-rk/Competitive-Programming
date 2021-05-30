
public class BubbleSort {

	public static int[] bubbleSort(int[] input){

		boolean swapped;
		for(int i = 0; i < input.length - 1; i++){
			swapped = false;
			/*We don't need to go to end of array on each traversal
			*because on each travelsal, one element is placed at its
			*correct position towards end of array
			So we go till length - i -1 */

			for(int j = 0; j < input.length - i - 1; j++){
				//If jth element is greater than (j+1)th
				//Swap these
				if(input[j] > input[j+1]){
					int temp = input[j];
					input[j] = input[j+1];
					input[j+1] = temp;
					swapped = true;
				}
			}

			/*If no two elements were swapped by inner loop,
			the array is in sorted order, so break */
			if(swapped == false)
				break;
		}

		return input;

	}

	public static void main(String[] args) {
		
		int[] input = {8,2,6,1,5};
		bubbleSort(input);
		System.out.print("Sorted Array : ");

		for(int n : input)
			System.out.print(n + " ");
	}

}

/*
Time Complexity : Best Case - O(n)
		  Average Case - O(n^2)
	          Worst Case - O(n^2)

Space Complexity : O(1)

Note : boolean swapped is added to it to optimize it
to break when the array is in sorted order
*/
