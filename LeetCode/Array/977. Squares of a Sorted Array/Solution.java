/**

@lc id : 977
@problem : Squares of a Sorted Array
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/squares-of-a-sorted-array/
@difficulty : easy 
*/

class Solution {
    public int[] sortedSquares(int[] A) {
        
        for(int i = 0; i < A.length; i++){
            A[i] = A[i] * A[i];
        }
        
        Arrays.sort(A);
        return A;
    }
}