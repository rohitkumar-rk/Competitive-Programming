/*
@lc id : 2 Add Two Numbers
@author : rohit
@date : 01/07/2020
@url : https://leetcode.com/problems/add-two-numbers/
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        //Create a dummy node for resukt
        ListNode resHead = new ListNode(0);
        ListNode curr = resHead;
        int carry = 0, currSum;
        
    
        while(l1 != null  && l2 != null){
            currSum = carry + l1.val + l2.val;
            
            if(currSum > 9)
                carry = 1;
            else carry = 0;
            
            curr.next = new ListNode(currSum % 10);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        //If both lists have been traversed and carry is left to be 
        //added to result
        if(l1 == null && l2 == null && carry == 1)
            curr.next = new ListNode(1);
        
        //This will run when l1 has more elements than l2
        while(l1 != null){
            currSum = carry + l1.val;
            
            if(currSum > 9)
                carry = 1;
            else carry = 0;
            
            curr.next = new ListNode(currSum % 10);
            l1 = l1.next;
            curr = curr.next;
        }
        
        if(carry == 1)
            curr.next = new ListNode(1);
        
        //This will run when l2 has more elements than l1
        while(l2 != null){
            currSum = carry + l2.val;
            
            if(currSum > 9)
                carry = 1;
            else carry = 0;
            
            curr.next = new ListNode(currSum % 10);
            l2 = l2.next;
            curr = curr.next;
        }
        
        if(carry == 1)
            curr.next = new ListNode(1);
        
        return resHead.next;
        
    }
}