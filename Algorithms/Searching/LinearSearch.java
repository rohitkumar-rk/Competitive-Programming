import java.util.Scanner;

public class LinearSearch{

	/*Linear Search Function */
	public static int linearSearch(int[] arr, int num){

		for(int index = 0; index < arr.length; index++){
			if(arr[index] == num)
				return index;
		}
		return -1;
	}

	/*Helper Function to take input and print result */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter no. of elements in array : ");

		int n = scanner.nextInt();
		int arr[] = new int[n];

		System.out.println("Enter Elements : ");
		for(int i = 0; i < n; i++)
			arr[i] = scanner.nextInt();

		System.out.println("Enter no. to be searched : ");
		int num = scanner.nextInt();
		int index = linearSearch(arr, num);
		
		if(index == -1)
			System.out.println(num + " not present in given array");

		else System.out.println("Index : " + index);

	}

}