/*
@lc id : 4
@problem : Median of Two Sorted Arrays
@author : rohit
@url : https://leetcode.com/problems/median-of-two-sorted-arrays/
@difficulty : hard
*/

class Solution {
    
    public double findMedianSortedArrays(int[] input1, int[] input2) {
     
        //if input1 length is greater than input2 length, switch
        //so that num1 length is smaller
        
        if(input1.length > input2.length)
            return findMedianSortedArrays(input2, input1);
        
        int x = input1.length;
        int y = input2.length;
        
        //We will do binary search on input1
        
        int low = 0;
        int high = x;
        
        while(low <= high){
            int partitionX = (low + high) / 2;
            
            /* partitionX + partitionY should be equal to (x+y+1) / 2
            (x+y) is sum of length of both arrays, we need to find mid 
            therefore we are looking for (x+y) / 2 but for it to work for both even
            and odd length, we use (x+y+1) / 2 */
            
            int partitionY = (x+y+1)/2 - partitionX;
            
            //if partitionX is 0, there is nothing on left side and we have to 
            //compare max of left side X with right side Y min, so we take max as -inf
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            
            /*If partitionX = x, there is nothing on right side of X, and we have to compare
            max of leftY with min of rightX for partition to be valid, So we take minRightX = +INF */
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];
            
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                /*We have partitioned array at correct place
                Now if combined lenght is even, get max of left and min of right
                If it is odd, get max of left*/
                
                if((x+y) % 2 == 0)
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY) ) / 2;
                
                else return (double) Math.max(maxLeftX, maxLeftY);
                
                
            }
            
            //We are too far on right side, go on left side
            else if(maxLeftX > minRightY)
                high = partitionX - 1;
            
            //We are too far on left size, go to right side
            else low = partitionX + 1;
            
        }
        
        return 0.0;
        
    }
    
}