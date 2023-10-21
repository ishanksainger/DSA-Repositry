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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=inorder.length;
        int m=postorder.length;

        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
       return  createTree(postorder,m-1,0,inorder,0,n-1,map);
    }
    public TreeNode createTree(int[] postorder,int postEnd, int postStart, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> map){
        if(inStart>inEnd || postStart>postEnd){
            return null;
        }
        TreeNode root=new TreeNode(postorder[postEnd]);
        int inRoot=map.get(root.val);
        int numRight=inEnd-inRoot;

        root.left=createTree(postorder,postEnd-numRight-1,postStart,inorder,inStart,inRoot-1,map);
        root.right=createTree(postorder,postEnd-1,postEnd-numRight,inorder,inRoot+1,inEnd,map);
        return root;
    }
}