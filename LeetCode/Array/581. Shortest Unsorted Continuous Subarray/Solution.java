/**

@lc id : 581
@problem : Shortest Unsorted Continuous Subarray
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
@difficulty : easy 
*/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        //Whether array is unsorted
        boolean flag = false;
        
        //Find min value in unsorted array
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1])
                flag = true;
            
            if(flag)
                min = Math.min(min, nums[i]);
        }
        
        flag = false;
        
        //Find max value in unsorted array
        for(int i = nums.length-2; i >= 0; i--){
            if(nums[i] > nums[i+1])
                flag = true;
            
            if(flag)
                max = Math.max(max, nums[i]);
        }
        
        int start, end;
        //Find start of unsorted array
        for(start = 0; start < nums.length; start++){
            if(min < nums[start])
                break;
        }
        
        //Find end of unsorted array
        for(end = nums.length-1; end >= 0; end--){
            if(max  > nums[end])
                break;
        }
        
        return end - start < 0 ? 0 : (end - start) + 1;
        
    }
}