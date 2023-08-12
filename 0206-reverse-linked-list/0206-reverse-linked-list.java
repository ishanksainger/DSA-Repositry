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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev=null;
        ListNode CurrentNode=head;
        while(CurrentNode!=null){
            ListNode next=CurrentNode.next;
            if(prev==null){
                prev=head;
            }            
            CurrentNode.next=prev;
            prev=CurrentNode;
            CurrentNode=next;
        }
        head.next=null;
        head=prev;
    return prev;
    }
}