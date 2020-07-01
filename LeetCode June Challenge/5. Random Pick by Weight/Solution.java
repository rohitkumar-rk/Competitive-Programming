class Solution {
    
    int[] wSum;

    public Solution(int[] w) {
        wSum = new int[w.length];
        
        for(int i = 0; i < w.length; i++)
            wSum[i] = (i == 0) ? w[i] : wSum[i-1] + w[i];
        
    }
    
    public int pickIndex() {
        
        Random random = new Random();
        int len = wSum.length;
        int target = random.nextInt(wSum[len-1]) + 1;
        
        int i =  Arrays.binarySearch(wSum, target);
        return i >= 0 ? i : -i-1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */