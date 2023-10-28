
class Solution {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        helper(root);
    }

    public void helper(TreeNode root){
        if (root== null) {
            return;
        }

        helper(root.left);
        helper(root.right);

        TreeNode rightNode=root.right;
        root.right=root.left;
        root.left=null;
        TreeNode newNode=root;
        while(newNode.right!=null){
            newNode=newNode.right;
        }
        newNode.right=rightNode;
    }
}