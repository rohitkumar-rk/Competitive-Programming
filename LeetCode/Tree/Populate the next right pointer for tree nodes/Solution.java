/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    
    public Node connectHelper(Node root){
        //Case for empty tree or leaf node
        if(root == null || root.left == null)
            return root;
        
        //Set next pointer of childrens of root note
        root.left.next = root.right;
        if(root.next != null)
            root.right.next = root.next.left;
        
        //Recursively call for lst and rst
        connectHelper(root.left);
        connectHelper(root.right);
        return root;
    }
    
    public Node connect(Node root) {
        return connectHelper(root);
    }
}