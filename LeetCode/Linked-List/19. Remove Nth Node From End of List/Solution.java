/**
 @lc id : 19
 @problem : Remove Nth Node From End of List
 @author : rohit
 @date : 01/07/2020
 @url : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head.next == null && n == 1)
            return null;
        
        ListNode slow = head, fast = head, slowPrev = head;
        
        //Now fast is at nth node
        for(int i = 0; i < n-1; i++)
            fast = fast.next;
        
       while(fast.next != null){
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        
        if(slow == head){
            head = head.next;
            return head;
        }
        
        slowPrev.next = slow.next;
        return head;
    }
}