/*
@lc id : 662 Maximum Width of Binary Tree
@author : rohit
@date : 08/07/2020 
@url : https://leetcode.com/problems/maximum-width-of-binary-tree/
 */

class Solution {
    
    int maxWidth;
    HashMap<Integer, Integer> leftMostPosition;
    
    public void getWidth(TreeNode root, int depth, int position){
        
        if(root == null) return;
        
        leftMostPosition.computeIfAbsent(depth, x -> position);
        maxWidth = Math.max(maxWidth, position - leftMostPosition.get(depth) + 1);
        getWidth(root.left, depth+1, position*2);
        getWidth(root.right, depth+1, position*2 + 1);
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        maxWidth = 0;
        leftMostPosition = new HashMap<>();
        getWidth(root, 0, 0);
        return maxWidth;
    }
}