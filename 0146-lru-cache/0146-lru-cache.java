class LRUCache {
    class Node{
        Node prev,next;
        int value,key;
        Node(int key, int value){
            this.key=key;
            this.value=value;
            this.prev=null;
            this.next=null;
        }
    }
    Map<Integer,Node>map;
    Node dummyHead,dummyTail;
    int capacity;

    public LRUCache(int capacity) {
        map=new HashMap<>();
        this.capacity=capacity;
        dummyHead=new Node(0,0);
        dummyTail=new Node(0,0);
        dummyHead.next=dummyTail;
        dummyTail.prev=dummyHead;
    }
    public void addCode(Node node){
        Node next=dummyHead.next;
        dummyHead.next=node;
        node.next=next;
        node.prev=dummyHead;
        next.prev=node;
    }
    public void removeNode(Node node){
       Node prev=node.prev;
       Node next=node.next;
       prev.next=next;
       next.prev=prev;
    }
    public void moveForward(Node node){
        removeNode(node);
        addCode(node);
    }
    
    public int get(int key) {
        Node node=map.get(key);
        if(node==null){
            return -1;
        }
        moveForward(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node=map.get(key);
        if(node==null){
            Node newNode=new Node(key,value);
           if(map.size()>=capacity){
               Node prevNode=dummyTail.prev;
               map.remove(prevNode.key);
               removeNode(prevNode);
           }
           addCode(newNode);
           map.put(key,newNode);
        }
        else{
            node.value=value;
            moveForward(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */