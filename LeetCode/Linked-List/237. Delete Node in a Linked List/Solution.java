/**

@lc id : 237
@problem :  Delete Node in a Linked List
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/delete-node-in-a-linked-list/
@difficulty : easy 
*/

class Solution {
    public void deleteNode(ListNode node) {
        if(node.next == null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
        
    }
}