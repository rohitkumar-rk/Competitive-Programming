/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    static boolean res = false;

    static boolean pathHelper(TreeNode root, long k){
        if(root == null)
            return false;
        if(root.val > k)
            return false;
        if(k == root.val && root.left == null && root.right == null){
            return true;
        }
        if(pathHelper(root.left, k-root.val))
            return true;
        if(pathHelper(root.right, k-root.val))
            return true;
        return false;
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
        return pathHelper(root, sum);
        
    }
}