class Solution {
    
    public int calculateMinimumHP(int[][] dungeon) {
       
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] sol = new int[row][col];
        
        /* Princess's Position
        If it contains magic orbs, then we can just enter with health 1
        If it contains demons, we have to enter with 1 health more than demon
        will reduce*/
        sol[row-1][col-1] = dungeon[row-1][col-1] > 0 ? 1 : 1 - dungeon[row-1][col-1];
        
        //Last Column
        /* If the requirement of below cell is 'x',
        then we need x - currentVal to enter current cell, we can't go below 1*/
        for(int i = row-2; i >= 0; i--)
            sol[i][col-1] = Math.max(sol[i+1][col-1] - dungeon[i][col-1], 1);            
        
        /*Last Row
        If requirement of right cell is x, then we need x - currVal
        to enter current cell*/
        for(int j = col-2; j >= 0; j--)
            sol[row-1][j] = Math.max(sol[row-1][j+1] - dungeon[row-1][j], 1);
        
        /*For rest of the cell, we have where dow we need min health
        right or down. Sub currValue from min*/
        for(int i = row-2; i >= 0; i--){
            for(int j = col-2; j >= 0; j--){
                sol[i][j] =  Math.max( Math.min(sol[i+1][j], sol[i][j+1])  - dungeon[i][j] , 1);
            }
        }
        
        return sol[0][0];
        
    }
}