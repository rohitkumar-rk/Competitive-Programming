class Solution {
    public void sortColors(int[] nums) {
        
        int count0 = 0, count1 = 0, count2 = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                count0++;
            else if(nums[i] == 1)
                count1++;
            else if(nums[i] == 2)
                count2++;
        }
        
        int lastIndex = 0;
        
        for(int i = 0; i < count0; i++)
            nums[i] = 0;
        
        lastIndex += count0;
        
        for(int i = 0; i < count1; i++)
            nums[lastIndex+i] = 1;
        
        lastIndex += count1;
        
        for(int i = 0; i < count2; i++)
            nums[lastIndex+i] = 2;
    
        
    }
}