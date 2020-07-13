/*
@lc id : 25 Reverse Nodes in k-Group
@url : https://leetcode.com/problems/reverse-nodes-in-k-group/
@author : rohit 
@date : 05/07/2020
*/

class Solution {
    
    //This function reverse first k nodes in ll
    public ListNode reverseKNodes(ListNode head, int k){
        
        if(head == null || head.next == null || k == 1)
            return head;

        ListNode finalHead =  reverseKNodes(head.next,k-1);
        ListNode temp  = head.next;

        temp.next  = head;
        head.next = null;

        return finalHead;
    }
    
    //Return kth Node
    public ListNode getKthNode(ListNode head, int k){
        ListNode kthNode = head;
        for(int i = 1; i < k; i++){
            if(kthNode == null)
                return null;
            kthNode = kthNode.next;
        }
        return kthNode;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || head.next == null || k == 0 || k ==1)
            return head;
        
        ListNode kthNode, nextOfKthNode;
        ListNode finalHead = new ListNode(0);
        //Tail of previous group
        ListNode prevTail = finalHead;
        
        while(head != null && head.next != null){
            
            //This will be the tail of current group after reversing k nodes
            ListNode currTail = head;
            
            /*We need to find kthNode to ensure that k or more elements
            are still left in list to reverse, if not, then reversal is complete and break*/
            kthNode = getKthNode(head, k);
            
            //Less than k nodes left, so break
            if(kthNode == null)
                break;
            
            //Find first element of next group
            nextOfKthNode = getKthNode(head, k+1);
        
            //Get head of current group after reversing
            ListNode currHead = reverseKNodes(head, k);
            
            //Point tail of previous group to head of current group
            prevTail.next = currHead;
            
            //Point tail of current list to rest of the nodes in group 
            currTail.next = nextOfKthNode;
            
            //Move head to first element of next group
            head = nextOfKthNode;
            
            //Now finally, since we have got a new group,
            //now point prevTail to tail of current group
            prevTail = currTail;
        }
        
        //Return next of dummy node
        return finalHead.next;
        
    }
}