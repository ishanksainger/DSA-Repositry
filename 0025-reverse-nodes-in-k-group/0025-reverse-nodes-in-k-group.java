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
    public ListNode reverseKGroup(ListNode head, int k) {
        int size=0;
        size=nodeSize(head);
        int actualSize=size-(size%k);
        ListNode curr=head;
        ListNode newList=new ListNode(0);
        ListNode dummy=newList;
        while(actualSize>0){
            ListNode prev=null;
            ListNode node=curr;
            int temp=k;
            while (temp > 0 && curr != null) { 
                curr=curr.next;
                temp--;
            }
            prev=reverseNode(node,k);
            dummy.next=prev;
            while(dummy.next!=null){
                dummy=dummy.next;
            }        
            actualSize=actualSize-k;
        }
        dummy.next=curr;
        return newList.next;
    }
    public int nodeSize(ListNode head){
        ListNode curr=head;
        int size=0;
        while(curr!=null){
            size++;
            curr=curr.next;
        }
        return size;
    }
    public ListNode reverseNode(ListNode head, int k){
        ListNode curr=head;
        ListNode prev=null;
        while(k>0 && curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            k--;
        }
        return prev;
    }
}