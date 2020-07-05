/*
@lc id : 264 Ugly Number II
author : rohit
date : 04/07/2020
*/

class Solution {
    public int nthUglyNumber(int k) {
        if(k<0)
			return 0;
		
		int[] ugly = new int[k];
        ugly[0] = 1;

		int nextMultipleOf2 = 2;
		int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;
        
        int nextUglyNumber;
        int index2 = 0, index3 = 0, index5 = 0;

		for(int i = 1; i < k; i++){
            
            nextUglyNumber = Math.min(nextMultipleOf2,
                                      Math.min(nextMultipleOf3,nextMultipleOf5));
            
            ugly[i] = nextUglyNumber;
            
			if(nextUglyNumber == nextMultipleOf2) nextMultipleOf2 = ugly[++index2] * 2;
			
			if(nextUglyNumber == nextMultipleOf3) nextMultipleOf3 = ugly[++index3] * 3;   
            
			if(nextUglyNumber == nextMultipleOf5) nextMultipleOf5 = ugly[++index5] * 5;
	
		}
        
		return ugly[k-1];
        
    }
}