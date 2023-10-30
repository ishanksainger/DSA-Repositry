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
    ArrayList<Integer> ls = new ArrayList<>();
    public int countNodes(TreeNode root) {
        count(root);
        return ls.size();
    }
    private void count(TreeNode root){
        if(root == null){
            return;
        }
        ls.add(root.val);
        count(root.left);
        count(root.right);
    }
}