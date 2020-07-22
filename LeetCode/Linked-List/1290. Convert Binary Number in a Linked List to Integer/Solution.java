/**

@lc id : 1290
@problem : Convert Binary Number in a Linked List to Integer
@url : https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
@author : github.com/rohitkumar-rk
@difficulty : easy
 */

class Solution {
    
    public int getSize(ListNode head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }
    
    public int getDecimalValue(ListNode head) {
        int num = 0;
        int size = getSize(head);
        
        while(head != null){
            num = num + (int) Math.pow(2,--size) * head.val;
            head = head.next;
        }
        
        return num;
    }
}