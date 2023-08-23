class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy=1;
        int[][] dp=new int[n][buy+1];
        for(int[] num:dp){
            Arrays.fill(num,-1);
        }
       return helper(prices,dp,0,1);
    }
    public int helper(int[] prices, int[][]dp, int index, int buy){
        if(index==prices.length){
            return 0;
        }
        if(dp[index][buy]!=-1){
            return dp[index][buy];
        }
        int profit=0;
        if(buy==1){
           profit=Math.max((-prices[index]+helper(prices,dp,index+1,0)),(helper(prices,dp,index+1,1)));
        }
        else{
             profit=Math.max((prices[index]+helper(prices,dp,index+1,1)),helper(prices,dp,index+1,0));
        }
        return dp[index][buy]=profit;
    }
}