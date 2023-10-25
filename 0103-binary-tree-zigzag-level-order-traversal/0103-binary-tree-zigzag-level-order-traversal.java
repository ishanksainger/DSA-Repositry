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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean isZigZag = false;
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> intList = new ArrayList<>();
            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node != null) {
                    linkedList.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            if (!isZigZag) {
                intList.addAll(linkedList);
                isZigZag = true;
            } else if (isZigZag) {
                Collections.reverse(linkedList);
                intList.addAll(linkedList);
                isZigZag = false;
            }
            System.out.println(intList);
            list.add(intList);
        }
        return list;
    }
}