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
    public String smallestFromLeaf(TreeNode root) {
        TreeSet<String> set=new TreeSet<>();
        helper(root, set,new StringBuilder());
        return set.first();
    }
    public void helper(TreeNode root, TreeSet<String> set, StringBuilder str){
        if(root==null){
            return;
        }
        str.append((char)(root.val+'a'));
        if(root.left ==null && root.right==null){
            str.reverse();
            set.add(str.toString());
            str.reverse();
        }
        helper(root.left,set,str);
        helper(root.right,set,str);
        str.deleteCharAt(str.length()-1);
    }
}