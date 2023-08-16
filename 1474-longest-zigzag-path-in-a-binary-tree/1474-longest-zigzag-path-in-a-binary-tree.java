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
    int max;
    public int longestZigZag(TreeNode root) {
        max=0;
        if(root==null){
            return -1;
        }
        helper(root.left,0,1);
        helper(root.right,1,1);
        return max;
    }
    public int helper(TreeNode root, int direction, int length){
        if(root==null){
            return 0;
        }
        max=Math.max(max,length);
        if(direction==0){
            helper(root.left,0, 1);
            helper(root.right,1,length+1);
        }
        else{
            helper(root.left,0,length+1);
            helper(root.right,1,1);
        }
        return max;
    }
}