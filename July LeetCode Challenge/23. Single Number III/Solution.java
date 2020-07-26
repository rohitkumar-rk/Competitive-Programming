/**

@lc id : 23
@problem :  Single Number III
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/single-number-iii/
@difficulty : medium 
*/

class Solution {
    public int[] singleNumber(int[] nums) {
        
        HashSet<Integer> set = new HashSet();
        int[] res = new int[2];
        
        for(int num : nums){
            if(set.contains(num))
                set.remove(num);
            
            else set.add(num);
        }
        
        Iterator iterator = set.iterator();
        int i = 0;
        for(int n : set) {
            res[i++] = n;
        }
        
        return res;
        
    }
}