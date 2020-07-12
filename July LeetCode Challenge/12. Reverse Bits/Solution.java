/*
@lc idd : 190 Reverse Bits
@author : rohit
@date : 12/07/2020
@url : https://leetcode.com/problems/reverse-bits/
*/

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0, power = 31;
        
        while(power >= 0){
            res += (n & 1) << power;
            n = n >> 1;
            power--;
        }
        
        return res;
    }
}