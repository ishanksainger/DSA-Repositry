class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][]dp=new int[n][n];
        for(int[] num: dp){
            Arrays.fill(num,-1);
        }
       return helper(dp,0,-1,nums);
    }
    public int helper(int[][]dp, int curr, int prev, int[] nums){
        if(curr==nums.length){
            return 0;
        }
        if(dp[curr][prev+1]!=-1){
            return dp[curr][prev+1];
        }
        int len=0 + helper(dp,curr+1, prev, nums);
        int take=0;
        if(prev==-1 || nums[curr]>nums[prev]){
            len = Math.max(len,1 + helper(dp,curr+1,curr,nums));
        }
        return dp[curr][prev+1]=len;
    }
}