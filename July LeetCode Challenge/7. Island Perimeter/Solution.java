/*
@lc id : 463 Island Perimeter
@author : rohit
@date : 07/07/2020
@url : https://leetcode.com/problems/island-perimeter/
*/

class Solution {
    
    public int oneCellPerimeter(int x, int y, int[][] grid){
        
        int perimeter = 0;
        
        //Up
        if(x == 0 || grid[x-1][y] == 0)
            perimeter++;
        
        //Down
        if(x == grid.length - 1 || grid[x+1][y] == 0)
            perimeter++;
        
        //Left
        if(y == 0 || grid[x][y-1] == 0)
            perimeter++;
        
        //Right
        if(y == grid[0].length - 1 || grid[x][y+1] == 0)
            perimeter++;
        
        return perimeter;
        
    }
    
    
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                if(grid[row][col] == 1)
                    perimeter +=  oneCellPerimeter(row, col, grid);
            }
        }
        return perimeter;
    }
}