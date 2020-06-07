
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        int n = costs.length;
        
        Arrays.sort(costs, new Comparator<int[]>(){
            public int compare(int[] a1, int[] a2) {
                return (a1[1] - a1[0]) - (a2[1] - a2[0]);
             }
        });
        
        int sum = 0;
        
        for(int i = 0; i < n/2;i++){
            sum += costs[i][1];
        }
        for(int i = n/2; i < n;i++){
            sum += costs[i][0];
        }
        return sum;
    }
}