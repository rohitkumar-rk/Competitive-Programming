/**
 
@lc id : 79
@problem : Word Search
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/word-search/
@difficulty : medium
*/

import java.io.*;
import java.util.*;

class Solution {

    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int count, String word){
        if(count == word.length())
            return true;

        if(i < 0 || j < 0 || i >= board.length || j >= board[i].length
            || board[i][j] != word.charAt(count)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board, i+1, j, count + 1, word)   //Down
                        || dfs(board, i, j+1, count + 1, word)  //Right
                        || dfs(board, i-1, j, count+1, word)     //Up
                        || dfs(board, i, j-1, count+1, word);  //Left
        board[i][j] = temp;
        return found;     
    }

   
}
