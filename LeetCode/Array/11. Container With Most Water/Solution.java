/**

@lc id : 11
@problem : Container With Most Water
@author : rohit
@url : https://leetcode.com/problems/container-with-most-water/
@difficulty : medium
*/

class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;
        
        while(i < j){
            int min = Math.min(height[i], height[j]);
            max = Math.max(max, min * (j - i));
            
            if(height[i] < height[j])
                i++;
            else j--;
        }
        
        return max;
    }
}