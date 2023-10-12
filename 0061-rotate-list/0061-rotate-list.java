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
    public ListNode rotateRight(ListNode head, int k) {
        int size=0;
        if (head==null || head.next==null){
            return head;
        }
        ListNode node=head;
        while(node!=null){
            size++;
            node=node.next;
        }
        k=k%size;
        if (k==0){
            return head;
        }

        ListNode halfNode=(rotateNodes(head));
        ListNode newNode=new ListNode(0);
        ListNode dummy=newNode;

        while(k>0){
            dummy.next=halfNode;
            dummy=dummy.next;
            halfNode=halfNode.next;
            k--;
        }
        dummy.next=null;

        ListNode firstHalf=rotateNodes(newNode.next);
        ListNode secondHalf=rotateNodes(halfNode);
        ListNode resultNode=firstHalf;

        while(resultNode.next!=null){
            resultNode=resultNode.next;
        }
        resultNode.next=secondHalf;

        return firstHalf;
        
    }
    public ListNode rotateNodes(ListNode node ){
        ListNode prev=null;
        ListNode curr=node;

        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}