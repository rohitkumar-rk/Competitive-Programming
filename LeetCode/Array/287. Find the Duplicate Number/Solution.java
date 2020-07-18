/**

@lc id : 287
@problem : Find the Duplicate Number
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/find-the-duplicate-number/
@difficulty : medium
*/

class Solution {
    
    public int findDuplicate(int[] nums) {
       
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i]))
                return nums[i];
            set.add(nums[i]);
        }
        return -1;
    }
}