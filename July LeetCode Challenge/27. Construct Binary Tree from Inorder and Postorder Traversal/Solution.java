/**

@lc id : 106
@problem :  Construct Binary Tree from Inorder and Postorder Traversal
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
@difficulty : medium 
@tags : Tree, DFS
*/

class Solution {
    
    public static HashMap<Integer,Integer> indexMap = new HashMap<Integer, Integer>();
    
    public static void createMap(int[] inorder){
        for(int i = 0; i < inorder.length; i++)
            indexMap.put(inorder[i],i);
    }
    
    public static TreeNode buildTreeHelper(int[] postorder, int[] inorder, 
                                           int postorderStart, int postorderEnd,
                                           int inorderStart, int inorderEnd){
        
        if(inorderStart > inorderEnd)
            return null;
        
        //Create node with last element of Post Order
        TreeNode root = new TreeNode(postorder[postorderEnd]);
        
        //Find pos of root in inorder, because all elements left to this pos
        //wiill be in lst and right to pos will be in rst
        int rootIndex = indexMap.get(postorder[postorderEnd]);
        
        //Find start and end of inorder and postorder for left sub-tree
        //to makre recursive call
        int leftInS = inorderStart;
        int leftInE = rootIndex - 1;
        int leftPostS = postorderStart;
        int leftPostE = leftPostS + leftInE - leftInS;
        
        //Find start and end of inorder and postorder for right sub-tree
        //to makre recursive call
        int rightInS = rootIndex+1;
        int rightInE = inorderEnd;
        int rightPostS = leftPostE+1;
        int rightPostE = postorderEnd-1;
        
        //Build lst of root
        root.left = buildTreeHelper(postorder, inorder, leftPostS, leftPostE,
                    leftInS, leftInE);
        
        //Build rst of root
        root.right = buildTreeHelper(postorder, inorder, rightPostS, rightPostE,
                    rightInS, rightInE);
        
        return root;

    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        createMap(inorder);
        
        return buildTreeHelper(postorder, inorder, 0, postorder.length-1,
                               0, inorder.length-1);
         
    }
}