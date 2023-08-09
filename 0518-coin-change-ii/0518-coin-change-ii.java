class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] nums:dp){
            Arrays.fill(nums,-1);
        }
       return helper(dp,coins,n-1, amount);
    }
    public int helper(int[][]dp, int[]coins, int idx1, int idx2 ){
        if(idx1==0){
            if(idx2%coins[idx1]==0){
                return 1;
            }
            return 0;
        }
        if(idx2==0){
            return 1;
        }
        if(dp[idx1][idx2]!=-1){
            return dp[idx1][idx2];
        }
        int notTake=helper(dp,coins,idx1-1,idx2);
        int take=0;
        if(coins[idx1]<=idx2){
            take=helper(dp, coins,idx1, idx2-coins[idx1]);
        }
        return dp[idx1][idx2]=take+notTake;
    }
}