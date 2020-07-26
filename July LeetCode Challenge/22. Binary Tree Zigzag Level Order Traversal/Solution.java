/**

@lc id : 103
@problem :  Binary Tree Zigzag Level Order Traversal
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
@difficulty : medium 
*/

class Solution {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root == null)
            return new ArrayList();
        
        Stack<TreeNode> stackLtoR = new Stack<TreeNode>();
        Stack<TreeNode> stackRToL = new Stack<TreeNode>();
        
        List<List<Integer>> res = new ArrayList();
        
        boolean leftToRightDirection = true;
        
        stackLtoR.add(root);
        
        while(!stackLtoR.isEmpty() || !stackRToL.isEmpty()){
            List<Integer> currLevel = new ArrayList();
            
            if(leftToRightDirection){
                int stackSize = stackLtoR.size();
                
                for(int i = 0; i < stackSize; i++){
                    TreeNode currNode = stackLtoR.pop();
                    currLevel.add(currNode.val);
                    
                    if(currNode.left != null)
                        stackRToL.push(currNode.left);
                    
                    if(currNode.right != null)
                        stackRToL.push(currNode.right);              
                }    
            }
            
            else{
                int stackSize = stackRToL.size();
                
                for(int i = 0; i < stackSize; i++){
                    TreeNode currNode = stackRToL.pop();
                    currLevel.add(currNode.val);
                    
                    if(currNode.right != null)
                        stackLtoR.push(currNode.right);
                    
                    if(currNode.left != null)
                        stackLtoR.push(currNode.left);       
                }
         
            }

            leftToRightDirection = !leftToRightDirection;
            res.add(currLevel);

        }
        
        return res;
    }
}