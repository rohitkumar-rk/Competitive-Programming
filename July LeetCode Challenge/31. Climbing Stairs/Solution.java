/**

@lc id : 70
@problem :  Climbing Stairs
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/climbing-stairs/
@difficulty : easy
@tags : dp
*/

class Solution {
    public int climbStairs(int n) {
                
        int[] waysToClimb = new int[n+1];
        waysToClimb[0] = 1; waysToClimb[1] = 1;
        
        for(int i = 2; i <= n; i++){
            waysToClimb[i] = waysToClimb[i-1] + waysToClimb[i-2];
        }
        
        return waysToClimb[n];
    }
}