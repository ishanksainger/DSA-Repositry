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
     public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next==null){
            return head;
        }
        ListNode leftnode=leftNode(head,left);
        ListNode rightnode=rightNode(head,right);
        ListNode prevNode=head;
        while (left>2){
            prevNode=prevNode.next;
            left--;
        }
        ListNode restNodes=rightnode.next;
        ListNode reverseNode=reverseNode(leftnode,rightnode);
        if(head!=leftnode) {
            prevNode.next=reverseNode;
        }
        else{
            head=reverseNode;
        }
        while(reverseNode.next!=null){
            reverseNode=reverseNode.next;
        }
        reverseNode.next=restNodes;
        return head;
    }
    public ListNode leftNode(ListNode head, int left){
        ListNode node=head;
        while (left>1){
            node=node.next;
            left--;
        }
        return node;
    }
    public ListNode rightNode(ListNode head, int right){
        ListNode node=head;
        while (right>1){
            node=node.next;
            right--;
        }
        return node;
    }
    public ListNode reverseNode(ListNode left, ListNode right){
        ListNode node=left;
        ListNode prev=null;
        ListNode rightNode=right.next;
        while (node!=rightNode){
            ListNode next=node.next;
            node.next=prev;
            prev=node;
            node=next;
        }
        return prev;
    }
}