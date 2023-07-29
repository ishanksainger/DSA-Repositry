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
 0-i am covered 
 1-i have camera
 -1- i need camera
 */

class Solution {
    int camera;
    public int minCameraCover(TreeNode root) {
        camera=0;
        int num=helper(root);
        if(num==-1){
            camera++;
            return camera;
        }
        return camera;
    }
    public int helper(TreeNode root){
        if(root==null){
            return 1;
        }
        int left=helper(root.left);
        int right=helper(root.right);
        if(left==-1 || right==-1){
            camera++;
            return 0;
        }
        if(left==0 || right==0){
            return 1;
        }
        return -1;
    }
}