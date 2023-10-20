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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=inorder.length;
        int m=preorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
       return createTree(preorder,0,m-1,inorder,0,n-1,map);
    }
    public TreeNode createTree(int[] preorder,int preStart,int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> map){
        if(preStart>preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        int inRoot=map.get(root.val);
        int numsLeft=inRoot-inStart;

        root.left=createTree(preorder,preStart+1, preStart+numsLeft,inorder, inStart, inRoot-1,map);
        root.right=createTree(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1, inEnd,map);
        return root;
    }
}