/**

@lc id : 1344
@problem : Angle Between Hands of a Clock
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/angle-between-hands-of-a-clock/
@difficulty : medium
*/

class Solution {
    public double angleClock(int hour, int minutes) {
        
        double minuteAngle = minutes * 6;
        
        double hourAngle = (hour % 12) * 30 +  ( (double) minutes / 2);
        
        double angle = Math.abs(minuteAngle - hourAngle);
        
        if(360 - angle < angle)
            return 360 - angle;
        
        else return angle;
        
    }
}