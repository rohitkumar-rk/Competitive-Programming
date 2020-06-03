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
    
    public List<Integer> postorderHelper(TreeNode root, List<Integer> res){
        if(root == null)
            return res;
        res = postorderHelper(root.left, res);
        res = postorderHelper(root.right, res);
        res.add(root.val);
        return res;
    }
    
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        res = postorderHelper(root, res);
        return res;
    }
}