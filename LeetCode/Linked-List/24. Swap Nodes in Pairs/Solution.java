/**

@lc id : 24
@problem : Swap Nodes in Pairs
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/swap-nodes-in-pairs/
@difficulty : medium
@tags : Linked List
*/

class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null)
            return head;
        
        head.next.next = swapPairs(head.next.next);
        ListNode temp = head.next.next;
        ListNode originalHead = head;
        head = head.next;
        head.next = originalHead;
        originalHead.next = temp;
        return head;
    }
}