/**

@lc id : 1502
@problem :  Can Make Arithmetic Progression From Sequence
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
@difficulty : easy 
*/

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        
        Arrays.sort(arr);
        
        int diff = Math.abs(arr[1] - arr[0]);
        
        for(int i = 2; i < arr.length; i++){
            int currDiff = Math.abs(arr[i] - arr[i-1]);
            if(currDiff != diff)
                return false;
        }
        
        return true;
    }
}