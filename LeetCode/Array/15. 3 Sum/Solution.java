/*
@lc id : 15
@problem : 3 Sum
@author : rohit
@url : https://leetcode.com/problems/3sum/
@difficulty : medium
*/

class Solution {
    
    public void twoSums(int[] nums, int requiredSum, int first, List<List<Integer>>  result){
        
        int second = nums.length - 1;
        
        while(first < second){
            
            int currSum = nums[first] + nums[second];

            if(currSum == requiredSum){
                result.add(Arrays.asList(-requiredSum, nums[first], nums[second]));
                first++;
                second--;

                while(nums[first] == nums[first-1] && first < second)
                    first++;

                while(nums[second] == nums[second+1] && second > first)
                    second--;
            }
            
            else if(currSum > requiredSum) second--;
            else first++;

        }
    }
    
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            twoSums(nums, -nums[i], i+1, result);
        }

        return result;
        
    }
}