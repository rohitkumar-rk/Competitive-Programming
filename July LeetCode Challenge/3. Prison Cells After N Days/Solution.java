/*
@lc id : 957 Prison Cells After N Days
@author : rohit
@date : 03/07/2020
@url : https://leetcode.com/problems/prison-cells-after-n-days/
*/

class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            String state = Arrays.toString(cells);
            
            if(map.containsKey(state)){
                int loopLength = i - map.get(state);
                int remainingDays = (n - i) % loopLength;
                return prisonAfterNDays(cells, remainingDays);
            }
            
            else{
                map.put(state, i);
                int prev = cells[0];
                
                for(int j = 1; j < 7; j++){
                    int next = cells[j+1];
                    int curr = cells[j];
                    cells[j] = prev == next ? 1 : 0;
                    prev = curr;
                }
                
            }
            cells[0] = 0;
            cells[7] = 0;
        }
        
        
        return cells;
        
    }
}