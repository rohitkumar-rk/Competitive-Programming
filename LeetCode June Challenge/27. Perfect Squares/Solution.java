class Solution {
    
    public int numSquares(int n) {
        
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        
        //We will calculate least no. of perfect squares
        //requred for each num from 1 to n
        for(int num = 1; num <= n; num++){
            
            //Worst case would be "we take all 1's so it would be num"
            int minValue = num;
            
            /*For each num, we will try to form "num"
             from squres of 1, 2, 3 i.e. 1,4,9  square <= num */
            
            //Start with 1
            int x = 1, perfSquare = x*x;
            
            while(perfSquare <= num){
                //Include currPerfSquare in res and check for the number left
                //after using currPerfSquare i.e. for 10 if we currPerfSquarr is 4
                //Now we add 4 to res and check for (10-4) in dp
                
                minValue = Math.min(minValue, 1 + dp[num - perfSquare]);
                x++;
                perfSquare = x*x;
            }
            dp[num] = minValue;
            
        }
        
        return dp[n];
    }
}