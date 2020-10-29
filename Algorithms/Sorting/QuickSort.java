
public class QuickSort{

	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	public static void quickSort(int[] array, int left, int right) {

		if(left >= right)
			return;

		int pivot = array[ (left + right) /  2];
		int index = partition(array, left, right, pivot);
		quickSort(array, left, index-1);
		quickSort(array, index, right);
	}

	public static int partition(int[] array, int left,
	 int right, int pivot) {

		while(left <= right) {

			while(array[left] < pivot)
				left++;

			while(array[right] > pivot)
				right--;

			if(left <= right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}

		}

		return left;

	}

	public static void main(String[] args) {
		int[] input = {8,2,6,1,5};
		quickSort(input);
		System.out.print("Sorted Array : ");

		for(int n : input)
			System.out.print(n + " ");
	}
}

/*
Time Complexity : Best Case - O(nlogn)
		  Average Case - O(nlogn)
	          Worst Case - O(n^2)

Space Complexity : O(1)
*/
