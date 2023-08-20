class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][]dp=new int[n+1][n];
        for(int[] num: dp){
            Arrays.fill(num,-1);
        }
       return helper(nums,dp,0,-1);
    }
    public int helper(int[]nums,int[][]dp, int index, int prev){
        if(index==nums.length){
            return 0;
        }
        if(dp[index][prev+1]!=-1){
            return dp[index][prev+1];
        }
        int len=helper(nums,dp,index+1,prev);
        if(prev==-1 || nums[index]>nums[prev]){
            len=Math.max(len,1+helper(nums,dp,index+1,index));
        }
        return dp[index][prev+1]=len;
    }
}