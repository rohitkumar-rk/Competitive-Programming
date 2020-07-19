/**

@lc id : 1475
@problem :  Final Prices With a Special Discount in a Shop
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
@difficulty : easy 
*/

class Solution {
    
    public int nextSmaller(int[] prices, int n){
        int smaller = 0;
        
        for(int i = n+1; i < prices.length; i++){
            if(prices[i] <= prices[n]){
                smaller = prices[i];
                break;
            }     
        }
        return smaller;
    }
    
    public int[] finalPrices(int[] prices) {
        
        for(int i = 0; i < prices.length; i++){
            prices[i] = prices[i] - nextSmaller(prices, i);
        }
        
        return prices;
    }
}