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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node=l1;
        ListNode node1=l2;

        ListNode newNode=new ListNode(0);
        ListNode dummy=newNode;
        int carry=0;
        while(node!=null || node1!=null || carry!=0){
            int val=0;
            if(node!=null){
                val+=node.val;
                node=node.next;
            }
            if(node1!=null){
                val+=node1.val;
                node1=node1.next;
            }
            val+=carry;
            carry=val/10;
            dummy.next=new ListNode(val%10);
            dummy=dummy.next;
        }
        return newNode.next;

    }
}