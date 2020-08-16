/**

@lc id : 430
@problem : Flatten a Multilevel Doubly Linked List
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
@difficulty : medium
@tags : Linked List, dfs
*/

class Solution {
    
    public Node flattenHelper(Node head){
        Node prev = null;
        Node next;
        Node child;
        
        while(head != null){
            next = head.next;
            
            if(head.child != null){
                head.next = head.child;
                head.child.prev = head;
                child = head.child;
                head.child  = null;
                Node childTail = flattenHelper(child);
                
                if(next == null)
                    return head;
                
                childTail.next = next;
                next.prev = childTail;
                head = next;
                continue;
                   
            }
            prev = head;
            head = head.next;
            
        }
        
       return prev;
    }
    
    
    
    public Node flatten(Node head) {
        
        if(head == null)
            return null;
    
        flattenHelper(head);
        return head;
        
    }
}