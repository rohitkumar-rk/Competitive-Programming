/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p , TreeNode q) {

        if(root == null)
            return null;

        //If root of given tree is equal to 1 of the 2 nodes,
        //Then it would be the ancestor
        if(root.val == p.val || root.val == q.val)  
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //Not null from both left and right
        /* If we get some node i.e. not null from both left sub-tree
        and right sub-tree, it means that root is the common ancestor  */
        if(left != null && right != null)
            return root;

        //Null from both left and right
        /* No element i.e. p & q was found in lst and rst. So return null */
        if(left == null && right == null)
            return null;

        /*  Only 1 null value 
        This will be case when one node is ancestor of other node */
        return left != null ? left : right;
    }
}