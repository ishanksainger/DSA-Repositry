class Solution {
    List<Integer> list=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        treeStack(root);
        return list.get(k-1);
    }
    public void treeStack(TreeNode root){
        if(root==null){
            return;
        }
        treeStack(root.left);
        list.add(root.val);
        treeStack(root.right);
    }
}