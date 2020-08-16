/**

@lc id : 817
@problem : Linked List Components
@author : github.com/rohitkumar-rk
@url : https://leetcode.com/problems/linked-list-components/
@difficulty : medium
@tags : Linked List
*/


class Solution {
    public int numComponents(ListNode head, int[] G){ 
        HashSet<Integer> set = new HashSet<Integer>();
        for(int g : G){
            set.add(g);
        }
        
        int components = 0;
        while(head != null){
            if(set.contains(head.val)){
                components++;
                head = head.next;
                while(head != null && set.contains(head.val))
                    head = head.next;
            }
            else head = head.next;
        }
        
        return components;
        
    }
}