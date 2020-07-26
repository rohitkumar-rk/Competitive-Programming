/**

@lc id : 25
@problem :  Find Minimum in Rotated Sorted Array II
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
@difficulty : hard 
*/

class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < min)
                min = nums[i];
        }
        return min;
    }
}