/**

@lc id : 797
@problem :  All Paths From Source to Target
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/all-paths-from-source-to-target/
@difficulty : medium 
*/

class Solution {
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        int noVertices = graph.length;
        List<Integer> path = new ArrayList();
        boolean[] visited = new boolean[noVertices];
        
        dfs(graph, noVertices, 0, visited, path, paths);
        return paths;
    }
    
	public  void  dfs(int[][] graph, int noVertices, int startVertex, boolean[] visited,
                      List<Integer> path, List<List<Integer>> paths){

	 	path.add(startVertex);
	 	visited[startVertex] = true;
        
        //Reached target, add curr path to result
        if(startVertex == noVertices - 1){
            ArrayList pathToTarget = new ArrayList(path);
            paths.add(pathToTarget);
        }
        
        //Call dfs on all adjacent nodes of startVertex
	 	for(int i = 0; i < graph[startVertex].length; i++){
	 		dfs(graph, noVertices, graph[startVertex][i], visited, path, paths);
            
            //After traversing path from any node x, x is removed from path
            //and other nodes are explored
            path.remove(path.size()-1);
	 	}
        
	}
    
    
}