/**
@lc id : 100
@problem : Same Tree
@author : rohit
@date : 13/07/2020
@url : https://leetcode.com/problems/same-tree/
 */

class Solution {
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        //Both trees are null
        if(p == null && q == null)
            return true;
        
        //One Tree is null
        if( (p == null && q != null) || ( p != null && q == null ))
            return false;
        
        //Tree Root has same val
        if(p.val == q.val)
            return  isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
        return false;
        
    }
}