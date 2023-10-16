/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        makeCopy(head);
        makeRandom(head);
        Node resultList=newCopy(head);
        return resultList;
    }
    public void makeCopy(Node node){
        Node curr=node;
        while(curr!=null){
            Node newNode=new Node(curr.val);
            Node next=curr.next;
            curr.next=newNode;
            newNode.next=next;
            curr=curr.next.next;
        }
    }
    public void makeRandom(Node head){
        Node curr=head;
        while(curr!=null){
            if(curr.random!=null){
                Node random=curr.random;
                curr.next.random=random.next;
            }
            curr=curr.next.next;
        }
    }
    public Node newCopy(Node head){
        Node curr=head;
        Node newList=new Node(0);
        Node dummy=newList;
        while(curr!=null){
            dummy.next=curr.next;
            curr.next=curr.next.next;
            curr=curr.next;
            dummy=dummy.next;

        }
        return newList.next;
    }
}