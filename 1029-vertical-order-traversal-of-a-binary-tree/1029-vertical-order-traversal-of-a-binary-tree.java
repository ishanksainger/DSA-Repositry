/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Edge{
        int col, row;
        TreeNode node;
        Edge(int col, int row, TreeNode node){
            this.col=col;
            this.row=row;
            this.node=node;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Edge> queue =new LinkedList<>();
        queue.add(new Edge(0,0,root));
        List<List<Integer>> list=new ArrayList<>();
        while(!queue.isEmpty()){
            Edge e=queue.remove();
            int c=e.col;
            int r=e.row;
            TreeNode node=e.node;

            if(!map.containsKey(c)){
                map.put(c,new TreeMap<>());
            }
            if(!map.get(c).containsKey(r)){
                map.get(c).put(r, new PriorityQueue<>());
            }
            map.get(c).get(r).add(node.val);
            if(node.left!=null){
                queue.add(new Edge(c-1,r+1,node.left));
            }
            if(node.right!=null){
                queue.add(new Edge(c+1,r+1,node.right));
            }
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> val: map.values()){
            List<Integer> ans=new ArrayList<>();
            for(PriorityQueue<Integer> pq: val.values()){
               while (!pq.isEmpty()) { // Use a loop to extract all elements from the priority queue
                ans.add(pq.remove());
                }   
            }
            list.add(ans);
        }
        return list;
    }
}