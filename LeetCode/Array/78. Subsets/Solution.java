/**

@lc id : 78
@problem : Subsets
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/subsets/
@difficulty : medium
*/

class Solution {
    
    public void  subsetsHelper(int currIndex, int nums[], ArrayList<Integer> currSubset,
                               List<List<Integer>> subsets){
        
        subsets.add(new ArrayList<>(currSubset));
        
        for(int i = currIndex; i < nums.length; i++){
            currSubset.add(nums[i]);
            subsetsHelper(i+1, nums, currSubset, subsets);
            currSubset.remove(currSubset.size() - 1);
        }
        
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsetsHelper(0, nums, new ArrayList(), subsets);
        return subsets;
    }
}