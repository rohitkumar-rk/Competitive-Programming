/**

@lc id : 1470
@problem :  Shuffle the Array
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/shuffle-the-array/
@difficulty : easy 
*/

class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int[] res = new int[2*n];
        
        for(int i = 0;i < n; i++){
            int xi = nums[i];
            int yi = nums[n+i];
            res[2*i] = xi;
            res[2*i+1] = yi;
        }
        
        return res;
    }
}