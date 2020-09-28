
public class MergeSort {

	public static void mergeSort(int[] arr) {
		
		int len = arr.length;

		if(len < 2)
			return;

		int mid = len/2;
		int[] left = new int[mid];
		int[] right = new int[len-mid];

		for(int i = 0; i < mid; i++)
			left[i] = arr[i];

		for(int i = mid; i < len; i++)
			right[i-mid] = arr[i];

		mergeSort(left);
		mergeSort(right);
		merge(left, right, arr);

	}

	public static void merge(int[] left, int[] right, int[] arr){

		int leftLength = left.length, rightLength = right.length;
		int leftIndex = 0, rightIndex = 0, arrIndex = 0;

		while(leftIndex < leftLength && rightIndex < rightLength){

			if(left[leftIndex] <= right[rightIndex]) {
				arr[arrIndex++] = left[leftIndex++];
			}

			else {
				arr[arrIndex++] = right[rightIndex++];
			}

		}


		while(leftIndex < leftLength)
			arr[arrIndex++] = left[leftIndex++];

		while(rightIndex < rightLength)
			arr[arrIndex++] = right[rightIndex++];

	}

	public static void main(String[] args) {
		int[] array = {22,19,6,45,0,8,4,6,9,8,2,5};
		mergeSort(array);
		System.out.print("Sorted Array : ");

		for(int n : array)
			System.out.print(n + " ");
	}

}

/*
Time Complexity : Best Case - O(nlog(n))
		  Average Case - O(nlog(n))
	          Worst Case - O(nlog(n))

Space Complexity : O(n)
*/
