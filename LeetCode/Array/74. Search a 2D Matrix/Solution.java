/**

@lc id : 74
@problem : Search a 2D Matrix
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/search-a-2d-matrix/
@difficulty : medium
*/

class Solution {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length == 0) return false;
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        int left = 0;
        int right = rows*columns - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            //Consider 2d matrix as a linear array
            int midRow = mid/columns;
            int midCol = mid%columns;
            int midElement = matrix[midRow][midCol];
        
            if(midElement == target)
                return true;
            
            else if(target > midElement)
                left = mid + 1;
            
            else if(target < midElement)
                right = mid - 1;
            
        }
        
        return false;
        
    }
}