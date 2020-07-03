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

	public static HashMap<Integer,Integer> indexMap = new HashMap<Integer, Integer>();

    public static TreeNode buildTreeHelper(int[] preorder,
     int[] inorder, int preorderStart, int preorderEnd, int inorderStart, int inorderEnd){

        if(inorderStart > inorderEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preorderStart]);
        int rootIndex = indexMap.get(preorder[preorderStart]);
        int leftInS = inorderStart;
        int leftInE = rootIndex -1;
        int leftPreS = preorderStart+1;
        int leftPreE = leftInE - leftInS + leftPreS;
        int rightInS = rootIndex+1;
        int rightInE = inorderEnd;
        int rightPreS = leftPreE+1;
        int rightPreE = preorderEnd;

        root.left = buildTreeHelper(preorder, inorder, leftPreS, leftPreE,
                    leftInS, leftInE);
        root.right = buildTreeHelper(preorder, inorder, rightPreS, rightPreE,
                    rightInS, rightInE);
        return root;

    }




    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        createMap(inorder);
    	return buildTreeHelper(preorder, inorder, 0, preorder.length-1,0, inorder.length-1);
    }

    public static void preOrderTraversal(TreeNode tree){
    	if(tree == null)
    		return;
    	System.out.print(tree.val + " ");
    	preOrderTraversal(tree.left);
    	preOrderTraversal(tree.right);
    	return;
    }

    public static void inOrderTraversal(TreeNode tree){
    	if(tree == null)
    		return;
    	inOrderTraversal(tree.left);
    	System.out.print(tree.val + " ");
    	inOrderTraversal(tree.right);
    	return;
    }

    public static void createMap(int[] inorder){
        for(int i = 0; i < inorder.length; i++)
            indexMap.put(inorder[i],i);
    }

}