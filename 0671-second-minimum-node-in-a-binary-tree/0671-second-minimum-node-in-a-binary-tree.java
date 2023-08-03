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
    long secondMin;
    public int findSecondMinimumValue(TreeNode root) {
        secondMin=Long.MAX_VALUE;
        helper(root, Long.MAX_VALUE);
        if(secondMin==Long.MAX_VALUE){
            return -1;
        }
        return (int)secondMin;
    }
    public void helper(TreeNode root,long min){
        if(root==null){
            return;
        }
        min=Math.min(min, root.val);
        if(root.val>min && root.val<secondMin){
            secondMin=root.val;
        }
        helper(root.left, min);
        helper(root.right, min);
    }
}