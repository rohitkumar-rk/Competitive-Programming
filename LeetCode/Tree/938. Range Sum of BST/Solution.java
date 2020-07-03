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
    
    public int rangeSumBST(TreeNode root, int l, int r) {
        
        if(root == null)
            return 0;
        
        /*Current root node is given range, so we add node value to sum
        and call function on lst and rst*/
        if(root.val >= l && root.val <=r){
            return root.val + rangeSumBST(root.left, l, r) + rangeSumBST(root.right, l, r);
        }
        
        //Condition to traverse left
        if(r < root.val)
            return rangeSumBST(root.left, l, r);
        
        //Condition to traverse right
        if(l > root.val)
            return rangeSumBST(root.right, l, r);
        
        return 0;
    }
}