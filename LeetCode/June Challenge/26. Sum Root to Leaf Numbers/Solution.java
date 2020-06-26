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
    
    public int sumNumbersHelper(TreeNode root, int sum, int num){
        
        /*num is the number represented by traversing from root to currrent node
        Initially num = 0*/
        num = num * 10 + root.val;
        
        /*If current node is the leaf node, we need to add this num to sum,
        so return the number generated*/
        if(root.left == null && root.right == null)
            return num;
        
        /*If node contains a left node, check no formed from left sub tree and add it to sum */
        if(root.left != null)
            sum += sumNumbersHelper(root.left, 0, num);
        
        /*If node contains a right node, check no formed from right sub tree and add it to sum */
        if(root.right != null)
            sum += sumNumbersHelper(root.right, 0, num);
        
        //Finally return sum
        return sum;
        
    }
    
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        return sumNumbersHelper(root, 0, 0);
        
    }
}