/**
 @lc id : 23
 @problem : Merge k Sorted Lists
 @author : rohit
 @date : 09/07/2020
 @url : https://leetcode.com/problems/merge-k-sorted-lists/
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        ListNode res = new ListNode(0);
        ListNode curr =  res;

        //Push all elementos into pq of all lists
        for(ListNode list : lists){
            while(list != null){
                pq.add(list.val);
                list = list.next;
            }
        }

        //Remove from pq and add to list
        while(pq.size() > 0){
            ListNode node = new ListNode(pq.remove());
            curr.next = node;
            curr = curr.next;
        }

        return res.next;
        
    }
}