class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[]dp=new int[n];
        Arrays.fill(dp,-1);
        int min=Integer.MAX_VALUE;
        for(int i=n-1;i>=n-2;i--){
            min=Math.min(min,helper(cost,i,dp));
        }
        return min;
    }
    public int helper(int[]cost, int idx, int[]dp){
        if(idx<0){
            return 0;
        }
        if(idx<2){
            return cost[idx];
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int take=cost[idx]+Math.min(helper(cost,idx-1,dp) , helper(cost,idx-2,dp));

        return dp[idx]=take;
    }
}