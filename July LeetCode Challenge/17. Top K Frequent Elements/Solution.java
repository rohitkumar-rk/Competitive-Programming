/**

@lc id : 347
@problem : Top K Frequent Elements
@url : https://leetcode.com/problems/top-k-frequent-elements/
@author : https://github.com/rohitkumar-rk
@difficulty : medium
*/


class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> frequencyMap = new HashMap();
        
        //Create hashmap of nums with their frequency in given array
        for(int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        
        //Priority Queue to store Map Elements in decreasing
        //Order of frequency
        PriorityQueue<Map.Entry<Integer, Integer>> pq
            = new PriorityQueue<Map.Entry<Integer, Integer> >(new MapEntryComparator());
        
        //Inserting map into pq
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet())
            pq.add(entry); 
    
    
        int[] res = new int[k];
        
        //Remove first k elements from pq and add to result array
        for(int i = 0;i < k; i++){
            res[i] = pq.poll().getKey();
        }
        
        return res;
    }
}

//Custom Comparator to Compare Map.Entry and sort in decreasing order
class MapEntryComparator implements Comparator<Map.Entry<Integer, Integer>> {
              
    public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
        
        if(a.getValue() < b.getValue())
            return 1;
        
        else if(a.getValue() > b.getValue())
            return -1;
        
        else return 0;
     
    } 
} 
