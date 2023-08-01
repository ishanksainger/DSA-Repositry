/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void levelOrder(Map<TreeNode,TreeNode>map, TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.remove();
                if(node.left!=null){
                    queue.add(node.left);
                    map.put(node.left, node);
                }
                if(node.right!=null){
                    queue.add(node.right);
                    map.put(node.right, node);
                }
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map=new HashMap<>();
        levelOrder(map, root);
        Map<TreeNode, Boolean> visited=new HashMap<>();
        Queue<TreeNode> queue=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        queue.add(target);
        visited.put(target,true);
        int currLevel=0;
        while(!queue.isEmpty()){
            if(currLevel==k){
                break;
            }
            int size=queue.size();
            currLevel++;
            for(int i=0;i<size;i++){
                TreeNode node=queue.remove();
                if(node.left!=null && visited.get(node.left)==null){
                    queue.add(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    queue.add(node.right);
                    visited.put(node.right,true);
                }
                if(map.get(node)!=null && visited.get(map.get(node))==null){
                    queue.add((map.get(node)));
                    visited.put((map.get(node)),true);
                }
            }
        }
        while(!queue.isEmpty()){
            list.add(queue.remove().val);
        }
        return list;
    }
}