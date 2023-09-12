class Solution {
    public int maxProfit(int[] prices) {
        int buy=1;
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int[] num:dp){
            Arrays.fill(num,-1);
        }
       int num= helper(buy,dp,prices,0);
        return num;
    }
    public int helper(int buy, int[][]dp, int[] prices, int index){
        if(index==prices.length){
            return 0;
        }
        if(dp[index][buy]!=-1){
            return dp[index][buy];
        }
        int profit=0;
        if(buy==1){
            profit=Math.max(0+ helper(1,dp,prices,index+1),-prices[index]+helper(0, dp, prices, index+1));
        }
        else{
            profit=Math.max(0+helper(0, dp,prices, index+1),prices[index]+helper(1,dp,prices, index+1));
        }
        return dp[index][buy]=profit;
    }
}