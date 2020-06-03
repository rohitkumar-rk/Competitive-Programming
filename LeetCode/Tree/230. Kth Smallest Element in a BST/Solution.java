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
    
    public List<Integer> inorder(TreeNode root, List<Integer> res){
        if(root == null)
            return res;
        res = inorder(root.left,res);
        res.add(root.val);
        res = inorder(root.right,res);
        return res;
        
    }
    
    public int kthSmallest(TreeNode root, int k) {
       List<Integer> inOrderList = new ArrayList<Integer>();
       inOrderList = inorder(root, inOrderList);
        
       return inOrderList.get(k-1);
        
    }
}