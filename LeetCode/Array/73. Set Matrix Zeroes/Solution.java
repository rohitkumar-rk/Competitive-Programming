/**

@lc id : 73
@problem : Set Matrix Zeroes
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/set-matrix-zeroes/
@difficulty : medium
*/

class Solution {
    
    public void setZeroes(int[][] matrix) {
        
        boolean isCol = false;
        
        for(int i = 0; i < matrix.length; i++){
            
            if(matrix[i][0] == 0)
                isCol = true;
            
            for(int j = 1; j < matrix[i].length; j++){
                
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
                
            }
        }
        
        for(int row = 1; row < matrix.length; row++){
            for(int col = 1; col < matrix[row].length; col++){
                if(matrix[row][0] == 0 || matrix[0][col] == 0)
                    matrix[row][col] = 0;
            }
        }
        
        //First row
        if(matrix[0][0] == 0){
            for(int col = 0; col < matrix[0].length; col++){
                 matrix[0][col] = 0;
            }
        }
         
        //First column
        if(isCol){
            for(int row = 0; row < matrix.length; row++){
                 matrix[row][0] = 0;
            }
        }
            
        
        
    }
}