class Solution {
    public int change(int amount, int[] coins) {
        
        int[][] dp = new int[coins.length+1][amount+1];
        
        /*Fill first column by 1 because we can have sum 0 in one way
        i.e. by not selecting any coin*/
        
        for(int i = 0; i < dp.length; i++)
            dp[i][0] = 1;
        
        //Now fill entire table
        
        for(int row = 1; row < dp.length; row++){
            for(int col = 1; col < dp[row].length; col++){
                if(col >= coins[row-1])
                    dp[row][col] = dp[row-1][col] + dp[row][col-coins[row-1]];
                else dp[row][col] = dp[row-1][col];
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
    }
}