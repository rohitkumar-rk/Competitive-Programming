/**

@lc id : 33
@problem : Search in Rotated Sorted Array
@author : rohit
@url : https://leetcode.com/problems/search-in-rotated-sorted-array/
@difficulty : medium
*/

class Solution {
    
    public int binarySearch(int[] nums, int start, int end, int target){
        //Base Case
        if(start > end)
            return -1;
        
        //Rec case
        int mid = (end + start) / 2;
        
        if(nums[mid] == target)
            return mid;
        
        //Checking where mid point lies
        //On first part or second part
        
        //Mid lies in Left part or first line
        if(nums[start] <= nums[mid]){
            
            if(target >= nums[start] && target <= nums[mid])
                return binarySearch(nums, start, mid-1, target);
            else return binarySearch(nums, mid+1, end, target);
            
        }
        
        //Mid lies in second line
        
        if(target >= nums[mid] && target <= nums[end])
            return binarySearch(nums, mid+1, end, target);
        
        return binarySearch(nums, start, mid-1, target);
        
    }
    
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
        
    }
}