class Solution {
    public int maxProfit(int k, int[] prices) {
        int buy=1;
        int n=prices.length;
        int[][][]dp=new int[n][2][k+1];
        for(int[][] price: dp){
            for(int[] nums: price){
                Arrays.fill(nums,-1);
            }
        }
        return helper(prices, k, buy, dp, 0);
    }
    public int helper(int[] prices, int cap, int buy, int[][][] dp, int idx){
        if(idx==prices.length){
            return 0;
        }
        if(cap==0){
            return 0;
        }
        if(dp[idx][buy][cap]!=-1){
            return dp[idx][buy][cap];
        }
        int profit=0;
        if(buy==1){
            profit=Math.max((-prices[idx]+ helper(prices, cap, 0, dp, idx+1)), (0 + helper(prices, cap, 1, dp, idx+1)));
        }
        else{
            profit=Math.max((prices[idx]+ helper(prices, cap-1, 1, dp, idx+1)), (0 + helper(prices, cap, 0,dp, idx+1)));
        }
        return dp[idx][buy][cap]=profit;
    }
}