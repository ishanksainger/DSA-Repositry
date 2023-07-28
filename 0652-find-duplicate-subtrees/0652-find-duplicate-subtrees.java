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
    List<TreeNode> list;
    Map<String, Integer> map;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        list=new ArrayList<>();
        map=new HashMap<>();
        helper(root);
        return list;
    }
    public String helper(TreeNode root){
        if(root==null){
            return "N";
        }
        String left=helper(root.left);
        String right=helper(root.right);
        String str=root.val+" " + left + " "+ right;
        map.put(str, map.getOrDefault(str,0)+1);
        if(map.get(str)==2){
            list.add(root);
        }
        return str;
    }
}