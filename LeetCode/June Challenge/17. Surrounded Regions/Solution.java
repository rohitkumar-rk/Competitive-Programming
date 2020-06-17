class Solution {
    
    public boolean isValid(int i, int j, int m, int n){
        if(i >= 0 && j >= 0 && i < m && j < n)
            return true;
        return false;      
    }
    
    public char[][] bfs(char[][] board, Queue<Integer[]> queue){
        int m = board.length;
        int n = board[0].length;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,+1}};
        
        while(!queue.isEmpty()){
            Integer[] curr = queue.remove();
            int currX = curr[0];
            int currY = curr[1];
            
            for(int i = 0; i < 4; i++){
                int adjX = currX + directions[i][0];
                int adjY = currY + directions[i][1];
                
                if(isValid(adjX, adjY, m, n) && board[adjX][adjY] == 'O'){
                    board[adjX][adjY] = '+';
                    queue.add(new Integer[]{adjX, adjY});
                }
                
            }
            
        }
        
        return board;
    }
    
    public void solve(char[][] board) {
        int m = board.length;  //no. of rows
        if(m == 0) return;
        
        int n = board[0].length;  //no. of columns
        Queue<Integer[]> queue = new LinkedList<Integer[]>();
        
        //Mark first col and last col 'O' as + 
        //and push into queue
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O'){
                board[i][0] = '+';
                queue.add(new Integer[]{i,0});
            }
            if(board[i][n-1] == 'O'){
                board[i][n-1] = '+';
                queue.add(new Integer[]{i,n-1});
            }
        }
        
        //Mark 'O' of 1st row and last row as '+'
        for(int i = 0; i < n; i++){
            if(board[0][i] == 'O'){
                board[0][i] = '+';
                queue.add(new Integer[]{0,i});
            }
            if(board[m-1][i] == 'O'){
                board[m-1][i] = '+';
                queue.add(new Integer[]{m-1,i});
            }
        }
        
        board = bfs(board, queue);
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == '+')
                    board[i][j] = 'O';
            }
        }
          
        
    }
    
}