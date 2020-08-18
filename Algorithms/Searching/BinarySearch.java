public class BinarySearch{

	/*Binary Search Function */
	public static int binarySearch(int[] arr, int key,
		int low, int high){

		if(low > high)
			return -1;

		int mid = low +  ((high - low) / 2);

		//If key is present at mid
		if(arr[mid] == key)
			return mid;

		//If key is smaller than mid, than it must be
		//present in left subarray
		else if(key < arr[mid])
			high = mid - 1;
		
		//If key is larger than mid,
		//it must be present in right subarray
		else low = mid + 1;

		return binarySearch(arr, key, low, high);
	}

	public static void main(String[] args) {
		//Array needs to be sorted for binary search
		int[] arr ={1,2,3,4,5,6,7,8,9,10};
        int key=8;
        int index = binarySearch(arr, key, 0, arr.length - 1);

        if(index == -1)
        	System.out.print(key + " Not found");

        else System.out.print("Index : " + index);

	}

}