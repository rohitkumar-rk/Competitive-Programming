/**
 @lc id : 14
 @problem : Linked List Cycle
 @author : rohit
 @date : 02/07/2020
 @url : https://leetcode.com/problems/linked-list-cycle/
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head == null)
            return false;
        
        ListNode slow = head, fast = head.next;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
        
    }
}