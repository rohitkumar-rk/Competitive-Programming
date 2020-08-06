/**

@lc id : 309
@problem : Best Time to Buy and Sell Stock with Cooldown
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
@difficulty : medium
*/

class Solution {
    
    public int maxProfit(int[] prices) {
        
        if(prices == null || prices.length <= 1)
            return 0;
  
        int buy0 = -prices[0];
        int buy1 = buy0;
        int sell0 = 0, sell1 = 0, sell2 = 0;
 
        for(int i = 1; i < prices.length; i++) {
            buy0 = Math.max(buy1, sell2 - prices[i]);
            sell0 = Math.max(sell1, buy1 + prices[i]);
            
            buy1 = buy0;
            sell2 = sell1;
            sell1 = sell0; 
        }
        
        return sell0;
        
    }
    
}