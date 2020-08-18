public class LinearSearch{

	/*Linear Search Function */
	public static int linearSearch(int[] arr, int key){

		for(int index = 0; index < arr.length; index++){
			if(arr[index] == key)
				return index;
		}
		return -1;
	}
 
	public static void main(String[] args) {
		
		int[] arr ={2,7,8,9,1,5,3,4};
        int key=8;
        int index = linearSearch(arr, key);

        if(index == -1)
        	System.out.print(key + " Not found");

        else System.out.print("Index : " + index);
	}

}