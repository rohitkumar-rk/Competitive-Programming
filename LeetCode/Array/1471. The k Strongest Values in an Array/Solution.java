/**

@lc id : 1471
@problem :  The k Strongest Values in an Array
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/the-k-strongest-values-in-an-array/
@difficulty : medium 
*/

class Solution {
    
    public int[] getStrongest(int[] arr, int k) {
        int[] temp = arr;
        Arrays.sort(temp);
        int n = arr.length;
        int m = temp[(n-1)/2];
        
        Integer[] boxed = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++)
            boxed[i] = arr[i];
            
        Arrays.sort(boxed, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                if(Math.abs(a-m) == Math.abs(b-m))
                    return a-b;
                else return Math.abs(a-m) - Math.abs(b-m);
            }
        });
        
        
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = boxed[n-i-1];
        }
        
        return res;
        
    }
}