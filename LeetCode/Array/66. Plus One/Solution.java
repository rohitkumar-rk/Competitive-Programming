/**

@lc id : 66
@problem : Plus One
@author : github.com/rohitkumar-rk
@date  : 06/07/2020
@url : https://leetcode.com/problems/plus-one/
@difficulty : easy
*/

class Solution {
    
    public int[] plusOne(int[] digits) {
        
        for(int i = digits.length -1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            
            digits[i] = 0;
        }
        
        //If carry has propogated to the end,
        //First index will contain 1 and all other 0
        int res[] = new int[digits.length+1];
        res[0] = 1;
        return res;
    }
}