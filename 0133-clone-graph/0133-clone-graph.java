class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Node[] visited=new Node[101];
        Node copyNode=new Node(node.val);
        Arrays.fill(visited,null);
        dfs(visited,copyNode,node);
        return copyNode;
    }
    public void dfs(Node[] visited, Node copyNode, Node node){
        visited[copyNode.val]=copyNode;

        for(Node n: node.neighbors){
            if(visited[n.val]==null){
                Node newNode=new Node(n.val);
                copyNode.neighbors.add(newNode);
                dfs(visited,newNode,n);
            }
            else{
                copyNode.neighbors.add(visited[n.val]);
            }
        } 
    }
}