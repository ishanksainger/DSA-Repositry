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
        List<Integer> list=new ArrayList<>();
        while(node!=null){
            list.add(node.val);
            node=node.next;
        }
        int i=0,j=list.size()-1;
        int max=Integer.MIN_VALUE;
        System.out.println(list);
        while(i<j){
            int num1=list.get(i);
            int num2=list.get(j);
            max=Math.max(max,num1+num2);
            i++;
            j--;
        }
        return max;
    }
}