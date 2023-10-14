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
    public ListNode deleteDuplicates(ListNode head) {
        List<Integer> set=new ArrayList<>();
        int temp=Integer.MIN_VALUE;
        ListNode node=head;
        while(node!=null){
            if(set.contains(node.val)){
               set.remove(Integer.valueOf(node.val)); 
               temp=node.val;
            }
            else if(node.val!=temp){
                set.add(node.val);
            }
            node=node.next;
        }
        ListNode newList=new ListNode(0);
        ListNode dummy=newList;
        for(int num:set){
            dummy.next=new ListNode(num);
            dummy=dummy.next;
        }
        return newList.next;
    }
}