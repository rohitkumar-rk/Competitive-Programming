class Solution {
    public int hIndex(int[] c) {
        int ans = 0;
        for(int i = 0; i < c.length; i++){
            int temp = c[i] < (c.length - i) ? c[i] : (c.length - i);
            ans = ans > temp ? ans : temp;
        }
        
        return ans;
    }
}