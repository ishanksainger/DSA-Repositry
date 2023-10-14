/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
     int size=0;
      if(head==null){
         return null;
     }
        ListNode node=head;
        while (node!=null){
            node=node.next;
            size++;
        }
        if(n==size){
            return head.next;
        }
        int result=size-n;
        ListNode prevNode=head;
        while (result>1){
            prevNode=prevNode.next;
            result--;
        }
        prevNode.next=prevNode.next.next;
        return head;

    }

}