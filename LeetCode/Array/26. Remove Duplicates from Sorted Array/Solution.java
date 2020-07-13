/**

@lc id : 26
@problem : Remove Duplicates from Sorted Array
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
@difficulty : easy
*/
class Solution {
    
    public int removeDuplicates(int[] nums) {
        
        int slow = 0;
        
        for(int fast = 1; fast < nums.length; fast++){
            if(nums[fast] != nums[fast-1]){
                slow++;
                nums[slow] = nums[fast];
            }     
        }
        
        return slow+1;   
    }
}