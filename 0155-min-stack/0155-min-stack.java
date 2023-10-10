class MinStack {
    ListNode head;
    class ListNode{
        ListNode next;
        int val;
        int min;
        ListNode(int val, int min){
            this.val=val;
            this.next=null;
            this.min=min;
        }
    }

    public MinStack() {
        head=null;
    }
    
    public void push(int val) {
        if(head==null){
            ListNode newNode=new ListNode(val,val);
            head=newNode;
        }
        else{
            ListNode newNode=new ListNode(val,Math.min(val,head.min));
            newNode.next=head;
            head=newNode;
        }
    }
    
    public void pop() {
        head=head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */