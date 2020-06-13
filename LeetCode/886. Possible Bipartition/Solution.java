class Solution {
    
    public boolean isPossible(ArrayList<ArrayList<Integer>> graph, int n,
                                     int[] group, int currColor, int currVertex){
		group[currVertex] = currColor;

		for(int node : graph.get(currVertex)){

			//If color of adjacent is same as currVertex,
			//There is conflict
			if(group[node] == currColor)
				return false;
			
			if(group[node] == 0)
				if(isPossible(graph, n, group, -1*currColor, node) == false)
					return false;
		}	

		return true;
	}
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        //Since vertices are 1 indexed, we use <=
        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<Integer>());

        //Create Adjacency List
        for(int i = 0; i < dislikes.length; i++){
            int x = dislikes[i][0];
            int y = dislikes[i][1];

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

		//Denotes which vertex is in which group
		// Two groups -1 & 1
		int[] group = new int[n+1];

		for(int i = 1; i <= n; i++){
			if(group[i] == 0)
				if(!isPossible(graph, n, group, 1, i))
					return false;
		}
        
		return true;  
    }
}