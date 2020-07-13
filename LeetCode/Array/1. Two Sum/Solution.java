/**

@lc id : 1
@problem : Two Sum
@author : rohit
@url : https://leetcode.com/problems/two-sum/
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
        
            if( map.containsKey( target - nums[i] )
             &&  map.get(target - nums[i]) != i)
                return new int[]{i, map.get(target - nums[i])};
            map.put(nums[i], i);
        }
        
        return null;
    }
}