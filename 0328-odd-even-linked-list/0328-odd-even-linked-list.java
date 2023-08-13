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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddNode=new ListNode(0);
        ListNode evenNode=new ListNode(0);
        ListNode currentNode=head;

        ListNode dummy1=oddNode;
        ListNode dummy2=evenNode;
        int size=1;
        while (currentNode!=null){
            if (size%2!=0){
                dummy1.next=currentNode;
                dummy1=dummy1.next;
            }
            else {
                dummy2.next=currentNode;
                dummy2=dummy2.next;
            }
            currentNode=currentNode.next;
            size++;
        }
        dummy1.next=evenNode.next;
        dummy2.next=null;
        return oddNode.next; 
    }
}