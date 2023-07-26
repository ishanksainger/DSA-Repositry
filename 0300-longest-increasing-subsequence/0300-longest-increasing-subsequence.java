class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        // n+1 because we we are going from -1 to n-1 to it means we needs n number and space of n+1;
        int[][] dp=new int[n][n+1];
        for(int[] num: dp){
            Arrays.fill(num, -1);
        }
        // we are sending -1 as prev because starting point is 0
        return helper(0,-1, nums, dp);
    }
    public int helper(int idx, int prev, int[] nums, int[][]dp){
        if(idx==nums.length){
            return 0;
        }
        // we are doing prev+1 because -1 is the starting point and index cant be-1 so we are adding +1 in every index so it doesnt give error.
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