class Solution {
    int max = Integer.MIN_VALUE;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max, Math.max(left, right)); // Fix the max update here
        return Math.max(left, right) + 1; // Return the maximum of left and right + 1
    }
}
