class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int buy=1;
        int[][]dp=new int[n][2];
        for(int[]num: dp){
            Arrays.fill(num,-1);
        }
        return helper(dp,prices,fee,0,buy);
    }
    public int helper(int[][]dp, int[] prices, int fee, int index, int buy){
        if(index==prices.length){
            return 0;
        }
        if(dp[index][buy]!=-1){
            return dp[index][buy];
        }
        int profit=0;
        if(buy==1){
            profit= Math.max(-prices[index]+helper(dp,prices,fee,index+1,0), helper(dp,prices,fee,index+1,1));
        }
        else{
            profit=Math.max(prices[index]-fee+helper(dp,prices,fee,index+1,1),helper(dp,prices,fee,index+1,0));
        }
        return dp[index][buy]=profit;
    }
}