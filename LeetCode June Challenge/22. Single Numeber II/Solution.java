class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            if(!map.containsKey(num))
                map.put(num, 1);
            else {
                int freq = map.get(num);
                map.put(num, freq+1);
            }
        }
        
        for (Map.Entry mapElement : map.entrySet()) { 
            int key = (int) mapElement.getKey(); 
            int value = (int) mapElement.getValue(); 
            
            if(value == 1)
                return key;
        } 
        
        return -1;
    }
}