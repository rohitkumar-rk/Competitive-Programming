/**

@lc id : 258
@problem : Add Digits
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/add-digits/
@difficulty : easy
*/

class Solution {
    public int addDigits(int num) {
        if(num == 0)
            return 0;
        
        int digitalRoot = num % 9;
        
        if(digitalRoot == 0 && num > 0)
            return 9;
        
        return digitalRoot;
    }
}