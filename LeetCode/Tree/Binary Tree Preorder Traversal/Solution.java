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
    
    //Recursive approach
    public List<Integer> preorderHelper(TreeNode root, List<Integer> res){
        if(root == null)
            return res;
        res.add(root.val);
        res = preorderHelper(root.left,res);
        res = preorderHelper(root.right, res);
        return res;
    }
    
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        while(){
            
        }
    }
}