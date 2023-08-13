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
    public int pairSum(ListNode head) {
        ListNode node=head;
        int size=0;
        while(node!=null){
            size++;
            node=node.next;
        }
        int[] list=new int[size];
        node=head;
        int idx=0;
        while(node!=null){
            list[idx]=node.val;
            node=node.next;
            idx++;
        }
        int i=0,j=list.length-1;
        int max=Integer.MIN_VALUE;
        while(i<j){
            int num1=list[i];
            int num2=list[j];
            max=Math.max(max,num1+num2);
            i++;
            j--;
        }
        return max;
    }
}