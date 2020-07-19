/**

@lc id : 1295
@problem : Find Numbers with Even Number of Digits
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
@difficulty : easy 
*/

class Solution {
    
    public int countLength(int num){
        int length = 0;
        while(num > 0){
            num /= 10;
            length++;
        }
        return length;
    }
    
    public int findNumbers(int[] nums) {
        int countEven = 0;
        
        for(int num : nums){
            if(countLength(num) %2 == 0)
                countEven++;
        }
        
        return countEven;
    }
}