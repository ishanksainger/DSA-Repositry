class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int[] num: dp){
            Arrays.fill(num, -1);
        }
        return helper(0,-1, nums, dp);
    }
    public int helper(int idx, int prev, int[] nums, int[][]dp){
        if(idx==nums.length){
            return 0;
        }
        if(dp[idx][prev+1]!=-1){
            return dp[idx][prev+1];
        }
        int len=0+ helper(idx+1, prev, nums,dp);
        if(prev==-1 || nums[idx]>nums[prev]){
            len= Math.max(len, 1 + helper(idx+1, idx, nums, dp));
        }
        return dp[idx][prev+1]=len;
    }
}