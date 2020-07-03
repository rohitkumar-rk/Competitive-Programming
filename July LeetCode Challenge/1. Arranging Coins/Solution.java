/*
@lc id : 441 Arranging Coins
Author : Rohit
Date : 01/07/2020
*/
class Solution {
    public int arrangeCoins(int n) {
        int count = 0;
        int i = 1;
        
        for(i = 1;;i++){
            
            if(n - count < i){
                i--;
                break;
            }
            
            count += i;   
        }
        
        return i;
    }
}