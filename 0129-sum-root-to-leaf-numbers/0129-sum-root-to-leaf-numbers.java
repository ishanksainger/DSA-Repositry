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
    List<String> list;
    public int sumNumbers(TreeNode root) {
        list = new ArrayList<>();
        helper(root, new StringBuilder());
        int sum = 0;
        for (String num : list) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    public void helper(TreeNode root, StringBuilder str) {
       if(root==null){
          return;
       }
        str.append(root.val);
        if(root.left==null && root.right==null){
            list.add(str.toString());
        }
        helper(root.left, str);
        helper(root.right, str);
        str.deleteCharAt(str.length() - 1);
    }
}