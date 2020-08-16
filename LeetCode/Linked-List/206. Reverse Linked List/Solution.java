/**

@lc id : 206
@problem : Reverse Linked List
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/reverse-linked-list/
@difficulty : easy
@tags : Linked List
*/

class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head == null || head.next == null)
            return head;

        ListNode finalHead =  reverseList(head.next);
        ListNode temp  = head.next;

        temp.next  = head;
        head.next = null;

        return finalHead;
    }
}