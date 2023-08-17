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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean flag=true;
        if (root==null){
            return list;
        }
        TreeNode prev=null;
        while(!queue.isEmpty()){
            TreeNode node=queue.remove();
            if(node!=null){
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            else{
                list.add(prev.val);
                if(!queue.isEmpty()){
                    queue.add(null);
               }
            }
            prev=node;
        }
        return list;
    }
}