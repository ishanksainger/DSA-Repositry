class Solution {
    TreeSet<Integer> stack=new TreeSet<>();
    public int kthSmallest(TreeNode root, int k) {
        int result=0;
        treeStack(root);
        for(int num: stack){
            if(k==0){
                break;
            }
            result=num;
            k--;
        }
        return result;
    }
    public void treeStack(TreeNode root){
        if(root==null){
            return;
        }
        stack.add(root.val);
        treeStack(root.left);
        treeStack(root.right);
    }
}