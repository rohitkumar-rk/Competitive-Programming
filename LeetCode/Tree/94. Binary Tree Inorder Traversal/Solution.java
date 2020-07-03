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
    
    public List<Integer> inorderHelper(TreeNode root, List<Integer> res){
        if(root == null)
            return res;
        res = inorderHelper(root.left,res);
        res.add(root.val);
        res = inorderHelper(root.right,res);
        return res;
        
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        res = inorderHelper(root, res);
        return res;
        
    }
}