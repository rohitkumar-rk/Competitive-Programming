class Solution {
    public boolean isPowerOfTwo(int n) {
        
        while(n%2 == 0 && n > 1){
            n /= 2;
        }
        
        if(n == 1)
            return true;
        else return false;
    }
}