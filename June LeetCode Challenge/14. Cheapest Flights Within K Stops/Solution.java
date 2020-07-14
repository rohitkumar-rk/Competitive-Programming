class Solution {
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        Map<Integer, List<int[]>> graph = createGraph(flights);
        int minCost = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        int stop = 0;
        
        queue.add(new int[]{src, 0});
        
        while(!queue.isEmpty()){
            int qSize = queue.size();
            
            for(int i = 0; i < qSize; i++){
                int[] currStop = queue.remove();
                if(currStop[0] == dst){
                    minCost =  Math.min(minCost, currStop[1]);
                }
                
                if(!graph.containsKey(currStop[0]))
                    continue;
                
                for(int[] f : graph.get(currStop[0])){
                    if(currStop[1] + f[1] > minCost)
                        continue;
                    queue.add(new int[]{f[0], f[1] + currStop[1]});
                }
                
           }
            
            if(stop++ > K)
                break;
            
        }
              
        if(minCost == Integer.MAX_VALUE)
              return -1;
        else return minCost;
          
    }
    
    Map<Integer, List<int[]>> createGraph(int[][] flights){
        Map<Integer, List<int[]>> graph = new HashMap<Integer, List<int[]>>();
        
        for(int[] flight : flights){
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        
        return graph;
    }
    
}