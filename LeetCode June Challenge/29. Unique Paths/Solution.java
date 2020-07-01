class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        
        //We can reach each cell in col 0 by only 1 way i.e. going down
        for(int i = 0; i < dp[0].length; i++)
            dp[0][i] = 1;
        
        //We can reach each cell in row 0 by only 1 way i.e. going right
        for(int i = 0; i < dp.length; i++)
            dp[i][0] = 1;
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[i].length; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
                
        }
        
        return dp[m-1][n-1];
        
    }
}