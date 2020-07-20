/**

@lc id : 18
@problem :  Course Schedule II
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/course-schedule-ii/
@difficulty : medium 
*/

class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] graph = new LinkedList[numCourses];

        for(int i = 0; i < numCourses; i++)
            graph[i] = new LinkedList<Integer>();

        for(int[] courses : prerequisites){
            graph[courses[1]].add(courses[0]);
        }
        
        List<Integer> s = new LinkedList();
        int[] visited = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0 && dfs(i, graph, s, visited))
                return new int[0];
            
        }
        
        Collections.reverse(s);
        
        int[] result = s.stream().mapToInt(Integer::intValue).toArray();
        
        return result;
        
        
    }
    
    public boolean dfs(int start, List<Integer>[] graph, List<Integer> s, int[] visited){
        visited[start] = 1;
        
        for(int vertex : graph[start]){
            if(visited[vertex] == 1)
                return true;
            
            if(visited[vertex] == 0  && dfs(vertex, graph, s, visited))
                return true;
        }
        
        visited[start] = 2;
        s.add(start);
        return false;
    }
    
}