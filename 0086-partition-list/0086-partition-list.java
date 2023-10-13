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
    public ListNode partition(ListNode head, int x) {
        if (head==null){
            return null;
        }
        ListNode node1=new ListNode(0);
        ListNode node2=new ListNode(0);

        ListNode dummy1=node1;
        ListNode dummy2=node2;

        ListNode curr=head;

        while(curr!=null){
            if(curr.val<x){
                dummy1.next=curr;
                dummy1=dummy1.next;
            }
            else{
                dummy2.next=curr;
                dummy2=dummy2.next;
            }
            curr=curr.next;
        }
        dummy1.next=node2.next;
        dummy2.next=null;
        return node1.next;
    }
}