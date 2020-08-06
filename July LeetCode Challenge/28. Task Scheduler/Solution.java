/**

@lc id : 621
@problem : Task Scheduler
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/task-scheduler/
@difficulty : medium
*/

class Solution {
    
    public int leastInterval(char[] tasks, int n) {
        
        int[] freqMap = new int[26];
        
        for(char currentTask : tasks)
            freqMap[currentTask - 'A']++;
        
        Arrays.sort(freqMap);
        
        int maxValue = freqMap[25] - 1;
        int idleSlots = maxValue * n;
        
        for(int i = 24; i >= 0; i--){
            idleSlots -= Math.min(freqMap[i], maxValue);
        }
        
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
        
    }
}