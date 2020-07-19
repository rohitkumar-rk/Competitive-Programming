/**

@lc id : 485
@problem : Max Consecutive Ones
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/max-consecutive-ones/
@difficulty : easy 
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int maxConsecutive = 0;
        
        for(int i = 0; i < nums.length;i++){
            int curr = 0;
            if(nums[i] == 1){
                curr = 1;
                i++;
                while(i < nums.length && nums[i] == 1){
                    curr++;
                    i++;
                }
            }
            
            if(curr> maxConsecutive)
                maxConsecutive = curr;
        }
        return maxConsecutive;
    }
}