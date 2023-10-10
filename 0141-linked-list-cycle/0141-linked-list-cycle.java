/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
       ListNode faster=head;
       ListNode slower=head;
       if(head==null){
           return false;
       }
       while(faster.next!=null && faster.next.next!=null){        
           faster=faster.next.next;
           slower=slower.next;

           if(faster==slower){
               return true;
           }
       }
       return false;
    }
}