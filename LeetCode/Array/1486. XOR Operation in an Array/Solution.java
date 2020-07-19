/**

@lc id : 1486
@problem :  XOR Operation in an Array
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/xor-operation-in-an-array/
@difficulty : easy 
*/

class Solution {
    public int xorOperation(int n, int start) {
        int xor = start;
        
        for(int i = 1; i < n; i++){
            xor = xor ^ (start + 2 * i);
        }
        
        return xor;
    }
}