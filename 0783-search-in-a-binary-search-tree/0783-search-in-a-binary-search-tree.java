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
    public TreeNode searchBST(TreeNode root, int val) {
        List<TreeNode> list=new ArrayList<>();
        helper(root,list,val);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    public void helper(TreeNode node, List<TreeNode> list,int val){
        if(node==null){
            return;
        }
        if(node.left!=null && node.val==val){
            list.add(node);
            list.add(node.left);
            return;
        }
        if(node.right!=null && node.val==val){
            list.add(node);
            list.add(node.right);
            return;
        }
        if(node.val==val){
            list.add(node);
            return;
        }
        helper(node.left, list, val);
        helper(node.right, list, val);
    }
}