/**

@lc id : 34
@problem : Find First and Last Position of Element in Sorted Array
@author : rohit
@url : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
@difficulty : medium
*/

class Solution {
    
    public int findEndingIndex(int[] nums, int target){
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(nums[mid] == target)
                index = mid;
            
            if(nums[mid] <= target)
                start = mid + 1;
            else end = mid - 1;
        }
            
        
        
        
        return index;
    }
    
    public int findStartingIndex(int[] nums, int target){
        int index = -1;
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end){
            int mid = start +  (end - start) / 2;
            if(nums[mid]  == target)
                index = mid;
            
            //If we have found target, still we want to go on left side
            //If we haven't found, and target is smaller than mid, go left
            if(nums[mid] >= target)
                end = mid - 1;
            
            else start = mid + 1;
        }
        
        return index;
    }
    
    public int[] searchRange(int[] nums, int target) {
        
        int[] result  = new int[2];
        result[0] = findStartingIndex(nums, target);
        result[1] = findEndingIndex(nums, target);
        return result;
    }
}