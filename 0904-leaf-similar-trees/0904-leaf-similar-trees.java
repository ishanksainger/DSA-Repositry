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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leftList=new ArrayList<>();
        List<Integer> rightList=new ArrayList<>();
        helper(root1,leftList);
        helper1(root2,rightList);
        if(leftList.size()!=rightList.size()) return false;
        return leftList.equals(rightList) ? true:false;
    }
    public void helper(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            list.add(root.val);
            return;
        }
        helper(root.left,list);
        helper(root.right,list);

    }
    public void helper1(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            list.add(root.val);
            return;
        }
        helper1(root.left,list);
        helper1(root.right,list);

    }
}