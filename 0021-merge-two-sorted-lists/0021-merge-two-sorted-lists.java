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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null){
            return list2;
        }
        if(list2==null ){
            return list1;
        }
        ListNode listhead=null,listTail=null;
        while(list1!=null && list2!=null){
            if(listhead==null && listTail==null){
                if(list1.val<list2.val){
                    listhead=list1;
                    listTail=list1;
                    list1=list1.next;
                }
                else{
                    listhead=list2;
                    listTail=list2;
                    list2=list2.next;
                }
            }
            else{
                if(list1.val<list2.val){
                    listTail.next=list1;
                    list1=list1.next;
                    listTail=listTail.next;
                }
                else{
                    listTail.next=list2;
                    list2=list2.next;
                    listTail=listTail.next;
                }
            }
        }
        if(list1!=null){
            listTail.next=list1;
        }
        if(list2!=null){
            listTail.next=list2;
        }
        return listhead;
    }
}