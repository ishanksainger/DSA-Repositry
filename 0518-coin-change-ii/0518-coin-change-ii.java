class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][]dp=new int[n][amount+1];
        for(int[] nums: dp){
            Arrays.fill(nums, -1);
        }
      return  helper(amount,coins,dp, n-1);
    }
    public int helper(int target, int[]coins, int[][]dp, int idx){
        if(idx==0){
            if(target%coins[0]==0){
                return 1;
            }
            return 0;
        }
        if(target==0){
            return 1;
        }
        if(dp[idx][target]!=-1){
            return dp[idx][target];
        }

        int notTake=helper(target, coins, dp, idx-1);
        int take=0;
        if(coins[idx]<=target){
            take=helper(target-coins[idx], coins, dp, idx);
        }
        return dp[idx][target]=take+notTake;
    }
}