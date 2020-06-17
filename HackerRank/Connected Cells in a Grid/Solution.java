import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    static boolean isValid(int x, int y, int n, int m, int[][] matrix){
        
        if(x >= 0 && y >= 0 && x < n && y < m && matrix[x][y] == 1)
            return true;
        return false;
        
    }
    
    static int bfs(int[][] matrix, boolean[][] visited, int x, int y){
        Queue<Integer[]> queue  = new LinkedList<Integer[]>();
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
        int count = 1;
        
        queue.add(new Integer[]{x,y});
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            Integer[] curr = queue.remove();
            int currX = curr[0];
            int currY = curr[1];
            
            for(int i = 0; i < 8; i++){
                int adjX = currX + directions[i][0];
                int adjY = currY + directions[i][1];
                
                if(isValid(adjX, adjY, n, m, matrix) && !visited[adjX][adjY]){
                    queue.add(new Integer[]{adjX, adjY});
                    visited[adjX][adjY] = true;
                    count++;
                }        
                
            }
                  
        }
        
        return count;
        
    }

    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxCells = -1;
        boolean[][] visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && matrix[i][j] == 1){
                    int currMax = bfs(matrix, visited, i, j);
                    System.out.println("Curr ma : " + currMax);
                    if(currMax > maxCells)
                        maxCells = currMax;
                }
            }
        }
        
        return maxCells;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
