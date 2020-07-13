/**

@lc id : 35
@problem : Search Insert Position
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/search-insert-position/
@difficulty : easy
*/

class Solution {
    
    public int binarySearch(int[] nums, int target, int start, int end){
        
        if(end < start)
            return -1;
        
        if(target > nums[end])
            return end+1;
        
        if(target < nums[start])
            return 0;
        
        int mid = (start + end) / 2;
        
        if(nums[mid] == target)
            return mid;
        
        else if(target < nums[mid]){
            if(target > nums[mid-1])
                return mid;
            return binarySearch(nums, target, start, mid - 1);
        }
            
        
        else if(target > nums[mid]){
            if(target < nums[mid+1])
                return mid+1;
            return binarySearch(nums, target, mid+1, end);
        }
            
        
        else return -1;
    }
    
    public int searchInsert(int[] nums, int target) {
        
        return binarySearch(nums, target, 0, nums.length-1);
        
    }
}