/**

@lc id : 19
@problem :  Add Binary
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/add-binary/
@difficulty : easy 
*/

import java.math.BigInteger;

class Solution {
    
    public String addBinary(String a, String b) {
        
        BigInteger firstNum = new BigInteger(a,2);
        BigInteger secondNum = new BigInteger(b,2);
        
        BigInteger sum = firstNum.add(secondNum);
        
        return sum.toString(2);
        
    }
}