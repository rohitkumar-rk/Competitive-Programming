class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        //if array is empty
        int len = nums.length;
        if(nums == null || len == 0)
            return new ArrayList<Integer>();
        
        Arrays.sort(nums);
        
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        
        
        for(int i = 1; i < len; i++){
            for(int j = i-1; j >= 0; j--){
                if(nums[i] % nums[j] == 0)
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        
        //get maxIndex
        
        int maxIndex = 0;
        
        for(int i = 1; i < len; i++){
            if(dp[i] > dp[maxIndex])
                maxIndex = i;
        }
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        int currNum = nums[maxIndex];
        int currCount = dp[maxIndex];
        
        for(int i = maxIndex; i >=0; i--){
            if(currNum % nums[i] == 0 && dp[i] == currCount){
                res.add(nums[i]);
                currNum = nums[i];
                currCount--;
            }
        }
        
        return res;
        
    }
}