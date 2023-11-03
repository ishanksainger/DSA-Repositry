class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode prev=null;
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(prev!=null && root.val<=prev.val){
                return false;
            }
            prev=root;
            root=root.right;
        }
        return true;
    }
}