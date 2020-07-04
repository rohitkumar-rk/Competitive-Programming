/*
@lc id : 107 Binary Tree Level Order Traversal II
Author : Rohit
Date : 02/07/2020
*/

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        if(root == null)
            return new ArrayList<List<Integer>>();
        
        Queue<TreeNode> queue = new  LinkedList<TreeNode>();
        List<List<Integer>> levelOrderTraversal = new ArrayList<List<Integer>>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int qSize = queue.size();
            List<Integer> currLevel = new ArrayList<Integer>();
            
            for(int i = 0; i < qSize; i++){
                TreeNode currNode = queue.remove();
                currLevel.add(currNode.val);
                
                if(currNode.left != null)
                    queue.add(currNode.left);
                
                if(currNode.right != null)
                    queue.add(currNode.right);
            }
            
            levelOrderTraversal.add(0, currLevel);
        }
        
        return levelOrderTraversal;
        
    }
}