/**

@lc id : 203
@problem : Remove Linked List Elements
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/remove-linked-list-elements/
@difficulty : easy
 */

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        //Remove all continuous elements with value = val
        while(head != null && head.val == val)
            head = head.next;
        
        ListNode curr = head;
        
        while(curr != null && curr.next != null) {
            
            if(curr.next.val == val)
                curr.next = curr.next.next;
            
            else curr = curr.next;
        }
        
        return head;
    }
}